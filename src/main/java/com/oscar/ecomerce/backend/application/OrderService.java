package com.oscar.ecomerce.backend.application;

import com.oscar.ecomerce.backend.domain.model.Order;
import com.oscar.ecomerce.backend.domain.model.OrderState;
import com.oscar.ecomerce.backend.domain.port.IOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {
    private final IOrderRepository orderRepository;

    public Order save(Order order) {
        if (order.getOrderState().toString().equals(OrderState.CANCELLED.toString())) {
            order.setOrderState(OrderState.CANCELLED);
        } else {
            order.setOrderState(OrderState.CONFIRMED);
        }
        return orderRepository.save(order);
    }

    public Order findById(Integer id) {
        return orderRepository.findById(id);
    }

    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    public Iterable<Order> findByUserId(Integer userId) {
        return orderRepository.findByUserId(userId);
    }

    public void updateStateById(Integer id, String state) {
        orderRepository.updateStateById(id, state);
    }
}
