package com.snapshare.snapshare_backend.controller;

import com.snapshare.snapshare_backend.model.Post;
import com.snapshare.snapshare_backend.model.User;
import com.snapshare.snapshare_backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/feed")
    public String showFeed(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("posts", postService.getPostsByUser(user));
        model.addAttribute("post", new Post());
        return "feed";
    }

    @PostMapping("/post")
    public String createPost(@ModelAttribute Post post, @AuthenticationPrincipal User user) {
        post.setUser(user);
        postService.createPost(post);
        return "redirect:/feed";
    }
}