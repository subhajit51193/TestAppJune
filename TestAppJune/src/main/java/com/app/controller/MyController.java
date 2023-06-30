package com.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.dto.Crypto;
import com.app.dto.USD;

@RestController
public class MyController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getCrypto")
//	@RequestMapping(value = "/getCrypto", method = RequestMethod.GET,consumes = MediaType.ALL_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	private String getCryptoHandler(){
		
		String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
		String re = restTemplate.getForObject(url, String.class);
		return re;
	}
	
	
	
	@GetMapping("/getCryptos")
	private String getCryptoHandlertest(){
		
		String url = "http://localhost:8088/getCrypto";
		ResponseEntity<Crypto> re = restTemplate.getForEntity(url, Crypto.class);
		System.out.println(re.getBody().getBpi().getEUR().getRate_float());
		Crypto obj = re.getBody();
		Float res = re.getBody().getBpi().getEUR().getRate_float();
		int b = (int)(float)res;
		String str = numberToWords(b);
		return str;
	}
	
	
//	--------------------------------------------------------
	
	
	
//	converting method
	
	
	public static String numberToWords(int number) {
		
//		variables
		String words = "";
		String[] singles = {	"zero","one","two","three","four","five","six", 
                				"seven","eight","nine","ten","eleven","twelve",
                				"thirteen","fourteen","fifteen","sixteen","seventeen", 
                				"eighteen","nineteen" };
		String[] doubles = {	"zero","ten","twenty","thirty","forty","fifty",
                				"sixty","seventy","eighty","ninety" };
		
		if (number == 0) {
			return "zero";
		}
		if ((number / 10000000) > 0) {
		    words += numberToWords(number / 10000000) + " crore ";
		    number %= 10000000;
		}
	    if ((number / 100000) > 0) {
		    words += numberToWords(number / 100000) + " lakh ";
		    number %= 100000;
		}
		if ((number / 1000) > 0) {
		    words += numberToWords(number / 1000) + " thousand ";
		    number %= 1000;
		}
		if ((number / 100) > 0) {
		     words += numberToWords(number / 100) + " hundred ";
		     number %= 100;
		}
		if (number > 0) {
			if (number < 20) {
				words += singles[number];
			}
			else {
				 words += doubles[number / 10];
				 if ((number % 10) > 0) {
	            	 words += "-" + singles[number % 10];
	             } 
			}
		}
		return words;
	}
	
}
