package com.example.demo.entity;

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

    @Column(name = "Name", nullable = false)
    public String name;

    @Column(name = "Address", nullable = false)
    public String address;

    /**
     * Relationships
     */
    @OneToMany(
            mappedBy = "shop",
            cascade = CascadeType.ALL
    )
    public List<Customer> customers = new ArrayList<>();

    @OneToMany(
            mappedBy = "shop",
            cascade = CascadeType.ALL
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
