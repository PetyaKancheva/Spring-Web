package bg.softuni.comments_project.service.impl;

import bg.softuni.comments_project.exception.CommentNotFoundException;
import bg.softuni.comments_project.model.CommentEntity;
import bg.softuni.comments_project.repo.CommentRepository;
import bg.softuni.comments_project.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private  final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<CommentEntity> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public CommentEntity getById(Long id) {

        return commentRepository.findById(id).orElseThrow(()-> new CommentNotFoundException("Comment with id:" +id +" not found!"));
    }


}
