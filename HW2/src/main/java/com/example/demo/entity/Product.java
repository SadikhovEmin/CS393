package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @SequenceGenerator(
            name = "productSequence",
            sequenceName = "productSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "productSequence"
    )
    private Integer id;

    @Column(name = "Name", length = 20)
    public String name;

    @Column(name = "Price")
    public Double price;

    /**
     * Relationships
     */
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Shop_ID", nullable = false, referencedColumnName = "ID")
    public Shop shop;

    @JsonIgnore
    @ManyToMany(mappedBy = "productList", cascade = CascadeType.ALL)
    public List<Order> orderList = new ArrayList<>();

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }


    public Product() {

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void addOrder(Order order) {
        this.orderList.add(order);
    }

    public Shop getShop() {
        return shop;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", shop=" + shop +
                '}';
    }
}


