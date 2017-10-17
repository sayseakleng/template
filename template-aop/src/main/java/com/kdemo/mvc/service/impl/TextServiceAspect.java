package com.kdemo.mvc.service.impl;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TextServiceAspect {
	
	@Before("execution(* com.kdemo.mvc.service.impl.TextServiceImpl.generate(..)) && args(key)")
	public void generate(String key) {
		System.out.println(key);
	}
	
}
