package com.neu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neu.pojo.User;
import com.neu.service.UserService;

/**
 * 登录功能Controller
 * @author Admin
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public String  getIndex() {
		return "login";
	}
	
	/**
	 * 登录验证
	 * @param user 用户信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String getLogin(User user,HttpServletRequest request) {
		//代码编写处
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		user.setUserName(userName);
		user.setPassword(password);
		boolean login = userService.isLogin(user);
		if (login){
			HttpSession session = request.getSession();
			session.setAttribute("user",user.getUserName());
			return "redirect:/users/index";
		}else{
			return "redirect:/index";
		}

	}

}
