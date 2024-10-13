package com.lb.stock.controller;

import com.lb.mall.entity.ProductSku;
import com.lb.stock.service.StockUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockUpdateController {

    @Autowired
    private StockUpdateService stockUpdateService;

    @PutMapping("/stock/update")
    public int update(@RequestBody List<ProductSku> skus){
        return stockUpdateService.updateStock(skus);
    }
}