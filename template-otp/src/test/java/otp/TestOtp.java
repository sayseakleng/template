package otp;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorConfig;
import com.warrenstrange.googleauth.GoogleAuthenticatorConfig.GoogleAuthenticatorConfigBuilder;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import com.warrenstrange.googleauth.GoogleAuthenticatorQRGenerator;
import com.warrenstrange.googleauth.InMemoryCredentialRepository;

public class TestOtp {
	
	ObjectMapper oMapper = new ObjectMapper();

	@Test
	public void testByUser() throws JsonProcessingException {
		GoogleAuthenticatorConfig config = new GoogleAuthenticatorConfigBuilder()
				.setTimeStepSizeInMillis(TimeUnit.MINUTES.toMillis(2))
				.build();
		
		GoogleAuthenticator gAuth = new GoogleAuthenticator(config);
		gAuth.setCredentialRepository(new InMemoryCredentialRepository());
		GoogleAuthenticatorKey createCredentials = gAuth.createCredentials("user1");
		String writeValueAsString = oMapper.writeValueAsString(createCredentials);
		System.out.println(writeValueAsString);
		
		int totpPasswordOfUser = gAuth.getTotpPasswordOfUser("user1");
		System.out.printf("Code: %d%n", totpPasswordOfUser);
		
		boolean authorizeUser = gAuth.authorizeUser("user1", 
				totpPasswordOfUser);
		System.out.println(authorizeUser);
		
	}
	
	@Test
	public void testByRadom() throws JsonProcessingException {
		GoogleAuthenticatorConfig config = new GoogleAuthenticatorConfigBuilder()
				.setTimeStepSizeInMillis(TimeUnit.MINUTES.toMillis(2))
				.build();
		
		GoogleAuthenticator gAuth = new GoogleAuthenticator(config);
		GoogleAuthenticatorKey createCredentials = gAuth.createCredentials();
		String writeValueAsString = oMapper.writeValueAsString(createCredentials);
		System.out.println(writeValueAsString);
		
		int totpPassword = gAuth.getTotpPassword(createCredentials.getKey());
		System.out.printf("Code: %d%n", totpPassword);
		
		boolean authorizeUser = gAuth.authorize(createCredentials.getKey(),
				totpPassword);
		System.out.println(authorizeUser);
		
	}
	
	@Test
	public void testGetOtpAuthURL() throws JsonProcessingException, UnsupportedEncodingException {
		String accountName = "user";
		String issuer = "Company";
		
		GoogleAuthenticator gAuth = new GoogleAuthenticator();
		gAuth.setCredentialRepository(new InMemoryCredentialRepository());
		GoogleAuthenticatorKey credentials = gAuth.createCredentials(accountName);
		String writeValueAsString = oMapper.writeValueAsString(credentials);
		System.out.println(writeValueAsString);
		
		
		String otpAuthURL = GoogleAuthenticatorQRGenerator.getOtpAuthURL(
				StringUtils.replace(issuer, ":", "%3A"), 
				accountName,
				credentials);
		
		System.out.println(otpAuthURL);
		
		
		String otpAuthTotpURL = GoogleAuthenticatorQRGenerator.getOtpAuthTotpURL(
				StringUtils.replace(issuer, ":", "%3A"), 
				accountName,
				credentials);
		
		System.out.println(otpAuthTotpURL);
	}
}
