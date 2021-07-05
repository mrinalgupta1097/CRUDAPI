package com.bankspringrest.repository;

import com.bankspringrest.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository  extends CrudRepository<Customer,Integer> {
}
