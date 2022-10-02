package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class Customer {

    @Id
    private Long id;
    @NotBlank(message = "name must be not empty")
    private String name;
    //Allows us to send a password through a POST request, but not read a password through a GET request
    @NotBlank(message = "password must be not empty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotBlank(message = "email must be not empty")
    @Email
    private String email;

    Customer(Long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public Customer(){
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

    public String getEmail(){
        return email;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name='" + name + '\'' + ", password='" + password + '\'' + ", email='" + email + '\'' + '}';
    }
}
