package bg.softuni.comments_project.service.impl;

import bg.softuni.comments_project.exception.CommentNotFoundException;
import bg.softuni.comments_project.model.CommentDTO;
import bg.softuni.comments_project.model.CommentEntity;
import bg.softuni.comments_project.model.NewCommentDTO;
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
    public List<CommentDTO> getAll() {
        return commentRepository.findAll().stream().map(CommentServiceImpl::mapToDTO).toList();
    }

    @Override
    public CommentDTO getById(String id) {
            Long idLong=Long.parseLong(id);
        return commentRepository.findById(idLong).map(CommentServiceImpl::mapToDTO)
                .orElseThrow(()-> new CommentNotFoundException("Comment with id:" +id +" not found!"));
    }

    @Override
    public NewCommentDTO addNewComment(NewCommentDTO newCommentDTO) {

        return null;
    }

    private static CommentDTO mapToDTO(CommentEntity c){
        return new CommentDTO(c.getId(),c.getUser().getName(),c.getTitle(),c.getBody());
    }
}
