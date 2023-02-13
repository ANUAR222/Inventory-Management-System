package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class person {
    private final UUID id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;


    public String getPassword() {
        return password;
    }

    public person(@JsonProperty("name") String name, @JsonProperty("email") String email, @JsonProperty("password") String password, String phone, String address) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public void setPassword(String pasword) {
        this.password = pasword;
    }


}