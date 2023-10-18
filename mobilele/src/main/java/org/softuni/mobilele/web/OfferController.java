package org.softuni.mobilele.web;

import org.softuni.mobilele.model.dto.CreateOfferDTO;
import org.softuni.mobilele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offer")
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }


    @GetMapping("/add")
    private String addOffer(){
        return"offer-add";
    }

    @PostMapping("/add")
    private String addOffer(CreateOfferDTO createOfferDTO){
        offerService.addOffer(createOfferDTO);

        return"offer";
    }

    //GET DETAILS PAGE````

}
