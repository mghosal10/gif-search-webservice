package com.sofi.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import com.sofi.demo.utils.Constants;

@Configuration
public class WebClientConfig {
	
	@Bean
	WebClient webClient() {
		return WebClient.builder()
					    .defaultHeaders(header -> {
					    	header.add("Content-Type", "application/json");
					    })
					    .build();
	}

}
