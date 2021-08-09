package com.hasindu.userdetailsmanagamentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home Controller
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String showIndexPage() {
        return "home";
    }


}
