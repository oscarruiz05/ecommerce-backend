package com.oscar.ecomerce.backend.infrastructure.adapter;

import com.oscar.ecomerce.backend.domain.model.Order;
import com.oscar.ecomerce.backend.domain.model.OrderState;
import com.oscar.ecomerce.backend.domain.port.IOrderRepository;
import com.oscar.ecomerce.backend.infrastructure.entity.OrderEntity;
import com.oscar.ecomerce.backend.infrastructure.entity.UserEntity;
import com.oscar.ecomerce.backend.infrastructure.mapper.OrderMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class OrderCrudRepositoryImpl implements IOrderRepository {

    private final IOrderCrudRepository orderCrudRepository;
    private final OrderMapper orderMapper;

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = orderMapper.toOrderEntity(order);
        orderEntity.getOrderProducts().forEach(orderProductEntity -> orderProductEntity.setOrder(orderEntity));
        return orderMapper.toOrder(orderCrudRepository.save(orderEntity));
    }

    @Override
    public Order findById(Integer id) {
        return orderMapper.toOrder(orderCrudRepository.findById(id).orElse(null));
    }

    @Override
    public Iterable<Order> findAll() {
        return orderMapper.toOrderList(orderCrudRepository.findAll());
    }

    @Override
    public Iterable<Order> findByUserId(Integer userId) {
        return orderMapper.toOrderList(orderCrudRepository.findByUserId(userId));
    }

    @Override
    public void updateStateById(Integer id, String state) {
        orderCrudRepository.updateStateById(id, state.equals(OrderState.CANCELLED) ? OrderState.CANCELLED : OrderState.CONFIRMED);
    }
}
