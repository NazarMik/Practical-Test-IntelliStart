package com.example.IntelliStartSpringBootProject.controller;

import com.example.IntelliStartSpringBootProject.entity.OrderEntity;
import com.example.IntelliStartSpringBootProject.servise.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity createOrders(@RequestBody OrderEntity order,
                                       @RequestParam Long customerId){
        try {
        return ResponseEntity.ok(orderService.createOrders(order,customerId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping
    public ResponseEntity completeOrders(@RequestParam Long id){
        try {
            return ResponseEntity.ok(orderService.completeOrders(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
