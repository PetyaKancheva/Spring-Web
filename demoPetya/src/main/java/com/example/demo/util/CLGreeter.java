package com.example.demo.util;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;


@Component
public class CLGreeter implements CommandLineRunner {


    public CLGreeter() {
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("running");

        String activationCode="hidddencode";

     String uri = UriComponentsBuilder.newInstance()
             .scheme("http").host("localhost").port(8080).path("/user/") .queryParam("activate",activationCode)

           .toUriString();

        System.out.println(uri);


//        queryParam("activate",activationCode)
//        http://localhost:8080/user/?activate=hidddencode
//  .query("activate(activation_code={activationCode})").buildAndExpand(activationCode)
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


