package com.springboot.ServicesOfQatar.service.impl;


import com.springboot.ServicesOfQatar.entity.Product;
import com.springboot.ServicesOfQatar.exception.ResourceNotFoundException;

import com.springboot.ServicesOfQatar.payload.ProductDto;
import com.springboot.ServicesOfQatar.payload.ProductResponse;

import com.springboot.ServicesOfQatar.repository.ProductRepository;
import com.springboot.ServicesOfQatar.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductServiceImpl implements ProductService {




    private ProductRepository productRepository;

    private ModelMapper mapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public ProductDto createProduct( ProductDto productDto) {
        Product product = mapToEntity(productDto);
        Product newProduct = productRepository.save(product);

        // convert entity to DTO
        ProductDto ProductResponse = mapToDTO(newProduct);
        return ProductResponse;
    }


    @Override
    public ProductResponse getAllProducts(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Product> products = productRepository.findAll(pageable);

        // get content for page object
        List<Product> listOfProducts = products.getContent();

        List<ProductDto> content= listOfProducts.stream().map(product -> mapToDTO(product)).collect(Collectors.toList());

        ProductResponse productResponse = new ProductResponse();
        productResponse.getTitle();
        productResponse.getAddress();
        productResponse.getCategory_id();
        productResponse.getEmail();
        productResponse.getCreated_at();
        productResponse.setContent(content);
        productResponse.setPageNo(products.getNumber());
        productResponse.setPageSize(products.getSize());
        productResponse.setTotalElements(products.getTotalElements());
        productResponse.setTotalPages(products.getTotalPages());
        productResponse.setLast(products.isLast());

        return productResponse;
    }

    @Override
    public ProductDto getProductById(long id) {
        return null;
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Long id) {
        // get product by id from the database
        Product product=productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));

        product.setTitle(productDto.getTitle());
        product.setTitle_ar(productDto.getTitle_ar());
        product.setDescription(productDto.getDescription());
        product.setDescription_ar(productDto.getDescription_ar());
        product.setCreated_at(productDto.getCreated_at());
        Product updatedProduct = productRepository.save(product);
        return mapToDTO(updatedProduct);
    }

    @Override
    public void deleteProduct( Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        productRepository.delete(product);
    }
    private ProductDto mapToDTO(Product product){
        ProductDto productDto = mapper.map(product, ProductDto.class);
//        PostDto postDto = new PostDto();
//        postDto.setId(post.getId());
//        postDto.setTitle(post.getTitle());
//        postDto.setDescription(post.getDescription());
//        postDto.setContent(post.getContent());
        return productDto;
    }
    private Product mapToEntity(ProductDto productDto){
        Product product = mapper.map(productDto, Product.class);
//        Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());
        return product;
    }
}
