package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.entity.Shop;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.repository = productRepository;
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public void addProduct(Product product) {
        repository.save(product);
    }
}
