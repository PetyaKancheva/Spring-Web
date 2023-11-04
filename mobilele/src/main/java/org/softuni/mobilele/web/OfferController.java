package org.softuni.mobilele.web;

import org.softuni.mobilele.model.dto.BrandDTO;
import org.softuni.mobilele.model.dto.CreateOfferDTO;
import org.softuni.mobilele.model.enums.EngineEnum;
import org.softuni.mobilele.model.enums.TransmissionEnum;
import org.softuni.mobilele.service.BrandService;
import org.softuni.mobilele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/offer")
public class OfferController {
    private final OfferService offerService;
    private final BrandService brandService;

    public OfferController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @ModelAttribute("engines")
    public EngineEnum[] engines() {
        return EngineEnum.values();
    }

    // model dropdown will come from Brands!
    @ModelAttribute("transmissions")
    public TransmissionEnum[] transmissions() {
        return TransmissionEnum.values();
    }
    @ModelAttribute("brands")
    public List<BrandDTO> allBrands() {
        return  brandService.getAllBrands();
    }
    @GetMapping("/add")
    private String addOffer(Model model) {
        if(!model.containsAttribute("createOfferDTO")){
            model.addAttribute("createOfferDTO", CreateOfferDTO.empty());
        }

        return "offer-add";
    }

    @PostMapping("/add")
    private String addOffer(CreateOfferDTO createOfferDTO) {


        offerService.addOffer(createOfferDTO);

        return "redirect:offers/all";
    }

    //GET DETAILS PAGE````

}
