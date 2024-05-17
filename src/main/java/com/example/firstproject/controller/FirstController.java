package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
@Controller
public class FirstController {
    @GetMapping("/hi")
    public String niceTommetyou(Model model){
        model.addAttribute("username","시아");
        return "greetings";
    }

    @GetMapping("/bye")
    public String seeyounext(Model model){
        model.addAttribute("nickname","시아");
        return "goodbye";
    }
}
