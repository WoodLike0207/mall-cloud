package com.lb.stock.service.impl;

import com.lb.mall.entity.ProductSku;
import com.lb.stock.dao.ProductSkuMapper;
import com.lb.stock.service.StockUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockUpdateServiceImpl implements StockUpdateService {

    @Autowired
    private ProductSkuMapper productSkuMapper;

    @Override
    public int updateStock(List<ProductSku> skus) {
        int j = 1;
        for (ProductSku productSku: skus) {
            int i = productSkuMapper.updateByPrimaryKeySelective(productSku);
            j *=i;
        }
        return j;
    }
}