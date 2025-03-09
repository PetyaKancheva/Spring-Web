package com.example.demo.util;


import com.example.demo.config.CommentsConfig;
import com.example.demo.config.ExchangeRateConfig;

import com.example.demo.model.CommentDTO;

import com.example.demo.model.ListCommentsDTO;
import com.example.demo.service.CommentService;
import com.example.demo.service.CurrencyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Component
public class CLGreeter implements CommandLineRunner {

    private final RestTemplate restTemplate;
    private final ExchangeRateConfig exchangeRateConfig;
    private final CurrencyService currencyService;
    private final CommentsConfig commentsConfig;
    private final CommentService commentService;


    public CLGreeter(RestTemplate restTemplate, ExchangeRateConfig exchangeRateConfig, CurrencyService currencyService, CommentsConfig commentsConfig, CommentService commentService) {
        this.restTemplate = restTemplate;
        this.exchangeRateConfig = exchangeRateConfig;
        this.currencyService = currencyService;
        this.commentsConfig = commentsConfig;
        this.commentService = commentService;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("running");

//        String URLTemplate = String.valueOf(new StringBuilder()
//                .append(exchangeRateConfig.getSchema())
//                .append("://")
//                .append(exchangeRateConfig.getHost())
//                .append(exchangeRateConfig.getPath())
//                .append("?base=EUR&symbols=")
//                .append(String.join(",", exchangeRateConfig.getSymbols())));
//
//
//        ExchangeRatesDTO exchangeRatesDTO = restTemplate
//                .getForObject(URLTemplate, ExchangeRatesDTO.class);
//        System.out.println(exchangeRatesDTO);

//            String commentId="1";
////
//        String CommentsURL = String.valueOf(new StringBuilder()
//                .append(commentsConfig.getSchema())
//                .append("://")
//                .append(commentsConfig.getHost())
//                .append(commentsConfig.getPath())
//                .append(1));
//
//      CommentDTO oneComment= restTemplate.getForObject(CommentsURL, CommentDTO.class);
//
//        System.out.println(oneComment);

    }


}


