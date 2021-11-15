package com.example.demo.repository;

import com.example.demo.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository repository;

    @Test
    public void saveOrder() {
        Shop shop = new Shop("Yurt 2", "HZY");
        Address address = new Address("Address_Temp","City_Temp");
        Customer customer = new Customer("New name", "New last name");
        customer.setShop(shop);
        customer.setAddress(address);

        Product product = new Product("product 2", 100.0);
        product.setShop(shop);

        shop.addCustomer(customer);
        shop.addProduct(product);

        Order order = new Order(new Date(), 5.99);
        order.setCustomer(customer);
        order.addProduct(product);

        repository.save(order);

        assertTrue(order.getId() > 0);
    }

    @Test
    public void getOrders() {
        List<Order> orderList = repository.findAll();

        for (Order order : orderList)
            System.out.println("order = " + order);

        assertFalse(orderList.isEmpty());
    }

}