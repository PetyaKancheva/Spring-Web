package com.example.demo.model;

import org.springframework.context.annotation.Bean;


public class CommentDTO {
    Long userId;
    Long id;
    String title;
    String body;

    public CommentDTO() {
    }

    public Long getUserId() {
        return userId;
    }

    public CommentDTO setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getId() {
        return id;
    }

    public CommentDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CommentDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getBody() {
        return body;
    }

    public CommentDTO setBody(String body) {
        this.body = body;
        return this;
    }
}
