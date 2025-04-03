package bg.softuni.bikes_shop.controller;


import bg.softuni.bikes_shop.model.dto.ProductDTO;
import bg.softuni.bikes_shop.service.ProductService;
import bg.softuni.bikes_shop.util.CurrentCurrency;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    private final static String ERROR_KEYWORD_NOT_FOUND_MSG =
            "No results found for %s !";
    private final static String ATTRIBUTE_MSG_NAME = "message";

    private final ProductService productService;
    private final static List<String> CURRENCY_LIST = List.of("EUR", "BGN", "PLN", "USD");
    private final CurrentCurrency currentCurrency;

    public HomeController(ProductService productService, CurrentCurrency currentCurrency) {
        this.productService = productService;
        this.currentCurrency = currentCurrency;
    }

    @ModelAttribute("categories")
    public List<String> categoriesList() {
        return productService.getDistinctCategories();
    }

    @ModelAttribute("listCurrencies")
    public List<String> currencyList() {
        return CURRENCY_LIST;
    }

    @GetMapping("/")
    private String allProducts(@RequestParam(defaultValue = "3") Integer s,
                               @RequestParam(defaultValue = "0") Integer p,
                               @RequestParam(defaultValue = "name: asc") String o,
                               Model model) {


        model.addAttribute("products", productService.getProducts(s, p, o));

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


    @PostMapping("/search-result")
    private String search(Model model, String productToSearch, RedirectAttributes rAtt) {
        Page<ProductDTO> resultList = productService.searchForProducts(productToSearch);

        if (resultList.isEmpty()) {
            rAtt.addFlashAttribute(ATTRIBUTE_MSG_NAME, String.format(ERROR_KEYWORD_NOT_FOUND_MSG, productToSearch));
            return "redirect:/";
        }
        model.addAttribute("products", resultList);
        return "index";


    }

//    private String post(CurrencyExchangeDTO ceDTO,RedirectAttributes rAtt){
//        rAtt.addFlashAttribute("currencyDTO",ceDTO);
//        // TODO fix currency being passing to model
//        return "redirect:/";
//    }
}
