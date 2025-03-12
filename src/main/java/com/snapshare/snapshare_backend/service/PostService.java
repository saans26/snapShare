package com.snapshare.snapshare_backend.service;


import com.snapshare.snapshare_backend.model.Post;
import com.snapshare.snapshare_backend.model.User;
import com.snapshare.snapshare_backend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post) {
//        post.setUser(user);
        return postRepository.save(post);
    }

    public List<Post> getPostsByUser(User user) {
        return postRepository.findByUserOrderByCreatedAtDesc(user);
    }
}