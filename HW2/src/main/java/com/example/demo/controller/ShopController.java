package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.entity.Shop;
import com.example.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/shop")
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public List<Shop> getAll() {
        return shopService.getAll();
    }


    @GetMapping(path = "/{id}")
    public Shop getSpecificShopById(@PathVariable("id") int id) {
        List<Product> productList = shopService.findShopsProductGreaterThan200(id);
        Shop shop =  shopService.getSpecificShop(id);
        shop.setProducts(productList);

        return shop;
    }


    @PostMapping
    public @ResponseBody Shop addShop(@RequestBody Shop shop) {
        shopService.addShop(shop);
        return shop;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody void deleteById(@PathVariable("id") int id) {
        shopService.deleteById(id);
    }
}
