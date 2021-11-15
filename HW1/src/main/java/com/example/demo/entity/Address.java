package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {

    @Id
    @SequenceGenerator(
            name = "addressSequence",
            sequenceName = "addressSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "addressSequence"
    )
    private Integer id;

    @Column(name = "text")
    public String text;

    @Column(name = "city")
    public String city;


    public Address(String text, String city) {
        this.text = text;
        this.city = city;
    }

    public Address() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
