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
        Shop shop = new Shop("Yemekhane", "university");
        Address address = new Address("ozyegin","cekmeyok");
        Customer customer = new Customer("emin", "sadikhov");
        customer.setShop(shop);
        customer.setAddress(address);

        Product product = new Product("corba", 20.0);
        product.setShop(shop);

        shop.addCustomer(customer);
        shop.addProduct(product);

        Order order = new Order(new Date(), 30.0);
        order.setCustomer(customer);
//        order.addProduct(product);
        order.getProductList().add(product);
//        product.addOrder(order);
        product.getOrderList().add(order);
        customer.getOrderList().add(order);

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