package com.naresh.bankingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/next.do")
	public String next() {
		System.out.println("HomeController->next");
		return "next.html";
	}
	
	@GetMapping("/home.do")
	public String home() {
		System.out.println("HomeController->home");
		return "home.html";
	}
}
