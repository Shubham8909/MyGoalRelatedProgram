package net.one97.loadbalance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/status")
	public String getStatus() {
		
		String url="http://statusCheck/request/demo";
		
		return restTemplate.getForObject(url, String.class);
		
	}
	

}
