package com.snapshare.snapshare_backend.repository;

import com.snapshare.snapshare_backend.model.Post;
import com.snapshare.snapshare_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserOrderByCreatedAtDesc(User user);
}