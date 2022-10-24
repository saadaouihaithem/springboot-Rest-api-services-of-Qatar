package com.springboot.ServicesOfQatar.repository;

import com.springboot.ServicesOfQatar.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
