package com.example.Elastic.Beanstalk.controller;

import com.example.Elastic.Beanstalk.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }

    @PostMapping("/greet")
    public String greetUser(@RequestParam("userName") String userName, Model model) {
        model.addAttribute("userName", userName);
        return "greeting";
    }

    @GetMapping("/posts")
    public String getPosts(Model model) {
        // Create an in-memory list of posts
        List<Post> posts = Arrays.asList(
                new Post("First Elastic Beanstalk Deployment", "I successfully deployed my first Spring Boot application on AWS Elastic Beanstalk! This is a major milestone in my cloud journey."),
                new Post("Understanding 502 Bad Gateway", "I learned that the '502 Bad Gateway' error is often caused by a port mismatch between my Spring Boot app and the Elastic Beanstalk NGINX proxy. Setting the SERVER_PORT environment variable fixed the issue!"),
                new Post("CI/CD with GitHub Actions", "Setting up a CI/CD pipeline with GitHub Actions was challenging but rewarding. It automates the entire deployment process, saving me a ton of time.")
        );
        model.addAttribute("posts", posts);
        return "posts";
    }
}