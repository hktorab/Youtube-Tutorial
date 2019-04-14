package com.sparentech.programming.Spring.Tutorial.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/home", "/index"})
    public ModelAndView index(ModelAndView modelAndView) {
//        modelMap.addAttribute("name","My name is Humayun");
//        modelMap.addAttribute("name2","My name is Kabir");
//        return "index.html";
        modelAndView.setViewName("index.html");
        modelAndView.addObject("name", "My name is Humayun");
        modelAndView.addObject("name2", "My name is Kabir");
        return modelAndView;
    }
}
