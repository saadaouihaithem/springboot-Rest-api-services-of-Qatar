package com.springboot.ServicesOfQatar.repository;


import com.springboot.ServicesOfQatar.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value="select * from  product",nativeQuery = true)



    List<Product> findAll(long id );
}
