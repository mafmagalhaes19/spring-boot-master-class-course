package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;

//Customer Service is a singleton
@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    //Replaced by log.info() -> @Slf4j
    /*private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);*/

    private final CustomerRepository customerRepository;

    /*@Autowired
    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepository = customerRepo;
    }*/

    List<Customer> getCustomers() {
        log.info("getCustomers was called");
        return customerRepository.findAll();
    }

    Customer getCustomer( Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(
                        () -> {
                    NotFoundException notFoundException = new NotFoundException("Customer with id " + id + " not found");
                    log.error("Error in getting customer {}", id, notFoundException);
                    return notFoundException;
                });
    }

}
