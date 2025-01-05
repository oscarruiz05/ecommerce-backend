package com.oscar.ecomerce.backend.infrastructure.entity;

import com.oscar.ecomerce.backend.domain.model.OrderProduct;
import com.oscar.ecomerce.backend.domain.model.OrderState;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @CreationTimestamp
    private LocalDateTime date;
    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    @ManyToOne
    private UserEntity user;
    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
    private List<OrderProductEntity> orderProducts;
}
