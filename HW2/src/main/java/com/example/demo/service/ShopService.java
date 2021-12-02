package com.example.demo.service;

import com.example.demo.entity.Shop;
import com.example.demo.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    private final ShopRepository repository;

    @Autowired
    public ShopService(ShopRepository repository) {
        this.repository = repository;
    }

    public List<Shop> getAll() {
        return repository.findAll();
    }

    public void deleteById(int id) {
         repository.deleteById(id);
    }

    public List<Shop> getSpecificShop(int id) {
        return repository.getSpecificShop(id);
    }

    public void addShop(Shop shop) {
        repository.save(shop);
    }
}
