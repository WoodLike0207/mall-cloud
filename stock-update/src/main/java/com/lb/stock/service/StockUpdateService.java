package com.lb.stock.service;

import com.lb.mall.entity.ProductSku;

import java.util.List;

public interface StockUpdateService {

    int updateStock(List<ProductSku> skus);

}