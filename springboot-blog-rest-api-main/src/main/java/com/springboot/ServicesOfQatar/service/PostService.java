package com.springboot.ServicesOfQatar.service;

import com.springboot.ServicesOfQatar.payload.PostDto;
import com.springboot.ServicesOfQatar.payload.PostResponse;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
}
