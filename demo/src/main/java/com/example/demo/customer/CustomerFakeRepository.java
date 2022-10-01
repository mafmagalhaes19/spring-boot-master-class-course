package com.example.demo.customer;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo{

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "James Bond", "12345", "email@gmail.com"),
                new Customer(2L, "Jamila Ahmed", "12345", "email@gmail.com")
                );
    }
}
