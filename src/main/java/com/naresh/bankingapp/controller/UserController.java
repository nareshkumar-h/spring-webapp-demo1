package com.naresh.bankingapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.naresh.bankingapp.model.User;
import com.naresh.bankingapp.service.UserService2;

@Controller
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService2 userService;// = new UserService();

	@GetMapping("/register.do")
	public String register(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("password") String password) {
		System.out.println("UserController->register");
		// String name = request.getParameter("name");
		// String email = request.getParameter("email");
		// String password = request.getParameter("password");
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		System.out.println("UserController->Save =>" + user);
		userService.save(user);
		return "redirect:../index.html";
	}

	@GetMapping("/login.do")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {
		System.out.println("UserController->login");
		User user = new User(); // userDAO.login(email,password);
		user.setId(1);
		user.setName("Naresh");
		user.setEmail("nareshkumarh@live.com");
		System.out.println("Login =>" + user);
		return "redirect:../home.html";

	}

	@GetMapping("/list.do")
	public @ResponseBody List<User> list() {
		System.out.println("UserController->list");
		User user = new User();
		user.setId(1);
		user.setName("Naresh");
		user.setEmail("nareshkumarh@live.com");

		List<User> userList = userService.list();
		userList.add(user);

		return userList;

	}

}
