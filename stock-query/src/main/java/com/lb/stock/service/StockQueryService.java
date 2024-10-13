package com.lb.stock.service;

import com.lb.mall.entity.ShoppingCartVO;

import java.util.List;

public interface StockQueryService {
    List<ShoppingCartVO> selectShopcartByCids(String cids);
}
