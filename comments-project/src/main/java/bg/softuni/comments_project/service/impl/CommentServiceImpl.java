package bg.softuni.comments_project.service.impl;

import bg.softuni.comments_project.model.CommentDTO;
import bg.softuni.comments_project.model.CommentEntity;
import bg.softuni.comments_project.repo.CommentRepository;
import bg.softuni.comments_project.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private  final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<CommentDTO> getAll() {
        return commentRepository.findAll().stream().map(CommentServiceImpl::map).toList();
    }

    @Override
    public Optional<CommentEntity> findById(Long i) {
        return commentRepository.findById(i);
    }

    private static CommentDTO map(CommentEntity commentEntity){
        CommentDTO commentDTO= new CommentDTO();
        commentDTO.setBody(commentEntity.getBody());
        commentDTO.setId(commentEntity.getId());
        commentDTO.setTitle(commentEntity.getTitle());
        return commentDTO;
    }
}
