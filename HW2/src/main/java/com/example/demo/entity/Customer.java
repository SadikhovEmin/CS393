package com.example.demo.entity;

import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customerSequence",
            sequenceName = "customerSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customerSequence"
    )
    private Integer id;

    @Column(name = "firstName", nullable = false, length = 20)
    public String firstName;

    @Column(name = "lastName", nullable = false, length = 20)
    public String lastName;


    /**
    Relationships
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "Shop_ID",
            nullable = false, referencedColumnName = "ID"
    )
    public Shop shop;

    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL
    )
    public List<Order> orderList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "Address_ID",
            nullable = false, referencedColumnName = "ID"
    )
    public Address address;


    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void addOrder(Order order) {
        orderList.add(order);
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

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", shop=" + shop +
                ", address=" + address +
                '}';
    }
}
