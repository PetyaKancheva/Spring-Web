package bg.softuni.comments_project.service;

import bg.softuni.comments_project.model.CommentDTO;
import bg.softuni.comments_project.model.CommentEntity;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    List<CommentDTO> getAll();

    Optional<CommentEntity> findById(Long i);
}
