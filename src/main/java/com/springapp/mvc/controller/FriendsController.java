package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Friends;
import com.springapp.mvc.domain.UserInfo;
import com.springapp.mvc.service.FriendsService;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Айрат on 12.05.2015.
 */
@Controller
@RequestMapping(value = "/friends")
public class FriendsController extends BaseController{

    @Autowired
    private FriendsService friendsService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getFriends() {
        HttpSession session = request.getSession();
        request.setAttribute("friends", friendsService.getAllFriends(
                ((UserInfo)session.getAttribute("userInfo")).getId()
        ));
        return "friends";
    }

    @RequestMapping(value = "/req", method = RequestMethod.GET)
    public String getReq() {
        HttpSession session = request.getSession();
        request.setAttribute("friends", friendsService.getRequests(
                ((UserInfo) session.getAttribute("userInfo")).getId()
        ));
        return "friendsReq";
    }

    @RequestMapping(value = "/add{id}")
    public String add(@PathVariable Long id) {
        HttpSession session = request.getSession();
        Friends friends = new Friends();
        friends.setFriend_from_user_id(((UserInfo) session.getAttribute("userInfo")));
        friends.setFriend_for_user_id(userService.getById(id));
        friends.setViewed(true);
        friendsService.add(friends);
        return "redirect:/";
    }

    @RequestMapping(value = "/add2{id}")
    public String add2(@PathVariable Long id) {
        HttpSession session = request.getSession();
        Friends friends = new Friends();
        friends.setFriend_from_user_id(((UserInfo) session.getAttribute("userInfo")));
        friends.setFriend_for_user_id(userService.getById(id));
        friends.setViewed(false);
        friendsService.add(friends);
        return "redirect:/";
    }
}
