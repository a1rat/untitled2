package com.springapp.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Айрат on 19.04.2015.
 */
@Controller
public class MainController extends BaseController {

    @RequestMapping(method = RequestMethod.GET)
	public String printWelcome() {
        request.setAttribute("message", "Hello world!");
		return "hello";
	}
}
