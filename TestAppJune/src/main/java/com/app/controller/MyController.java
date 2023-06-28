package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	@GetMapping("/getNews")
	private ResponseEntity<Object> getNewsApiHandler(){
		
		String url = "https://newsapi.org/v2/top-headlines?country=in&apiKey=bcf0e8e59ceb4b92b1b40675b7463933";
		ResponseEntity<Object> re = restTemplate.getForEntity(url, Object.class);
		return re;
	}
	
	@GetMapping("/getCryptos")
	private ResponseEntity<Crypto> getCryptoHandlertest(){
		
		String url = "http://localhost:8088/getCrypto";
		ResponseEntity<Crypto> re = restTemplate.getForEntity(url, Crypto.class);
		return re;
	}
	
}
