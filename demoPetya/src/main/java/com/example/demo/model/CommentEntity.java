package com.example.demo.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Bean;

@Entity
@Table(name="comments")
public class CommentEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  private  int id;
   private String title;

    public int getId() {
        return id;
    }

    public CommentEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CommentEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public CommentEntity() {
    }
}
