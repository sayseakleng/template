package com.kdemo.otp.controller;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import com.warrenstrange.googleauth.GoogleAuthenticatorQRGenerator;

@RestController
public class QrCodeRestController {
	
	@GetMapping("/api/qr")
	public ResponseEntity<byte[]> generateQrCode() throws Exception {
		
		GoogleAuthenticator gAuth = new GoogleAuthenticator();
		final GoogleAuthenticatorKey credentials = gAuth.createCredentials();
		
		
		String otpAuthTotpURL = GoogleAuthenticatorQRGenerator.getOtpAuthTotpURL("Company", 
				"seakleng", credentials);
		
		
		Map<EncodeHintType, Object> hints = new HashMap<>();
		hints.put(EncodeHintType.MARGIN, "1");
//		 ZXing uses error correction level L by default (the lowest, meaning the QR Code will still be readable even after a max of 7% damage)
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		BitMatrix matrix = new MultiFormatWriter().encode(otpAuthTotpURL, BarcodeFormat.QR_CODE, 200, 200, hints);
		MatrixToImageWriter.writeToStream(matrix, MediaType.IMAGE_PNG.getSubtype(), outputStream, getConfig());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		headers.setContentLength(outputStream.toByteArray().length);
		
		return new ResponseEntity<byte[]>(outputStream.toByteArray(), headers, HttpStatus.OK);
		
	}
	
	static int BLACK 		= 0xFF000000;
	static int WHITE 		= 0xFFFFFFFF;
	static int TRANSPARENT 	= 0X00FFFFFF;
	
	private MatrixToImageConfig getConfig() throws Exception {
	    return new MatrixToImageConfig(0X82AE5700, TRANSPARENT);
	}
}
