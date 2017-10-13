package com.kdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
	
	@GetMapping("/welcome")
	public String getWelcomePage() {
		return "welcome";
	}
	
}
