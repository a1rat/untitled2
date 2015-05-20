package com.springapp.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Gataullin Kamil
 *         12.10.2014 22:34
 */
@Controller
public class BaseController {

    @Autowired
    protected HttpServletRequest request;

//    @Autowired
//    protected HttpServletResponse response;

    public static String redirectToMain() {
        return "redirect:/";
    }
}
