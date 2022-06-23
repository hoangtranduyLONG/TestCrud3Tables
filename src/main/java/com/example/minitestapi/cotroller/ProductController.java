package com.example.minitestapi.cotroller;

import com.example.minitestapi.model.Product;
import com.example.minitestapi.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity( productService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Product product) {
        return new ResponseEntity( productService.save(product), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return new ResponseEntity( productService.findById(id).get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            product.setId(id);
            productService.save(product);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity edit(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            productService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/greater-than-300")
    public ResponseEntity findAllByPriceGreaterThan300() {
        return new ResponseEntity( productService.findAllByPriceGreaterThan300(), HttpStatus.OK);
    }
    @GetMapping("/find-by-name")
    public ResponseEntity findAllByNameContaining(@RequestParam String name) {
        return new ResponseEntity( productService.findAllByNameContaining(name), HttpStatus.OK);
    }
}