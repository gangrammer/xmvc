package com.neu.controller;

import com.neu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.neu.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户管理Controller
 *
 * @author Admin
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) {
        //代码编写处
        HttpSession session = request.getSession();
       String user = (String) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView();
        if (user == null) {
            modelAndView.setViewName("login");
        } else {
            List<User> users = userService.getUsers();
            modelAndView.addObject("userList", users);
            modelAndView.setViewName("users");
        }
        return modelAndView; //请修改代码
    }

    @RequestMapping("/save")
    public ModelAndView save(User user) {
        userService.insert(user);
        List<User> users = userService.getUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList", users);
        modelAndView.setViewName("users");
        return modelAndView;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(String id) {
        //代码编写处
        userService.delect(id);
        ModelAndView mv = new ModelAndView();
        List<User> users = userService.getUsers();
        mv.addObject("userList", users);
        mv.setViewName("users");
        return mv;
    }

    @RequestMapping("/update")
    public ModelAndView edit(User user) {
        //代码编写处
        userService.update(user);
        List<User> users = userService.getUsers();
        ModelAndView mv = new ModelAndView();
        mv.addObject("userList",users);
        mv.setViewName("users");
        return mv;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id) {
        //代码编写处
        User user = userService.findById(id);
        List<User> users = userService.getUsers();

        ModelAndView mv = new ModelAndView();
        mv.addObject("userList",users);
        mv.addObject("editUser", user);
        mv.setViewName("users");
        return mv;
    }

    @RequestMapping("/search")
    public ModelAndView select(String userName) {
        //代码编写处
        List<User> users = userService.select(userName);
        ModelAndView mv = new ModelAndView();
        mv.addObject("userList",users);
        mv.setViewName("users");
        return mv; //请修改代码
    }

}
