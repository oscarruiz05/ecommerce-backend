package com.oscar.ecomerce.backend.infrastructure.adapter;

import com.oscar.ecomerce.backend.infrastructure.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
    List<ProductEntity> findByCategoryId(Integer categoryId);
    List<ProductEntity> findByUserId(Integer userId);
    Optional<ProductEntity> findByCode(String code);
    Optional<ProductEntity> findByCodeAndIdNot(String code, Integer id);
    boolean existsByCode(String code);
    boolean existsByCodeAndIdNot(String code, Integer id);
}
