package com.example.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ExternalApiController {

//	@RequestMapping("/weather")
//	public String getWeather(@RequestParam("city") String city) {
//		String url = "http://api.weatherstack.com/current?access_key=8c7e8ff7112ab72a5886d952e1be4f5a&query="+city;
//		RestTemplate restTemplate = new RestTemplate();
//		String weatherData = restTemplate.getForObject(url, String.class);
//		return weatherData;
//	}
	@PostMapping("/weather")
	public String getSample() {
		String u = "http://localhost:8080/quiz?username=ajith";
		RestTemplate restTemplate = new RestTemplate();
		String weatherData = restTemplate.getForObject(u, String.class);
		return weatherData;
	}
	
}