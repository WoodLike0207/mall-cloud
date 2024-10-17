package com.lb.order.service.impl;

import com.lb.mall.beans.OrderItem;
import com.lb.mall.beans.Orders;
import com.lb.mall.beans.ProductSku;
import com.lb.order.service.OrderCloseService;
import com.lb.order.service.feign.OrderItemQueryClient;
import com.lb.order.service.feign.OrderStatusUpdateClient;
import com.lb.order.service.feign.ProductSkuQueryClient;
import com.lb.order.service.feign.StockUpdateClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderCloseServiceImpl implements OrderCloseService {
    @Autowired
    private OrderStatusUpdateClient orderStatusUpdateClient;
    @Autowired
    private OrderItemQueryClient orderItemQueryClient;
    @Autowired
    private ProductSkuQueryClient productSkuQueryClient;
    @Autowired
    private StockUpdateClient stockUpdateClient;

    @Override
    public int closeOrder(String orderId,int closeType) {
        Orders order = new Orders();
        order.setOrderId(orderId);
        order.setStatus("6");
        order.setCloseType(closeType);
        int i = orderStatusUpdateClient.update(order);

        if (i > 0){
            List<OrderItem> orderItems = orderItemQueryClient.query(orderId);

            if (orderItems != null && !orderItems.isEmpty()){
                List<ProductSku> skus = new ArrayList<>();
                for (OrderItem item : orderItems) {
                    String skuId = item.getSkuId();
                    ProductSku sku = productSkuQueryClient.query(skuId);
                    int newStock = sku.getStock() + item.getBuyCounts();
                    sku.setStock(newStock);
                    skus.add(sku);
                }
                int j = stockUpdateClient.update(skus);
                return j;
            }

        }

        return 0;
    }
}
