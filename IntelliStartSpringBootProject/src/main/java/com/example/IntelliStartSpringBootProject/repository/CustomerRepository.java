package com.example.IntelliStartSpringBootProject.repository;

import com.example.IntelliStartSpringBootProject.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

    CustomerEntity findByLastname(String lastname);

}
