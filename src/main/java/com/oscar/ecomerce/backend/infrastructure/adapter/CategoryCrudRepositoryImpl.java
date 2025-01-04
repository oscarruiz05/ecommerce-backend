package com.oscar.ecomerce.backend.infrastructure.adapter;

import com.oscar.ecomerce.backend.domain.model.Category;
import com.oscar.ecomerce.backend.domain.port.ICategoryRepository;
import com.oscar.ecomerce.backend.infrastructure.mapper.CategoryMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryCrudRepositoryImpl implements ICategoryRepository {
    private final ICategoryCrudRepository categoryCrudRepository;
    private final CategoryMapper categoryMapper;

    public CategoryCrudRepositoryImpl(ICategoryCrudRepository categoryCrudRepository, CategoryMapper categoryMapper) {
        this.categoryCrudRepository = categoryCrudRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Iterable<Category> findAll() {
        return categoryMapper.toCategories(categoryCrudRepository.findAll());
    }

    @Override
    public Category save(Category category) {
        return categoryMapper.toCategory(categoryCrudRepository.save(categoryMapper.toCategoryEntity(category)));
    }

    @Override
    public Category findById(Integer id) {
        return categoryMapper.toCategory(categoryCrudRepository.findById(id).orElse(null));
    }

    @Override
    public Category update(Category category, Integer id) {
        return categoryCrudRepository.findById(id)
                .map(categoryEntity -> {
                    categoryEntity.setName(category.getName());
                    return categoryMapper.toCategory(categoryCrudRepository.save(categoryEntity));
                })
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public void delete(Integer id) {
        categoryCrudRepository.deleteById(id);
    }
}
