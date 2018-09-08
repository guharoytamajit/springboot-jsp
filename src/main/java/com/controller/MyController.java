package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyController {
	
	@GetMapping("/")
	public String string(){
		return "index";
	}
	@GetMapping("/error")
	public String error(){
		return "errorPages";
	}
}
