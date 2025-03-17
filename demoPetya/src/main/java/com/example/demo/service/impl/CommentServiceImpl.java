package com.example.demo.service.impl;

import com.example.demo.config.CommentsConfig;

import com.example.demo.service.CommentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    
}
//    private static final Logger LOGGER= LoggerFactory.getLogger(CommentServiceImpl.class);
//
// private final RestTemplate restTemplate;
// private final CommentsConfig commentsConfig;
//
//    public CommentServiceImpl(RestTemplate restTemplate, CommentsConfig commentsConfig) {
//        this.restTemplate = restTemplate;
//        this.commentsConfig = commentsConfig;
//    }

//
//    @Override
//    public List<CommentDTO> getAll() {
//        String allCommentsURL = String.valueOf(new StringBuilder()
//                .append(commentsConfig.getSchema())
//                .append("://")
//                .append(commentsConfig.getHost())
//                .append(commentsConfig.getPath())
//                );
//        ResponseEntity<Object[]> rE= restTemplate.getForEntity(allCommentsURL, Object[].class);
//
//        Object[] objects = rE.getBody();
//        ObjectMapper mapper = new ObjectMapper();
//
//        return Arrays.stream(objects)
//                .map(object -> mapper.convertValue(object, CommentDTO.class))
//                .collect(Collectors.toList());
//
//    }
//
//
//    @Override
//    public void send(CommentDTO commentDTO) {
//
//        String postURL = String.valueOf(new StringBuilder()
//                .append(commentsConfig.getSchema())
//                .append("://")
//                .append(commentsConfig.getHost())
//                .append(commentsConfig.getPath())               );
//
//            restTemplate.postForObject(postURL,commentDTO,String.class);
//           LOGGER.info("****Sending POST request{}",commentDTO.getTitle());
//    }
//    @Override
//    public void delete(CommentDTO commentDTO) {
//
//        String postURL = String.valueOf(new StringBuilder()
//                .append(commentsConfig.getSchema())
//                .append("://")
//                .append(commentsConfig.getHost())
//                .append(commentsConfig.getPath())               );
//
//        restTemplate.postForObject(postURL,commentDTO,String.class);
//        LOGGER.info("****Deleting Comment{}",commentDTO.getTitle());
//    }
//
//}
