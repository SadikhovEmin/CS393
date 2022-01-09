package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @SequenceGenerator(
            name = "orderSequence",
            sequenceName = "orderSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "orderSequence"
    )
    private Integer id;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date date;

    @Column(name = "Amount")
    public Double amount;

    /**
     * Relationsships
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(
            name = "Customer_ID",
            nullable = false,
            referencedColumnName = "ID"
    )
    public Customer customer;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "OrderProduct",
            joinColumns = @JoinColumn(name = "Order_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "Prod_ID", referencedColumnName = "ID")
    )
    public List<Product> productList = new ArrayList<>();

    public Order(Date date, Double amount) {
        this.date = date;
        this.amount = amount;
    }

    public Order() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", customer=" + customer +
                '}';
    }
}
