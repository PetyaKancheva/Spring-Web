package bg.softuni.bikes_shop.controller;

import bg.softuni.bikes_shop.service.ProductService;
import bg.softuni.bikes_shop.util.CurrentCurrency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
    private String allProducts(Model model,   @PageableDefault(size = 3, sort = "id") Pageable pageable) {
//        if(!model.containsAttribute("currencyDTO")){
//            CurrencyExchangeDTO eurCEDTO= new CurrencyExchangeDTO();
//            eurCEDTO.setRate(1.0);
//            eurCEDTO.setCurrency("EUR");
//            model.addAttribute("currencyDTO",eurCEDTO);

//        }

//        @PageableDefault(size = 3, sort = "id")

//        public Page<User> findAllUsers() {
//            Pageable pageable = PageRequest.of(0, 5);
//            return userRepository.findAll(pageable);
//        }
//        @RequestParam("page") int page,
//        @RequestParam("size") int size, Pageable pageable
//        @RequestParam("sort") String sort

        model.addAttribute("products", productService.getProductsPageable(pageable));
        model.addAttribute("categories", productService.getDistinctCategories());
        model.addAttribute("listCurrencies", CURRENCY_LIST);
        model.addAttribute("size", 3);
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
