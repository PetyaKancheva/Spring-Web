package com.example.demo.service.impl;

import com.example.demo.config.CommentsConfig;
import com.example.demo.model.CommentDTO;
import com.example.demo.service.CommentService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
 private final RestTemplate restTemplate;
 private final CommentsConfig commentsConfig;

    public CommentServiceImpl(RestTemplate restTemplate, CommentsConfig commentsConfig) {
        this.restTemplate = restTemplate;
        this.commentsConfig = commentsConfig;
    }


    @Override
    public List<CommentDTO> getAll() {


      return null;


    }

    @Override
    public CommentDTO getComment(Long id) {

        String CommentsURL = String.valueOf(new StringBuilder()
                .append(commentsConfig.getSchema())
                .append("://")
                .append(commentsConfig.getHost())
                .append(commentsConfig.getPath())
                .append(id));

      CommentDTO oneComment= restTemplate.getForObject(CommentsURL, CommentDTO.class);

        return oneComment;
    }

}
