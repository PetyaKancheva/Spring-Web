package org.softuni.mobilele.web;

import org.softuni.mobilele.service.OfferService;
import org.softuni.mobilele.util.CurrentUser;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;


@Controller
@RequestMapping("/offers")
public class OffersController {
    private final OfferService offerService;
    private final CurrentUser currentUser;

    public OffersController(OfferService offerService, CurrentUser currentUser) {
        this.offerService = offerService;
        this.currentUser = currentUser;
    }

    @GetMapping("/all")
    private ModelAndView allOffers(Model model, @PageableDefault(  sort = "uuid", size = 3) Pageable pageable){
        if (!currentUser.isLogged()) {
            return new ModelAndView("redirect:/users/login");
        }
       var allOffersPage = offerService.getAllOffers(pageable);
            return new ModelAndView("offers","offers",allOffersPage);
    }

}
