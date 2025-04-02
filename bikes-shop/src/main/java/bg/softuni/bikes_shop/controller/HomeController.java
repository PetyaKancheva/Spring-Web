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

import java.util.List;

@Controller
public class HomeController {
    private final static String ERROR_KEYWORD_NOT_FOUND_MSG =
            "No results found for %s !";
    private final static String KEYWORD_FOUND_MSG ="Found %d results for %s !";
    private final static String ATTRIBUTE_MSG_NAME = "message";

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
    private String allProducts(@RequestParam(defaultValue = "0") Integer page,
                               @RequestParam(defaultValue ="3") Integer size,
                               @RequestParam (defaultValue ="name")String sort,
                               Model model) {
        // TODO implement dropdown for sorting

        model.addAttribute("products",  productService.getProductsPageable(PageRequest.of(page,size, Sort.by(sort))));

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
       private String search(Model model, String productToSearch, RedirectAttributes rAtt){
      Page<ProductDTO> resultList= productService.searchForProducts(productToSearch,Pageable.unpaged());

        if(resultList.isEmpty() ){
            rAtt.addFlashAttribute(ATTRIBUTE_MSG_NAME,String.format(ERROR_KEYWORD_NOT_FOUND_MSG,productToSearch));
            return "redirect:/";
        }else{
            //TODO check if it works
            rAtt.addFlashAttribute(ATTRIBUTE_MSG_NAME,String.format(KEYWORD_FOUND_MSG,resultList.getSize(),productToSearch));
            model.addAttribute("products",resultList );
            return "redirect:/";
        }

        }

//    private String post(CurrencyExchangeDTO ceDTO,RedirectAttributes rAtt){
//        rAtt.addFlashAttribute("currencyDTO",ceDTO);
//        // TODO fix currency being passing to model
//        return "redirect:/";
//    }
}
