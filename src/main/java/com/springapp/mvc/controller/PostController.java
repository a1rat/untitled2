package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Posts;
import com.springapp.mvc.domain.UserInfo;
import com.springapp.mvc.form.PostForm;
import com.springapp.mvc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Айрат on 13.04.2015.
 */
@Controller
@RequestMapping(value = "/post")
public class PostController extends BaseController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String sendMessage(@Valid PostForm postForm) {
        HttpSession session = request.getSession();
        Long to_user_id = (Long) session.getAttribute("to_user_id");
        System.out.println(to_user_id);
        Posts posts = new Posts();
        posts.setUser((UserInfo) session.getAttribute("userInfo"));
        posts.setText(postForm.getText());
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSSSS");
        String s = f.format(new Date());
        try {
            posts.setDate(f.parse(s));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        postService.add(posts);
        return "redirect:/";
    }
}
