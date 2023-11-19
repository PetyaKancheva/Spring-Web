package bg.softuni.bikeshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

    @GetMapping("/")
    public ModelAndView demo(    ){
        return new ModelAndView("demo");
    }
}
