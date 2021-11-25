package com.example.demo.repository;

import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Shop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void saveCustomer() {
        Shop shop = new Shop("Nero", "Center");
        Address address = new Address("Iceriseher", "Baku");
//        Address address = addressRepository.getById(1);

        Customer customer = new Customer("firstName 1", "lastName 1");
        customer.setShop(shop);
        customer.setAddress(address);
        repository.save(customer);

        assertTrue(customer.getId() > 0);
    }

    @Test
    public void getCustomer() {
        List<Customer> customerList = repository.findAll();

        for (Customer customer : customerList)
            System.out.println("customer = " + customer);

        assertFalse(customerList.isEmpty());
    }
}