package com.example.minitestapi.repository;

import com.example.minitestapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
   Iterable<Product> findAllByOrderByPriceAsc();
}
