package com.springapp.mvc.controller;

import com.springapp.mvc.domain.UserInfo;
import com.springapp.mvc.form.Login;
import com.springapp.mvc.form.SignUp;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Айрат on 19.04.2015.
 */

@Controller
@RequestMapping(value = "/signup")
public class SignUpController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String singUp(ModelMap model, Login login) {
//        if (request.getSession().getAttribute("userInfo") != null) {
//            return "redirect:/id/"+ ((UserInfo)request.getSession().getAttribute("userInfo")).getId();
//        }
        SignUp signUp = new SignUp();
        model.put("signUp", signUp);
//        System.out.println(SecurityContextHolder.getContext().getAuthentication().getDetails());
        return "signup";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSignUp(ModelMap model ,@Valid SignUp signUp, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("signUp" , signUp);
            return "signup";
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setName(signUp.getName());
        userInfo.setSurname(signUp.getSurname());
        userInfo.setEmail(signUp.getEmail());
        userInfo.setPassword(signUp.getPassword());
        userService.add(userInfo);
        return "signup-success";
    }
}
