package com.oscar.ecomerce.backend.application;

import com.oscar.ecomerce.backend.domain.model.Category;
import com.oscar.ecomerce.backend.domain.port.ICategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category findById(Integer id) {
        return categoryRepository.findById(id);
    }

    public Category update(Category category, Integer id) {
        return categoryRepository.update(category, id);
    }

    public void delete(Integer id) {
        categoryRepository.delete(id);
    }
}
