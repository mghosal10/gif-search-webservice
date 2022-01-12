package com.sofi.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sofi.demo.model.GIFResponse;

@RequestMapping()
public interface IGifController {
	
	@GetMapping(path="/search/{searchTerm}", produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<GIFResponse> getGifs(@PathVariable String searchTerm, @RequestParam int pageNumber) throws Exception;

}
