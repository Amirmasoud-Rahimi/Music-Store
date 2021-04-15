package com.demisco.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.demisco.project.model.Orders;

@Repository
public interface OrderRepo extends CrudRepository<Orders, Integer> {
}