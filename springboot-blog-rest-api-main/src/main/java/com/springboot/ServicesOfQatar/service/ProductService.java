package com.springboot.ServicesOfQatar.service;

import com.springboot.ServicesOfQatar.payload.ProductDto;
import com.springboot.ServicesOfQatar.payload.ProductResponse;

public interface ProductService {
    ProductDto createProduct( ProductDto productDto);

    ProductResponse getAllProducts(int pageNo, int pageSize, String sortBy, String sortDir);

    ProductDto getProductById(long id);

    ProductDto updateProduct(ProductDto productDto, Long id);

    void deleteProduct( Long id);

}
