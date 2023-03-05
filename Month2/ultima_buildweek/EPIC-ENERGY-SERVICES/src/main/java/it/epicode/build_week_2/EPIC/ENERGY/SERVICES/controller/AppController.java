package it.epicode.build_week_2.EPIC.ENERGY.SERVICES.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {
	
	@GetMapping("")
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	@GetMapping("/chisiamo")
	private String chisiamo() {
		return "chisiamo";
	}
	
	@GetMapping("/fatture")
	public String fatture() {
		return "fatture";
	}
}
