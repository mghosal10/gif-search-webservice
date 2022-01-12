package com.example.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import com.sofi.demo.model.GIFResponse;
import com.sofi.demo.model.GIFResponseClient;
import com.sofi.demo.model.GIFResponseClient.GIFClient;
import com.sofi.demo.model.GIFResponseClient.Pagination;
import com.sofi.demo.service.GifService;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class) 
public class GifServiceUnitTests {
	
	@Mock
	WebClient webclient;
	
	@Mock
	RequestHeadersUriSpec requestHeadersSpec;
	
	@Mock
	RequestBodySpec mockRequestBodySpec;
	
	@Mock
	ResponseSpec mockResponseSpec;
	
	@Mock
	Mono<ResponseEntity<GIFResponseClient>> mockResponse;
	
	@InjectMocks
	GifService gifService;
	
//	@Test
//	public void getGiphy() {
//		ReflectionTestUtils.setField(gifService, "apiKey", "apiKey");
//		ReflectionTestUtils.setField(gifService, "requiredCount", 5);
//		when(webclient.get()).thenReturn(requestHeadersSpec);
//		when(requestHeadersSpec.uri(anyString(), anyString(), anyString())).thenReturn(mockRequestBodySpec);
//		when(mockRequestBodySpec.retrieve()).thenReturn(mockResponseSpec);
//		when(mockResponseSpec.toEntity(GIFResponseClient.class)).thenReturn(mockResponse);
//		when(mockResponse.block()).thenReturn(ResponseEntity.ok(getGIFResponseClient()));
//		
//		GIFResponse response = gifService.callGiphyApi("cheeseburger");
//		assertNotNull(response);
//		assertTrue(!response.getGifs().isEmpty());
//	}
//
//	private GIFResponseClient getGIFResponseClient() {
//		List<GIFClient> gifs = new ArrayList<>();
//		gifs.add(GIFClient.builder().id("id1").url("https://url1").build());
//		gifs.add(GIFClient.builder().id("id2").url("https://url2").build());
//		gifs.add(GIFClient.builder().id("id3").url("https://url3").build());
//		gifs.add(GIFClient.builder().id("id4").url("https://url4").build());
//		gifs.add(GIFClient.builder().id("id5").url("https://url5").build());
//		return GIFResponseClient.builder().gifs(gifs).pagination(Pagination.builder().count(5).offSet(0).totalCount(10).build()).build();
//	}
}
