package bg.softuni.comments_project.service;

import bg.softuni.comments_project.model.CommentEntity;

import java.util.List;

public interface CommentService {

    List<CommentEntity> getAll();

    CommentEntity getById(Long i);


}
