package com.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldFormController {
    
    // show initial form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // process the form
    @RequestMapping("/processForm")
    public String processForm(@RequestParam("userName") String theName, Model model) {

        String welcomeMessage = "Welcome, " + theName;
        model.addAttribute("welcomeMessage", welcomeMessage);

        return "greetings";
    }
    
}
