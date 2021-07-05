package com.bankspringrest.service;

import com.bankspringrest.dto.CustomerDto;
import com.bankspringrest.entity.Customer;
import com.bankspringrest.exception.BankException;
import com.bankspringrest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value = "customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public CustomerDto getCustomer(Integer customerId) throws BankException {

        Optional<Customer> optional = customerRepository.findById(customerId);
        Customer customer = optional.orElseThrow(() ->
            new BankException("Service.CUSTOMER_NOT_FOUND"));

        CustomerDto customer2 = new CustomerDto();
        customer2.setCustomerId(customer.getCustomerId());
        customer2.setEmailId(customer.getEmailId());
        customer2.setName(customer.getName());
        customer2.setDateOfBirth(customer.getDateOfBirth());

        return customer2;
    }

    @Override
    public List<CustomerDto> getAllCustomers() throws BankException {

        Iterable<Customer> customers = customerRepository.findAll();//iterable allows an csutomers to be an object of enchanced for loop

//        create a list which contains the customers received from db
        List<CustomerDto> customer2 = new ArrayList<>();

/*
        for each customer retrieve the attributes
        and create a corresponding DTO which will be added to list
*/
        customers.forEach(customer -> {
//            create dto
            CustomerDto custDto = new CustomerDto();
//            set dto properties
            custDto.setCustomerId(customer.getCustomerId());
            custDto.setEmailId(customer.getEmailId());
            custDto.setName(customer.getName());
            custDto.setDateOfBirth(customer.getDateOfBirth());
//            add dto to list
            customer2.add(custDto);
        });
//        check for empty list of customers if empty throw exception
        if(customer2.isEmpty())
            throw new BankException(("Service.CUSTOMERS_NOT_FOUND"));
//        return list
        return customer2;
    }
}
