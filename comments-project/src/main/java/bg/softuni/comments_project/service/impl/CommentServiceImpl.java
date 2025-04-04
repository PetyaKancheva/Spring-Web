package bg.softuni.comments_project.service.impl;

import bg.softuni.comments_project.exception.CommentNotFoundException;
import bg.softuni.comments_project.model.CommentDTO;
import bg.softuni.comments_project.model.CommentEntity;
import bg.softuni.comments_project.model.NewCommentDTO;
import bg.softuni.comments_project.model.UserEntity;
import bg.softuni.comments_project.repo.CommentRepository;
import bg.softuni.comments_project.service.CommentService;
import bg.softuni.comments_project.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private  final CommentRepository commentRepository;
    private final UserService userService;

    public CommentServiceImpl(CommentRepository commentRepository, UserService userService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
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
    public CommentDTO addNewComment(NewCommentDTO newCommentDTO) {

        UserEntity user= userService.findByName(newCommentDTO.user_name());
       CommentEntity comment= commentRepository.save( mapToEntity(newCommentDTO,user));

        return mapToDTO(comment);
    }

    @Override
    @Transactional
    public void deleteComment(String id) {
        Long idLong=Long.parseLong(id);
        
        if(commentRepository.findById(idLong).isPresent()){
            commentRepository.delete(commentRepository.findById(idLong).get());
        }
    }

    private   CommentEntity mapToEntity(NewCommentDTO newCommentDTO, UserEntity user) {
          return new CommentEntity().setBody(newCommentDTO.body())
                  .setTitle(newCommentDTO.title()).setUser(user);
    }

    private static CommentDTO mapToDTO(CommentEntity c){
        return new CommentDTO(c.getId(),c.getUser().getName(),c.getTitle(),c.getBody());
    }
}
