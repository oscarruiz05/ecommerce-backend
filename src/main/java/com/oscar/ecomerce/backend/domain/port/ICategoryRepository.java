package com.oscar.ecomerce.backend.domain.port;

import com.oscar.ecomerce.backend.domain.model.Category;

public interface ICategoryRepository {
    Iterable<Category> findAll();
    Category save(Category category);
    Category findById(Integer id);
    Category update(Category category, Integer id);
    void delete(Integer id);
}
