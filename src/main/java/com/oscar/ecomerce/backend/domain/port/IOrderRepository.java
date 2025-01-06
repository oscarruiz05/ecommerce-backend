package com.oscar.ecomerce.backend.domain.port;

import com.oscar.ecomerce.backend.domain.model.Order;
import com.oscar.ecomerce.backend.domain.model.OrderState;

public interface IOrderRepository {
    Order save(Order order);
    Order findById(Integer id);
    Iterable<Order> findAll();
    Iterable<Order> findByUserId(Integer userId);
    void updateStateById(Integer id, String state);
}
