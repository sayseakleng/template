package com.warrenstrange.googleauth;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCredentialRepository implements ICredentialRepository {
	
	Map<String, String> map = new ConcurrentHashMap<>();

	@Override
	public String getSecretKey(String userName) {
		return map.get(userName);
	}

	@Override
	public void saveUserCredentials(String userName, String secretKey, int validationCode, List<Integer> scratchCodes) {
		map.put(userName, secretKey);
	}

}