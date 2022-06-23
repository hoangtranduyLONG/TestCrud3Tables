package com.example.minitestapi.service.product;

import com.example.minitestapi.model.Product;

import com.example.minitestapi.service.GeneralService;

import java.util.List;

public interface IProductService extends GeneralService<Product> {
    List<Product> findAllByPriceGreaterThan300();

    List<Product> findAllByNameContaining(String name);
}
