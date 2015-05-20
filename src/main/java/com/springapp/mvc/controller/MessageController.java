package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Message;
import com.springapp.mvc.domain.UserInfo;
import com.springapp.mvc.form.MessageForm;
import com.springapp.mvc.service.MessageService;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Айрат on 18.04.2015.
 */
@Controller
@RequestMapping(value = "/im")
public class MessageController extends BaseController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String message() {
        HttpSession session = request.getSession();
        if (session.getAttribute("userInfo") == null){
            return "redirect:/login";
        } else {
            UserInfo userId = ((UserInfo)session.getAttribute("userInfo"));
            request.setAttribute("message", messageService.getMessagesForMe(userId.getId()));
        }
        return "message";
    }

    @RequestMapping(value = "/pol", method = RequestMethod.GET)
    public String messageForMe() {
        HttpSession session = request.getSession();
        if (session.getAttribute("userInfo") == null){
            return "redirect:/login";
        } else {
            UserInfo userId = ((UserInfo)session.getAttribute("userInfo"));
            request.setAttribute("message", messageService.getMessagesForMe(userId.getId()));
        }
        return "message";
    }
    @RequestMapping(value = "/otp", method = RequestMethod.GET)
    public String messageFromMe() {
        HttpSession session = request.getSession();
        if (session.getAttribute("userInfo") == null){
            return "redirect:/login";
        } else {
            UserInfo userId = ((UserInfo)session.getAttribute("userInfo"));
            request.setAttribute("message", messageService.getMessagesFromMe(userId.getId()));
        }
        return "messageFor";
    }

    @RequestMapping(value = "/write{id}", method = RequestMethod.GET)
    public String Message(@PathVariable Long id, ModelMap model) {
        HttpSession session = request.getSession();
        session.setAttribute("to_user_id", id);
        MessageForm messageForm = new MessageForm();
        request.setAttribute("user", userService.getById(id));
        System.out.println(messageForm.getText());
        model.put("messageForm", messageForm);
        return  "form/write";
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String sendMessage(@Valid MessageForm messageForm) {
        HttpSession session = request.getSession();
        Long to_user_id = (Long) session.getAttribute("to_user_id");
        System.out.println(to_user_id);
        Message message = new Message();
//        message.setDate(new Date());
        message.setFrom_user_id((UserInfo)session.getAttribute("userInfo"));
        message.setTo_user_id(userService.getById(to_user_id));
        message.setText(messageForm.getText());
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSSSS");
        String s = f.format(new Date());
        try {
            message.setDate(f.parse(s));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        messageService.add(message);
        System.out.println("text "+messageForm.getText());
        return "redirect:/im";
    }
}
