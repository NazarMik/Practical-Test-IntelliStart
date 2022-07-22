package com.example.IntelliStartSpringBootProject.servise;

import com.example.IntelliStartSpringBootProject.entity.CustomerEntity;
import com.example.IntelliStartSpringBootProject.entity.OrderEntity;
import com.example.IntelliStartSpringBootProject.repository.CustomerRepository;
import com.example.IntelliStartSpringBootProject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;

    public OrderEntity createOrders(OrderEntity order, Long customerId){
        CustomerEntity customer = customerRepository.findById(customerId).get();
        order.setCustomer(customer);
        return orderRepository.save(order);
    }

    public OrderEntity completeOrders(Long id){
        OrderEntity order = orderRepository.findById(id).get();
        order.setCompleted(!order.isCompleted());
        return orderRepository.save(order);

    }


}
