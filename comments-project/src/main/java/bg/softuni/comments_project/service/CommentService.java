package bg.softuni.comments_project.service;

import bg.softuni.comments_project.model.CommentDTO;
import bg.softuni.comments_project.model.CommentEntity;
import bg.softuni.comments_project.model.NewCommentDTO;

import java.util.List;

public interface CommentService {

    List<CommentDTO> getAll();

    CommentDTO getById(String id);


    CommentEntity addNewComment(NewCommentDTO newCommentDTO);

    void deleteComment(String id);
}
