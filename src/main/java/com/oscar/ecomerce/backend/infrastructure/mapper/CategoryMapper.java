package com.oscar.ecomerce.backend.infrastructure.mapper;

import com.oscar.ecomerce.backend.domain.model.Category;
import com.oscar.ecomerce.backend.infrastructure.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
    })

    Category toCategory(CategoryEntity categoryEntity);
    Iterable<Category> toCategories(Iterable<CategoryEntity> categoryEntities);

    @InheritInverseConfiguration
    CategoryEntity toCategoryEntity(Category category);
    Iterable<CategoryEntity> toCategoryEntities(Iterable<Category> categories);
}
