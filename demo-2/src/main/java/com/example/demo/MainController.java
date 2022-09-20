package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/user/user")
	public String user() {
		return "/user/user";
	}
	
	@GetMapping("/admin/admin")
	public void admin() {}
	
	@GetMapping("/login")
	public void login() {}
	
	@GetMapping("/top")
	public void top() {}
	
	@GetMapping("/error403")
	public String error403() {
		return "403";
	}
}
