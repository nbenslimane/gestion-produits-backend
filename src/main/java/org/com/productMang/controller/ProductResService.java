package org.com.productMang.controller;

import org.com.productMang.dao.ProductRepository;
import org.com.productMang.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductResService {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = "/allProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @GetMapping(value = "/allProducts/{id}")
    public Product getOneProduct(@PathVariable(name = "id") Long id) {
        return productRepository.findById(id).get();
    }

    @PutMapping(value = "/allProducts/{id}")
    public Product putOneProduct(@PathVariable(name = "id") Long id, @RequestBody Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    @PostMapping(value = "/allProducts")
    public Product postOneProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
    @DeleteMapping(value = "/allProducts/{id}")
    public void deleteOneProduct(@PathVariable(name = "id") Long id, @RequestBody Product product) {
         productRepository.deleteById(id);
    }
}
