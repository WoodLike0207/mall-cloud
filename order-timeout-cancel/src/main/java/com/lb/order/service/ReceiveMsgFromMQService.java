package com.lb.order.service;

import com.github.wxpay.sdk.WXPay;
import com.lb.mall.beans.Orders;
import com.lb.order.config.MyPayConfig;
import com.lb.order.feign.OrderCloseClient;
import com.lb.order.feign.OrderQueryByIdClient;
import com.lb.order.feign.OrderStatusUpdateClient;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@RabbitListener(queues = "q2")
public class ReceiveMsgFromMQService {
    private WXPay wxPay = new WXPay(new MyPayConfig());
    @Autowired
    private OrderStatusUpdateClient orderStatusUpdateClient;
    @Autowired
    private OrderCloseClient orderCloseClient;
    @Autowired
    private OrderQueryByIdClient orderQueryByIdClient;

    @RabbitHandler
    public void checkAndCancelOrder(String orderId, Channel channel, Message message) throws IOException {
        try {
            // 1.根据订单编号查询当前的订单信息
            Orders order = orderQueryByIdClient.query(orderId);

            if ("1".equals(order.getStatus())){
                HashMap<String,String> params = new HashMap<>();
                params.put("out_trade_no",order.getOrderId());
                Map<String, String> resp = wxPay.orderQuery(params);

                if ("SUCCESS".equalsIgnoreCase(resp.get("trade_state"))){
                    // 2.1 如果订单已支付，则修改订单状态为“代发货/已支付” status = 2
                    Orders updateOrder = new Orders();
                    updateOrder.setOrderId(order.getOrderId());
                    updateOrder.setStatus("2");

                    orderStatusUpdateClient.update(updateOrder);
                }else if ("NOTPAY".equalsIgnoreCase(resp.get("trade_state"))){

                    // 2.2 如果确实未支付，取消订单:
                    // a.向微信支付平台发送请求，关闭当前订单的支付链接
                    //Map<String, String> map = wxPay.closeOrder(params);

                    // b.关闭订单
                    orderCloseClient.close(order.getOrderId(),1);
                }
            }

            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);

        }catch (Exception e){
            e.printStackTrace();
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
        }
    }
}
