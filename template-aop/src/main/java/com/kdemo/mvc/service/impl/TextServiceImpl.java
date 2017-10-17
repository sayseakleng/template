package com.kdemo.mvc.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kdemo.mvc.service.TextService;

@Service
@Transactional(rollbackFor = Exception.class)
public class TextServiceImpl implements TextService {

	@Override
	public String generate(String key) {
		return UUID.randomUUID().toString();
	}

	@Override
	public String generate2(String key) {
		
		String generate = generate(key);
		
		System.out.printf("**** Result = %s %n", generate);
		
		return generate;
	}

}
