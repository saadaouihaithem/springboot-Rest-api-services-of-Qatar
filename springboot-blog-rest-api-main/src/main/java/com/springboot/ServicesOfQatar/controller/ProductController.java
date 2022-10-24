package com.springboot.ServicesOfQatar.controller;


import com.springboot.ServicesOfQatar.payload.ProductDto;
import com.springboot.ServicesOfQatar.payload.ProductResponse;

import com.springboot.ServicesOfQatar.service.ProductService;
import com.springboot.ServicesOfQatar.utils.AppConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Api(value = "CRUD Rest APIs for services Qatar resources")
@RestController
@RequestMapping()
public class ProductController {

        private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation(value = "Create Product REST API")
        @PreAuthorize("hasRole('ADMIN')")
        // create new product rest api
        @PostMapping("/api/v1/product")
        public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto){
            return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
        }




        @ApiOperation(value = "Get All Products REST API")
        // get all products rest api
        @GetMapping("/api/v1/product")
        public ProductResponse getAllProducts(
                @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
                @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
                @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir

        ){
            return productService.getAllProducts(pageNo, pageSize, sortBy, sortDir);
        }






        @ApiOperation(value = "Get Product By Id REST API")
        // get product by id
        @GetMapping(value = "/api/v1/product/{id}")
        public ResponseEntity<ProductDto> getProductByIdV1(@PathVariable(name = "id") long id){
            return ResponseEntity.ok(productService.getProductById(id));
        }


        @ApiOperation(value = "Update Product By Id REST API")
        @PreAuthorize("hasRole('ADMIN')")
        // update product by id rest api
        @PutMapping("/api/v1/product/{id}")
        public ResponseEntity<ProductDto> updateProduct(@Valid @RequestBody ProductDto productDto, @PathVariable(name = "id") long id){

            ProductDto productResponse = productService.updateProduct(productDto, id);

            return new ResponseEntity<>(productResponse, HttpStatus.OK);
        }


        @ApiOperation(value = "Delete Product By Id REST API")
        @PreAuthorize("hasRole('ADMIN')")
        // delete product rest api
        @DeleteMapping("/api/v1/product/{id}")
        public ResponseEntity<String> deleteProduct(@PathVariable(name = "id") long id){

            productService.deleteProduct(id);

            return new ResponseEntity<>("Post entity deleted successfully.", HttpStatus.OK);
        }
}
