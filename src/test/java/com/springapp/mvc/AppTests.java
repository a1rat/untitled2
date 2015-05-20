package com.springapp.mvc;

import com.springapp.mvc.service.MessageService;
import com.springapp.mvc.service.PostService;
import com.springapp.mvc.service.UserService;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class AppTests {
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private SessionFactory sessionFactory;

//    @Before
//    public void setup() {
//        this.mockMvc = webAppContextSetup(this.wac).build();
//    }

//    @Test
//    public void simple() throws Exception {
//        mockMvc.perform(get("/id"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("user"));
//    }



    @Test
    public void s() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSSSS");
        System.out.println(f.format(new Date()));
//        System.out.println(messageService.getListDialog(6L));
//        System.out.println(messageService.getDialogById(6L, 7L));

//        System.out.println(userService.getById(1L).getName());
//        System.out.println(postService.getPost(1L));
//        System.out.println(sessionFactory.getCurrentSession().createCriteria(Contents.class)
//                .add(Restrictions.eq("id", 1L)));

    }
}
