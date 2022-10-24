package com.springboot.ServicesOfQatar.payload;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Api(value = "Category model information")
@Data
public class CategoryDto {

    @ApiModelProperty(value = "Comment id")
    private Long id;
    @ApiModelProperty(value = "Category name")
    @NotEmpty(message = "Name should not be null or empty")
    private String Name;
    @ApiModelProperty(value = "products list inside the category ")
    private Set<ProductDto> products;

}