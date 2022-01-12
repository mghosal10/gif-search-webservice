package com.example.demo;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.sofi.demo.GifSearchWebserviceApplication;
import com.sofi.demo.model.GIFResponse;

@SpringBootTest(classes = GifSearchWebserviceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {
	
	@LocalServerPort
	private int port;

	@Autowired
	TestRestTemplate restTemplate;

	HttpHeaders headers = new HttpHeaders();
	
	private String getbaseURL() {
		return "http://localhost:" + port;
	}
	
	String searchTerm = "cheeseburgers";
	
	@Test
	public void getAllGifs() {

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<GIFResponse> response = restTemplate.exchange(getbaseURL() + "/search/" +searchTerm, HttpMethod.GET, entity, GIFResponse.class);  
		assertNotNull(response.getBody());
		System.out.println(getbaseURL() +response.getBody());

	}

}
