package com.oscar.ecomerce.backend.infrastructure.adapter;

import com.oscar.ecomerce.backend.domain.model.OrderState;
import com.oscar.ecomerce.backend.infrastructure.entity.OrderEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IOrderCrudRepository extends CrudRepository<OrderEntity, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE OrderEntity o SET o.orderState = :state WHERE o.id = :id")
    void updateStateById(Integer id, OrderState state);

    Iterable<OrderEntity> findByUserId(Integer userId);
}
