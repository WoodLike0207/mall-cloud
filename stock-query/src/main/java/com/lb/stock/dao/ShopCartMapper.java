package com.lb.stock.dao;

import com.lb.mall.entity.ShoppingCart;
import com.lb.mall.entity.ShoppingCartVO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

@Repository
public interface ShopCartMapper extends Mapper<ShoppingCart>, MySqlMapper<ShoppingCart> {
    List<ShoppingCartVO> selectShopcartByCids(List<Integer> list);
}
