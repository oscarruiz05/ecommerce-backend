package com.oscar.ecomerce.backend.infrastructure.mapper;

import com.oscar.ecomerce.backend.domain.model.Product;
import com.oscar.ecomerce.backend.infrastructure.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "image", target = "image"),
            @Mapping(source = "category.id", target = "categoryId"),
            @Mapping(source = "user.id", target = "userId"),
    })

    Product toProduct(ProductEntity product);
    Iterable<Product> toProducts(Iterable<ProductEntity> products);

    @InheritInverseConfiguration
    ProductEntity toProductEntity(Product product);
}
