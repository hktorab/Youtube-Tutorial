package com.sparentech.programming.Spring.Tutorial.Controller;

import com.sparentech.programming.Spring.Tutorial.Model.Myself;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/home", "/index"})
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.addObject("myself", new Myself());
        modelAndView.setViewName("index.html");

//        modelAndView.addObject("name2", "My name is Kabir");
        return modelAndView;
    }

    @RequestMapping(value = {"/form"},method = RequestMethod.POST)
    @ResponseBody
    public String form(@RequestParam("fname") String fname,@RequestParam("lname") String lname){
        return fname+" "+lname;
    }

    @RequestMapping(value = {"/formmodel"},method = RequestMethod.POST)
    @ResponseBody
    public String formModel(@ModelAttribute("myself") Myself myself){
        return "My name is "+ myself.getFname() +" "+myself.getLname()+" "+
                "I have studied in "+myself.getSchool() +" & "+ myself.getUniversity();

    }




}
