package com.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/form")
public class HelloWorldFormController {
    
    @Value("#{countryOptions}")
    private Map<String, String> countryOptions;

    @Value("#{languageOptions.languages}")
    private String[] languageOptions;
    
    // show initial form
    @RequestMapping("/showForm")
    public String showForm(Model theModel) {
        theModel.addAttribute("user", new User());
        theModel.addAttribute("theCountryOptions", countryOptions);
        theModel.addAttribute("theLanguageOptions", languageOptions);

        return "helloworld-form";
    }

    // process the form
    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("user") User user) {
        return "greetings";
    }
    
}
