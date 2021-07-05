package com.bankspringrest.service;

import com.bankspringrest.dto.CustomerDto;
import com.bankspringrest.exception.BankException;

import java.util.List;


public interface CustomerService {
    CustomerDto getCustomer(Integer customerId) throws BankException;

    List<CustomerDto> getAllCustomers() throws BankException;

}
