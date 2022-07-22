package com.example.IntelliStartSpringBootProject.controller;

import com.example.IntelliStartSpringBootProject.entity.CustomerEntity;
import com.example.IntelliStartSpringBootProject.exception.CustomerAlreadyExistsException;
import com.example.IntelliStartSpringBootProject.exception.CustomerNotFoundException;
import com.example.IntelliStartSpringBootProject.repository.CustomerRepository;
import com.example.IntelliStartSpringBootProject.servise.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    ResponseEntity registration(@RequestBody CustomerEntity customer){
        try {
            customerService.registration(customer);
            return ResponseEntity.ok("customer is save!");
        }catch (CustomerAlreadyExistsException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping
    ResponseEntity getOneCustomer(@RequestParam Long id){
        try {
            return ResponseEntity.ok(customerService.getOne(id));
        } catch (CustomerNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
