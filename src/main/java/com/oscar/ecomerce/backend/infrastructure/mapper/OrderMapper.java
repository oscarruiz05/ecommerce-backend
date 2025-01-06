package com.oscar.ecomerce.backend.infrastructure.mapper;

import com.oscar.ecomerce.backend.domain.model.Order;
import com.oscar.ecomerce.backend.infrastructure.entity.OrderEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {OrderProductMapper.class})
public interface OrderMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "orderProducts", target = "orderProducts"),
            @Mapping(source = "orderState", target = "orderState"),
            @Mapping(source = "user.id", target = "userId"),
    })

    Order toOrder(OrderEntity orderEntity);
    Iterable<Order> toOrderList(Iterable<OrderEntity> orderEntities);

    @InheritInverseConfiguration
    OrderEntity toOrderEntity(Order order);
}
