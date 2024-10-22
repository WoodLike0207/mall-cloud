package com.lb.order.service;

import com.github.wxpay.sdk.WXPay;
import com.lb.mall.beans.Orders;
import com.lb.order.config.MyPayConfig;
import com.lb.order.feign.OrderCloseClient;
import com.lb.order.feign.OrderStatusUpdateClient;
import com.lb.order.feign.OrderTimeoutQueryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrderTimeoutCancelJob {
    @Autowired
    private OrderTimeoutQueryClient orderTimeoutQueryClient;
    private WXPay wxPay = new WXPay(new MyPayConfig());
    @Autowired
    private OrderStatusUpdateClient orderStatusUpdateClient;
    @Autowired
    private OrderCloseClient orderCloseClient;

    @Scheduled(cron = "0/3 * * * * ?")
    public void checkAndCancelOrder(){
        try {
            List<Orders> orders = orderTimeoutQueryClient.query();

            for (int i = 0; i < orders.size(); i++) {
                Orders order = orders.get(i);
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

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
