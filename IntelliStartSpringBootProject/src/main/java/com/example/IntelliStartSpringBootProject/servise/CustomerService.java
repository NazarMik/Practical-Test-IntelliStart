package com.example.IntelliStartSpringBootProject.servise;

import com.example.IntelliStartSpringBootProject.entity.CustomerEntity;
import com.example.IntelliStartSpringBootProject.exception.CustomerAlreadyExistsException;
import com.example.IntelliStartSpringBootProject.exception.CustomerNotFoundException;
import com.example.IntelliStartSpringBootProject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerEntity registration(CustomerEntity customer) throws CustomerAlreadyExistsException {
        if (customerRepository.findByLastname(customer.getLastname()) != null){
            throw new CustomerAlreadyExistsException("customer already exists!!!");
        }
        return customerRepository.save(customer);
    }

    public CustomerEntity getOne(Long id) throws CustomerNotFoundException {
        CustomerEntity customer =customerRepository.findById(id).get();
        if ( customer == null){
            throw new CustomerNotFoundException("Custoner not found!!!");
        }
        return customer;
    }

}
