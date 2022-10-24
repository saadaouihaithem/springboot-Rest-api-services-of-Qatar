package com.springboot.ServicesOfQatar.service;

import com.springboot.ServicesOfQatar.payload.CategoryDto;



public interface CategoryService {
    CategoryDto createCategory(long id ,CategoryDto categoryDto);

    CategoryDto getCategoryById(long category_id);

    CategoryDto updateCategory(CategoryDto categoryDto, long category_id);

    void deleteCategoryById(long category_id, long id );
}
