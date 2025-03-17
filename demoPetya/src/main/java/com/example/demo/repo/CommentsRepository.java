package com.example.demo.repo;


import com.example.demo.model.CommentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<CommentEntity, Integer> {

    Page<CommentEntity> findAll(Pageable pageable);
}
