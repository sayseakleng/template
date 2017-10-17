package com.kdemo.mvc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:testcontext-root.xml")
public class TestTextService {

	@Autowired
	private TextService textService;
	
	@Test
	public void test() {
		textService.generate2("Hello");
	}

}
