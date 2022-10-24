package com.springboot.ServicesOfQatar.repository;

import com.springboot.ServicesOfQatar.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(long postId);
}
