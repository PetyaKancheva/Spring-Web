package com.example.demo.util;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CLGreeter implements CommandLineRunner {


    public CLGreeter() {
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


