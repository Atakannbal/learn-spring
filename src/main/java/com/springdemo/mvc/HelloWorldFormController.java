package com.springdemo.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

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
    public String processForm(@Valid @ModelAttribute("user") User user, BindingResult theBindingResult, Model theModel) {
       
        if(theBindingResult.hasErrors()) {
            theModel.addAttribute("theCountryOptions", countryOptions);
            theModel.addAttribute("theLanguageOptions", languageOptions);
            return "helloworld-form";
        }

        return "greetings";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
