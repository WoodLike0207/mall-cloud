package com.lb.stock.service.impl;

import com.lb.mall.entity.ShoppingCartVO;
import com.lb.stock.dao.ShopCartMapper;
import com.lb.stock.service.StockQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockQueryServiceImpl implements StockQueryService {
    @Autowired
    private ShopCartMapper shopCartMapper;

    @Override
    public List<ShoppingCartVO> selectShopcartByCids(String cids) {
        String[] split = cids.split(",");
        List<Integer> cidList = new ArrayList<>();
        for (String s : split) {
            cidList.add(Integer.parseInt(s));
        }
        List<ShoppingCartVO> list = shopCartMapper.selectShopcartByCids(cidList);
        return list;
    }
}
