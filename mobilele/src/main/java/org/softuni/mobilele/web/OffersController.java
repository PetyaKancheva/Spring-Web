package org.softuni.mobilele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OffersController {
    @GetMapping("/offers/all")
    private String allOffers(){

        return  "offers";
    }
}
