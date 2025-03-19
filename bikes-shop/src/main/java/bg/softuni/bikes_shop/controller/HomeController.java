package bg.softuni.bikes_shop.controller;


import bg.softuni.bikes_shop.service.ProductService;
import bg.softuni.bikes_shop.util.CurrentCurrency;

import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private final ProductService productService;
    private final static List<String> CURRENCY_LIST = List.of("EUR", "BGN", "PLN", "USD");
    private final CurrentCurrency currentCurrency;

    public HomeController(ProductService productService, CurrentCurrency currentCurrency) {
        this.productService = productService;

        this.currentCurrency = currentCurrency;
    }

    @GetMapping("/")
    private String allProducts(Model model, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue ="3") Integer size) {

        model.addAttribute("products",  productService.getProductsPageable(PageRequest.of(page,size, Sort.by("id"))));
        model.addAttribute("categories", productService.getDistinctCategories());
        model.addAttribute("listCurrencies", CURRENCY_LIST);

        return "index";
    }

    @GetMapping("/about")
    private String about() {
        return "/static/about";
    }

    @GetMapping("/services")
    private String services() {
        return "/static/services";
    }

    @GetMapping("/contacts")
    private String contacts() {
        return "/static/contacts";
    }


//    @PostMapping("/")
//    private String post(CurrencyExchangeDTO ceDTO,RedirectAttributes rAtt){
//        rAtt.addFlashAttribute("currencyDTO",ceDTO);
//        // TODO fix currency being passing to model
//        return "redirect:/";
//    }
}
