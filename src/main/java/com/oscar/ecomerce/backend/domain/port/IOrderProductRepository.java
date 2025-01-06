package com.oscar.ecomerce.backend.domain.port;

import com.oscar.ecomerce.backend.domain.model.OrderProduct;

public interface IOrderProductRepository {
    OrderProduct save(OrderProduct orderProduct);
    OrderProduct findById(Integer id);
    Iterable<OrderProduct> findAll();
}
