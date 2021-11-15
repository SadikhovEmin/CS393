package com.example.demo.repository;

import com.example.demo.entity.Shop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
//@DataJpaTest      This will not update the database
class ShopRepositoryTest {

    @Autowired
    private ShopRepository repository;

    @Test
    public void saveShop() {
        Shop shop = new Shop("shop3", "shop2 address");
        repository.save(shop);

        assertTrue(shop.getId() > 0);
    }

    @Test
    public void getShops() {
        List<Shop> shopList = repository.findAll();

        for (Shop shop : shopList)
            System.out.println("shop = " + shop);

        assertFalse(shopList.isEmpty());
    }

    /**
     * Finds shops that's address contains specific characters
     */
    @Test
    public void getShopsAddressContains() {
        List<Shop> shopList = repository.findByAddressContains("2");

        for (Shop shop : shopList)
            System.out.println("shop = " + shop);

        assertFalse(shopList.isEmpty());
    }
}