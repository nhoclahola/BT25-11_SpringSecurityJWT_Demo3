package com.nhoclahola.bt2511_springsecurityjwt_demo3.repositories;

import com.nhoclahola.bt2511_springsecurityjwt_demo3.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{

}
