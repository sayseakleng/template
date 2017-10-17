package com.kdemo.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kdemo.mvc.service.TextService;

@Controller
public class SampleController {
	
	@Autowired
	private TextService textService;
	
	@GetMapping("/welcome")
	public String getWelcomePage() {
		
		textService.generate2("key");
		
		return "welcome";
	}
	
}
