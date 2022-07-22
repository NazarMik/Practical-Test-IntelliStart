package com.example.IntelliStartSpringBootProject.repository;

import com.example.IntelliStartSpringBootProject.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity,Long> {
}
