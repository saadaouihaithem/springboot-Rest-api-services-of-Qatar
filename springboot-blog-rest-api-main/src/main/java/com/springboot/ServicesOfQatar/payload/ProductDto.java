package com.springboot.ServicesOfQatar.payload;

import com.springboot.ServicesOfQatar.entity.Promoted;
import com.springboot.ServicesOfQatar.entity.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;



@ApiModel(description = "Product model information")
@Data
public class ProductDto {
    @ApiModelProperty(value = "Product id")
    private Long id;
    @ApiModelProperty(value = "Product title")
    @NotEmpty
    @Size(min = 5, message = "Product title should have at least 5 characters")
    private String title;
    @ApiModelProperty(value = "Product title")
    @NotEmpty
    @Size(min = 5, message = "Product title  in arabic language should have at least 5 characters")
    private String title_ar;
    @ApiModelProperty(value = "Product details description")
    @NotEmpty
    @Size(min = 20, message = "Product details should have at least 20 characters")
    private String description;
    @ApiModelProperty(value = "Product details description in arabic ")
    @NotEmpty
    @Size(min = 20, message = "Product details  description should have at least 20 characters")
    private String description_ar;
    @ApiModelProperty(value = "Product Region_Id ")
    @NotEmpty
    @Size(min = 5, message = "Product details  Product Region_Id should have at least 5 characters")
    private String region_id;
    @ApiModelProperty(value = "Product PRICE")
    @NotEmpty
    @Size(min = 5, message = "Product details Price should have at least 5 characters")
    private int price;
    @ApiModelProperty(value = "Product Category_Id ")
    @NotEmpty
    @Size(min = 5, message = "Product Category_Id should have at least 5 characters")
    private Long category_id;
    @ApiModelProperty(value = " product user_id  ")
    @NotEmpty
    @Size(min = 5, message = "Product user_id should have at least 5 characters")
    private int user_id;
    @ApiModelProperty(value = "Product Details email user ")
    @NotEmpty
    @Size(min = 10, message = "Product Details email user should have at least 10 characters")
    private String email;
    @ApiModelProperty(value = "Product user phone number ")
    @NotEmpty
    @Size(min = 8, message = "Product Details phone number of the user should have at least 8 characters")
    private String phone;
    @ApiModelProperty(value = "Product Details promoted ")
    @NotEmpty
    @Size(min = 10, message = "Product Details promoted should have at least 10 characters")
    private Promoted promoted;
    @ApiModelProperty(value = "Product Details paid amount")
    @NotEmpty
    @Size(min = 5, message = "Product Details email user should have at least 5 characters")
    private int paid_amount;
    @ApiModelProperty(value = "Product Expiry_date ")
    @NotEmpty
    @Size(min = 12, message = "Product Details Expiry_date should have at least 12 characters")
    private Date expiry_date;
    @ApiModelProperty(value = "Product status ")
    @NotEmpty
    @Size(min = 8, message = "Product status should have at least 8characters")
    private Status status;
    @ApiModelProperty(value = "Product slug ")
    @NotEmpty
    @Size(min = 20, message = "Product slug should have at least 20 characters")
    private String slug;
    @ApiModelProperty(value = "Product Views")
    @NotEmpty
    @Size(min = 10, message = "Product Details views should have at least 10 characters")
    private int views;
    @ApiModelProperty(value = "Product user Address ")
    @NotEmpty
    @Size(min = 20, message = "Product user Details Address should have at least 20 characters")
    private String address;
    @ApiModelProperty(value = "Product latitude")
    @NotEmpty
    @Size(min = 12, message = "Product Details latitude should have at least 12 characters")
    private String lat;
    @ApiModelProperty(value = "Product lang ")
    @NotEmpty
    @Size(min = 12, message = "Product Details lang should have at least 12 characters")
    private String lng;
    @ApiModelProperty(value = "Product reference_id ")
    @NotEmpty
    @Size(min = 12, message = "Product Details reference_id should have at least 12 characters")
    private String reference_id;
    @ApiModelProperty(value = "Product details date of creation")
    @NotEmpty
    @Size(min = 12, message = "Product Details date of creation of the product should have at least 12 characters")
    private Timestamp created_at;
    @ApiModelProperty(value = "Product details of the latest update on the system  ")
    @NotEmpty
    @Size(min = 12, message = "Product Details of the latest update on the system should have at least 12 characters")
    private Timestamp updated_at;

}
