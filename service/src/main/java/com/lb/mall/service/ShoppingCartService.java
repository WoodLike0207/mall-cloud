package com.lb.mall.service;

import com.lb.mall.beans.ShoppingCart;
import com.lb.mall.vo.ResultVo;

public interface ShoppingCartService {
    ResultVo addShoppingCart(ShoppingCart cart);

    ResultVo listShoppingCartByUserId(int userId);

    ResultVo updateCartNum(int cartId,int cartNum);

    ResultVo listShoppingCartsByCids(String cids);
}
