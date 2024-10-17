package com.lb.product.sku.service.impl;

import com.lb.mall.entity.ProductSku;
import com.lb.product.sku.dao.ProductSkuMapper;
import com.lb.product.sku.service.ProductSkuQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSkuQueryServiceImpl implements ProductSkuQueryService {
    @Autowired
    private ProductSkuMapper productSkuMapper;

    @Override
    public ProductSku queryProductSku(String skuId) {
        return productSkuMapper.selectByPrimaryKey(skuId);
    }
}
