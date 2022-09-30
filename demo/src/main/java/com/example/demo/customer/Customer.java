package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
    private final Long id;
    private final String name;
    //Allows us to send a password through a POST request, but not read a password through a GET request
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private final String password;

    Customer(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @JsonProperty("customerId")
    public Long getId() {
        return id;
    }

    //Spring returns a customerId
    /*public Long getCustomerId() {
        return id;
    }*/

    public String getName() {
        return name;
    }

    @JsonIgnore
    public String getPassword(){
        return password;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name='" + name + '\'' + ", password='" + password + '\'' + '}';
    }
}
