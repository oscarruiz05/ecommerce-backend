package com.oscar.ecomerce.backend.infrastructure.adapter;

import com.oscar.ecomerce.backend.infrastructure.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryCrudRepository extends CrudRepository<CategoryEntity, Integer> {
    CategoryEntity findByName(String name);
}
