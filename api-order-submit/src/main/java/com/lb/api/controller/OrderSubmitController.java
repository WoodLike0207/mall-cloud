package com.lb.api.controller;

import com.github.wxpay.sdk.WXPay;
import com.lb.api.config.MyPayConfig;
import com.lb.api.service.OrderSubmitService;
import com.lb.api.service.feign.OrderAddClient;
import com.lb.mall.beans.Orders;
import com.lb.mall.vo.RespStatus;
import com.lb.mall.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderSubmitController {

    @Autowired
    private OrderAddClient orderAddClient;
    @Autowired
    private OrderSubmitService orderSubmitService;

    @PostMapping("/add")
    public ResultVo add(String cids, @RequestBody Orders order){
        ResultVo resultVO = null;
        try {
            Map<String, String> orderInfo = orderSubmitService.addOrder(cids, order);

            if(orderInfo!=null){
                String orderId = orderInfo.get("orderId");
                //设置当前订单信息
                HashMap<String,String> data = new HashMap<>();
                data.put("body",orderInfo.get("productNames"));  //商品描述
                data.put("out_trade_no",orderId);               //使用当前用户订单的编号作为当前支付交易的交易号
                data.put("fee_type","CNY");                     //支付币种
                //data.put("total_fee",order.getActualAmount()*100+"");          //支付金额
                data.put("total_fee","1");
                data.put("trade_type","NATIVE");                //交易类型
                //data.put("notify_url","http://47.118.45.73:8080/pay/callback");           //设置支付完成时的回调方法接口
                data.put("notify_url","http://localhost:8080/pay/callback");           //设置支付完成时的回调方法接口


                //发送请求，获取响应
                //微信支付：申请支付连接
                WXPay wxPay = new WXPay(new MyPayConfig());
                Map<String, String> resp = wxPay.unifiedOrder(data);
                orderInfo.put("payUrl",resp.get("code_url"));
                //orderInfo中包含：订单编号，购买的商品名称，支付链接
                resultVO = new ResultVo(RespStatus.OK,"提交订单成功！",orderInfo);

            }else{
                resultVO = new ResultVo(RespStatus.NO,"提交订单失败！",null);
            }
        } catch (SQLException e) {
            resultVO = new ResultVo(RespStatus.NO,"提交订单失败！",null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultVO;
    }
}
