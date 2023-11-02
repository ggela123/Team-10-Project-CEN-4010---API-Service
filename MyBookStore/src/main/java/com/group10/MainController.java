package com.group10;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/index")
    public String showHomePage() {
        return "index";
    }
}
