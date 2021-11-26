package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Shop")
public class Shop {

    @Id
    @SequenceGenerator(
            name = "shopSequence",
            sequenceName = "shopSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "shopSequence"
    )
    private Integer id;

    @Column(name = "Name", nullable = false, length = 20)
    public String name;

    @Column(name = "Address", nullable = false, length = 70)
    public String address;

    /**
     * Relationships
     */
    @JsonIgnore
    @OneToMany(
            mappedBy = "shop"
    )
    public List<Customer> customers = new ArrayList<>();

    @OneToMany(
            mappedBy = "shop"
    )
    public List<Product> products = new ArrayList<>();

    public Shop(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Shop() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
