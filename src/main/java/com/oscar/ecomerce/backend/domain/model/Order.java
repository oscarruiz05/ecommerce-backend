package com.oscar.ecomerce.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer id;
    private LocalDateTime date;
    private List<OrderProduct> orderProducts;
    private OrderState orderState;
    private Integer userId;

    public BigDecimal getTotalOrderPrice() {
        return orderProducts.stream()
                .map(OrderProduct::getTotalItem)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
