package com.mista.soft.entity;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="CustomerName")
    private String name;
    @Column(name="Email")
    private String email;
    @Column(name="Adress")
    private String adress;

    public Customer() {
    }

    public Customer(String name, String email, String adress) {
        this.name = name;
        this.email = email;
        this.adress = adress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}

