package com.sofi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.sofi.demo.model.GIF;
import com.sofi.demo.model.GIFResponse;
import com.sofi.demo.service.IGifService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class GifController implements IGifController{
	
	@Autowired
	private IGifService gifService;
	
	
/*
 * 
 * You should return a JSON result in a format similar to this:
        	    {
        	    	data: [
        	        	{
                                	gif_id: "FiGiRei2ICzzG",
                                	url: "http://giphy.com/gifs/funny-cat-FiGiRei2ICzzG%22
        	        	}
        	    	],
                    	last_page: true // Boolean that should return true/false based on whether this              
                                                // is the last page of results.    
                                                // Ideally ask the candidate how they would indicate to the FE, 
                                                // whether there are more results for the query
				 // This param should use the pagination response in the BE
        	    }
 * 
 * */	

	
	@Override
	public ResponseEntity<GIFResponse> getGifs(String searchTerm, int pageNumber) throws Exception{
		try {
			return ResponseEntity.ok(gifService.callGiphyApi(searchTerm, pageNumber));	
		}
		catch(WebClientResponseException ex) {
			log.error(ex.getMessage());
			throw ex;
		}
		catch(Exception ex) {
			log.error(ex.getMessage());
			throw new WebClientResponseException(500, ex.getLocalizedMessage(), null, null, null);
		}
	}


}
