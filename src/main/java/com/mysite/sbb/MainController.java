package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/sbb")
    @ResponseBody
    public String index() {
        return "스프링존나 빡세네 봄주제에";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }
}
