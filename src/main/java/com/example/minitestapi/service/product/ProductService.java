package com.example.minitestapi.service.product;

import com.example.minitestapi.model.Product;
import com.example.minitestapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product save(Product object) {
        return productRepository.save(object);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
    @Override
    public List<Product> findAllByPriceGreaterThan300(){
        return productRepository.findAllByPriceGreaterThan300();
    }
    @Override
    public List<Product> findAllByNameContaining(String name){
        return productRepository.findAllByNameContaining(name);
    }
}
