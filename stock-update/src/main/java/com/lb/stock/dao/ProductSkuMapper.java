package com.lb.stock.dao;

import com.lb.mall.entity.ProductSku;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface ProductSkuMapper extends Mapper<ProductSku>, MySqlMapper<ProductSku> {
}
