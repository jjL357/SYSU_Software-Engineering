package com.example.demo.dao;

import java.util.List;

public interface LikeDAO {

    void likePost(Long postId, Long userId);

    Long countLikes(Long postId);

    public List<Object[]> findTop10HotPosts();
}
