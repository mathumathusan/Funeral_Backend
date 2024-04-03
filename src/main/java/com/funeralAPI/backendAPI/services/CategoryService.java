package com.funeralAPI.backendAPI.services;

import com.funeralAPI.backendAPI.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto getCategoryById(int id);

    List<CategoryDto> getAllCategories();

    CategoryDto updateCategory(int id, CategoryDto categoryDto);

    void deleteCategory(int id);

   
}
