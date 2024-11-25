package com.nhoclahola.bt2511_springsecurityjwt_demo3.services;

import com.nhoclahola.bt2511_springsecurityjwt_demo3.entities.Product;

import java.util.List;

public interface ProductService
{
    void delete(Long id);

    Product get(Long id);

    Product save(Product product);

    List<Product> listAll();
}
