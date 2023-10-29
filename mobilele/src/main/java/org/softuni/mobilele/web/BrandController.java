package org.softuni.mobilele.web;

import org.softuni.mobilele.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/brands")
public class BrandController {
    private BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    private ModelAndView allBrands(Model model){
        model.addAttribute("brands", brandService.getAllBrands());


        return new ModelAndView("brands");
    }
}
