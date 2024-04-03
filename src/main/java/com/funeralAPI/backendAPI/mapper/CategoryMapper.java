package com.funeralAPI.backendAPI.mapper;

import com.funeralAPI.backendAPI.dto.CategoryDto;
import com.funeralAPI.backendAPI.entity.Category;

public class CategoryMapper {

    public static Category mapToCategory(CategoryDto categoryDto) {
        return new Category(
                categoryDto.getCategory_id(),
                categoryDto.getPerson_id(),
                categoryDto.getCategory()
        );
    }

    public static CategoryDto mapToCategoryDto(Category category) {
        return new CategoryDto(
                category.getCategory_id(),
                category.getPerson_id(),
                category.getCategory()
        );
    }
}
