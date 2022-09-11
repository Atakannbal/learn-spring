package com.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/form")
public class HelloWorldFormController {
    
    // show initial form
    @RequestMapping("/showForm")
    public String showForm(Model theModel) {
        theModel.addAttribute("user", new User());
        return "helloworld-form";
    }

    // process the form
    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("user") User user) {
        return "greetings";
    }
    
}
