package com.example.demo.repository;


import com.example.demo.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class AddressRepositoryTest {

    @Autowired
    private AddressRepository repository;

    @Test
    public void saveAddress() {
        Address address = new Address("Cekmekoy", "Istanbul");
        repository.save(address);

        assertTrue(address.getId() > 0);
    }

    @Test
    public void getAddress() {
        List<Address> addresses = repository.findAll();

        for (Address address : addresses)
            System.out.println("address = " + address);

        assertFalse(addresses.isEmpty());
    }
}