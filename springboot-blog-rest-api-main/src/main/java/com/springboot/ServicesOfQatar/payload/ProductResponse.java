package com.springboot.ServicesOfQatar.payload;

import com.springboot.ServicesOfQatar.entity.Promoted;
import com.springboot.ServicesOfQatar.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductResponse {

        private List<ProductDto> content;
        private int pageNo;
        private int pageSize;
        private long totalElements;
        private int totalPages;
        private boolean last;
        private String title;

        private String title_ar;

        private String description;

        private String description_ar;

        private String region_id;

        private int price;

        private Long category_id;

        private int user_id;

        private String email;

        private String phone;

        private Promoted promoted;

        private int paid_amount;

        private Date expiry_date;

        private Status status;

        private String slug;

        private int views;

        private String address;

        private String lat;

        private String lng;

        private String reference_id;

        private Timestamp created_at;

        private Timestamp updated_at;
    }


