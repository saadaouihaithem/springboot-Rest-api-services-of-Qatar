package com.springboot.ServicesOfQatar.service.impl;

import com.springboot.ServicesOfQatar.entity.Category;
import com.springboot.ServicesOfQatar.entity.Product;
import com.springboot.ServicesOfQatar.exception.BlogAPIException;
import com.springboot.ServicesOfQatar.exception.ResourceNotFoundException;
import com.springboot.ServicesOfQatar.payload.CategoryDto;
import com.springboot.ServicesOfQatar.repository.CategoryRepository;
import com.springboot.ServicesOfQatar.repository.ProductRepository;
import com.springboot.ServicesOfQatar.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;

public class CategoryServiceImpl implements CategoryService {


    private CategoryRepository categoryRepository;

    private ModelMapper mapper;
    private ProductRepository productRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper mapper, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
        this.productRepository = productRepository;
    }



    @Override
    public CategoryDto createCategory(long id ,CategoryDto categoryDto) {

        return null;
    }

    @Override
    public CategoryDto getCategoryById(long category_id) {
        return null;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, long  category_id) {
    return null;

    }

    @Override
    public void deleteCategoryById(long category_id, long id ) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product", "id", id));

        // retrieve comment by id
        Category category = categoryRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Comment", "id", id));

        if(!category.getProducts().equals(product.getId())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Category  does not belongs to this product");
        }

        categoryRepository.delete(category);
    }
}
