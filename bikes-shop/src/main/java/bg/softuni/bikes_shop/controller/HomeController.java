package bg.softuni.bikes_shop.controller;


import bg.softuni.bikes_shop.model.CustomUserDetails;
import bg.softuni.bikes_shop.service.ProductService;
import bg.softuni.bikes_shop.util.CurrentCurrency;

import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    @ModelAttribute("categories")
    public List<String>categoriesList(){
        return productService.getDistinctCategories();
    }
    @ModelAttribute("listCurrencies")
    public List<String> currencyList() {
        return CURRENCY_LIST;
    }

    @GetMapping("/")
    private String allProducts(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue ="3") Integer size,
                               Model model, @AuthenticationPrincipal CustomUserDetails currentUser) {
        // TODO implement dropdown for sorting

        model.addAttribute("products",  productService.getProductsPageable(PageRequest.of(page,size, Sort.by("name"))));
        if(currentUser!=null){
            model.addAttribute("currentUserName",currentUser.getFirstName());
        }

        //TODO get currency list from currency service
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
