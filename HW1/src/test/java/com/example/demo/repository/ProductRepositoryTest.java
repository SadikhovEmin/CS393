package com.example.demo.repository;

import com.example.demo.entity.Product;
import com.example.demo.entity.Shop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    public void saveProduct() {
        Shop shop = new Shop();
        shop.setAddress("Address 1");
        shop.setName("Shop 1");

        Product product = new Product();
        product.setName("product 4");
        product.setShop(shop);
        product.setPrice(11.1);
        repository.save(product);

        assertTrue(product.getId() > 0);
    }

    @Test
    public void getProducts() {
        List<Product> products = repository.findAll();

        for (Product product : products)
            System.out.println("product = " + product.getId() +
                    " Name: " + product.getName());

        assertFalse(products.isEmpty());
    }


}