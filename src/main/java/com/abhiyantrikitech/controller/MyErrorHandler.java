package com.abhiyantrikitech.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorHandler implements ErrorController  {
 
    @RequestMapping("/error")
    public String handleError(ModelMap model) {
        //do something like logging
    	System.out.println("error.....<<>>>>");
    	model.put("errorMessage", "Either Page Not Found or Session is expired,Please login again");
        return "invalid-session";
    }
 
    @Override
    public String getErrorPath() {
        return "/error";
    }
}
