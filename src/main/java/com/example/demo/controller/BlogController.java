package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
  public class BlogController {
    @Autowired
    private BlogRepository blogRepository;
    @GetMapping("/blog")
    public List<Blog> index() {
        return blogRepository.findAll();
    }
    @GetMapping("/blog/{id}")
    public Blog show(@PathVariable Long id) {
        return blogRepository.findById(id).orElse(new Blog());
    }
    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");
        return blogRepository.findByTitleContainingOrContentContaining(searchTerm,searchTerm);
    }
    @PostMapping("/blog")
    public Blog create(@RequestBody Map<String, String> body) {
        String title = body.get("title");
        String content = body.get("content");
        return blogRepository.save(new Blog(title,content));
    }
    @PutMapping("/blog/{id}")
    public Blog update(@PathVariable Long id,@RequestBody Map<String, String> body ) {
        Blog blog =  blogRepository.findById(id).orElse(new Blog());
        blog.setTitle(body.get("title"));
        blog.setContent(body.get("content"));
        return blogRepository.save(blog);
    }
    @DeleteMapping("/blog/{id}")
    public boolean delete(@PathVariable Long id) {
        blogRepository.deleteById(id);
        return true;
    }

}