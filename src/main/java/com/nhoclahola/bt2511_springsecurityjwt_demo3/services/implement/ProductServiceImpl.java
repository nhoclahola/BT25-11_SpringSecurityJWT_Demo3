package com.nhoclahola.bt2511_springsecurityjwt_demo3.services.implement;

import com.nhoclahola.bt2511_springsecurityjwt_demo3.entities.Product;
import com.nhoclahola.bt2511_springsecurityjwt_demo3.repositories.ProductRepository;
import com.nhoclahola.bt2511_springsecurityjwt_demo3.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService
{
    private final ProductRepository productRepository;


    @Override
    public void delete(Long id)
    {
        productRepository.deleteById(id);
    }

    @Override
    public Product get(Long id)
    {
        return productRepository.findById(id).get();
    }

    @Override
    public Product save(Product product)
    {
        return productRepository.save(product);
    }

    @Override
    public List<Product> listAll()
    {
        return productRepository.findAll();
    }
}
