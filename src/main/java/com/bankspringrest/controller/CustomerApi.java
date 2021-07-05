package com.bankspringrest.controller;

import com.bankspringrest.dto.CustomerDto;
import com.bankspringrest.exception.BankException;
import com.bankspringrest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/bank")
public class CustomerApi {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() throws BankException {
        List<CustomerDto> customerList = customerService.getAllCustomers();
        return new ResponseEntity<>(customerList, HttpStatus.OK);

    }

    @GetMapping(value = "/customer/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Integer customerId) throws BankException {
        CustomerDto customer = customerService.getCustomer(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


}
