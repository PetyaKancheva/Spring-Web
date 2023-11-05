package org.softuni.mobilele.web;

import jakarta.validation.Valid;
import org.softuni.mobilele.model.dto.BrandDTO;
import org.softuni.mobilele.model.dto.CreateOfferDTO;
import org.softuni.mobilele.model.dto.OfferDetailsDTO;
import org.softuni.mobilele.model.enums.EngineEnum;
import org.softuni.mobilele.model.enums.TransmissionEnum;
import org.softuni.mobilele.service.BrandService;
import org.softuni.mobilele.service.OfferService;
import org.softuni.mobilele.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.print.attribute.Attribute;
import javax.swing.*;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/offer")
public class OfferController {
    private final CurrentUser currentUser;
    private final OfferService offerService;
    private final BrandService brandService;

    public OfferController(CurrentUser currentUser, OfferService offerService, BrandService brandService) {
        this.currentUser = currentUser;
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
        return brandService.getAllBrands();
    }

    @GetMapping("/add")
    private String addOffer(Model model) {
        if (!model.containsAttribute("createOfferDTO")) {
            model.addAttribute("createOfferDTO", CreateOfferDTO.empty());
        }

        return "offer-add";
    }

    @PostMapping("/add")
    private ModelAndView addOffer(@Valid CreateOfferDTO createOfferDTO, BindingResult bindingResult, RedirectAttributes rAtts) {
        if (!currentUser.isLogged()) {
            return new ModelAndView("redirect:/users/login");
        }
        if (bindingResult.hasErrors()) {
            rAtts.addFlashAttribute("createOfferDTO", createOfferDTO);
            rAtts.addFlashAttribute("org.springframework.validation.BindingResult.createOfferDTO", bindingResult);

            return new ModelAndView("redirect:/offer/add");
        }

        UUID uuid = offerService.addOffer(createOfferDTO);
        boolean isAdded = uuid != null;
                String view = isAdded ? "redirect:/"+ uuid : "redirect:/offers/add";
        return new ModelAndView(view);
    }

    //GET DETAILS PAGE````
    @GetMapping("/{id}")
    public ModelAndView details(@PathVariable("uuid") UUID uuid) {

        if (!currentUser.isLogged()) {
            return new ModelAndView("redirect:/users/login");
        }
        //trow error
        //Find
        OfferDetailsDTO detailsDTO=offerService.getOffer(uuid);
        // model?


        return new ModelAndView(String "details", String "offer", Object detailsDTO);
    }


}
