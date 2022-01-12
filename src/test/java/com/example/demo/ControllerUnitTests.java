package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sofi.demo.controller.GifController;
import com.sofi.demo.model.GIF;
import com.sofi.demo.model.GIFResponse;
import com.sofi.demo.service.IGifService;

@ExtendWith(MockitoExtension.class) 
public class ControllerUnitTests {
	
	@Mock
	IGifService gifService;
	
	@InjectMocks
	GifController gifController;
	
	private GIFResponse getGIFResponse() {
		List<GIF> gifs = new ArrayList<>();
		gifs.add(GIF.builder().gifId("id1").url("https://url1").build());
		gifs.add(GIF.builder().gifId("id2").url("https://url2").build());
		gifs.add(GIF.builder().gifId("id3").url("https://url3").build());
		gifs.add(GIF.builder().gifId("id4").url("https://url4").build());
		gifs.add(GIF.builder().gifId("id5").url("https://url5").build());
		return GIFResponse.builder().gifs(gifs).build();
	}
	
//	@Test
//	public void getGifs() throws Exception {
//		Mockito.when(gifService.callGiphyApi(Mockito.anyString())).thenReturn(getGIFResponse());
//		ResponseEntity<GIFResponse> response = gifController.getGifs("cheeseburger");
//		assertEquals(response.getStatusCode(), HttpStatus.OK);
//		assertTrue(!response.getBody().getGifs().isEmpty());
//	}
//	
//	@Test
//	public void getGifsEmptyOutput() throws Exception {
//		Mockito.when(gifService.callGiphyApi(Mockito.anyString())).thenReturn(GIFResponse.builder().gifs(new ArrayList<>()).build());
//		ResponseEntity<GIFResponse> response = gifController.getGifs("cheeseburger");
//		assertEquals(response.getStatusCode(), HttpStatus.OK);
//		assertTrue(response.getBody().getGifs().isEmpty());
//	}
}
