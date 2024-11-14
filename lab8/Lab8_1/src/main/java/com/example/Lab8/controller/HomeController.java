package com.example.Lab8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/contact", method = {RequestMethod.GET, RequestMethod.POST})
    public String contact(@RequestParam(required = false) String name,
                          @RequestParam(required = false) String email,
                          Model model) {
        if (name != null && email != null) {
            model.addAttribute("name", name);
            model.addAttribute("email", email);
            return "contact-result";
        }
        return "contact";
    }

    @GetMapping("/about")
    @ResponseBody
    public String about() {
        return "About this site";
    }

    @RequestMapping("*")
    @ResponseBody
    public String handleUnsupportedPaths() {
        return "Error: Unsupported request or path not found";
    }
}
