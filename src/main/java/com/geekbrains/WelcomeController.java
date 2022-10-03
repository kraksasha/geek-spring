package com.geekbrains;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WelcomeController {
    //    @RequestMapping(value = "/start", method = RequestMethod.GET)
    @GetMapping("/start")
    public String index(Model model) {
        model.addAttribute("message", "Hello World Man");
        return "index";
    }
}
