package com.springapp.mvc.controller;

import com.springapp.mvc.domain.UserInfo;
import com.springapp.mvc.service.PostService;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/")
public class HelloController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public String ge() {
        HttpSession session = request.getSession();
        if (session.getAttribute("userInfo") == null) {
            return "redirect:/login";
        }
        return "redirect:/id/"+((UserInfo) session.getAttribute("userInfo")).getId();
    }

//    @RequestMapping(value = "/id", method = RequestMethod.GET)
//    public String g() {
////        HttpSession session = request.getSession();
////        if (session.getAttribute("userInfo") == null) {
////            return "redirect:/login";
////        }
//        return "redirect:/id/"+((UserInfo) session.getAttribute("userInfo")).getId();
//    }

    @RequestMapping(value = "id/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable Long id) {
        HttpSession session = request.getSession();
        if (session.getAttribute("userInfo") == null){
            return "redirect:/login";
        }
// request.setAttribute("userMe", (session.getAttribute("userInfo")));
        request.setAttribute("user", userService.getById(id));
        request.setAttribute("post", postService.getPost(id));
        Long u1 = ((UserInfo)session.getAttribute("userInfo")).getId();
        if (u1 != id) {
            return "user1";
        }
        else {
            return "user";
        }
    }
}