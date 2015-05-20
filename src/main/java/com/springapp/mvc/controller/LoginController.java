package com.springapp.mvc.controller;

import com.springapp.mvc.domain.UserInfo;
import com.springapp.mvc.form.Login;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by Айрат on 22.04.2015.
 */
@Controller

public class LoginController extends BaseController{

    @Autowired

    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
//        System.out.println(!model.isEmpty());
//        if (!(model.isEmpty())) {
//            System.out.println(login.getEmail());
//            UserInfo id = userService.getIdByEmail(login.getEmail());
////            return "redirect:id/"+id.getId();
//        }
        if (request.getSession().getAttribute("userInfo") != null) {
            return "redirect:/id/"+ ((UserInfo)request.getSession().getAttribute("userInfo")).getId();
        }
        Login login = new Login();
        model.put("login", login);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String l(ModelMap model,@Valid Login login) {
//        System.out.println(login.getEmail().equals(""));
        if ( login.getEmail().isEmpty() || login.getPassword().isEmpty()
//                ||(userService.login(login.getEmail(), login.getPassword()).equals(null))
                ){
            request.setAttribute("message", "Login failed");
            return "login";
        }
        UserInfo userInfo = userService.getIdByEmail(login.getEmail());
        HttpSession session = request.getSession();
        session.setAttribute("userInfo", userInfo);
        model.addAttribute("login", login);
        return "redirect:id/"+userInfo.getId();
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        HttpSession session = request.getSession();
        if (session.getAttribute("userInfo") == null){
            return "redirect:/login";
        }
        session.removeAttribute("userInfo");
        return "redirect:/login";
    }
}