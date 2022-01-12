package com.sofi.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.sofi.demo.model.GIF;
import com.sofi.demo.model.GIFResponse;
import com.sofi.demo.model.GIFResponseClient;
import com.sofi.demo.model.GIFResponseClient.GIFClient;
import com.sofi.demo.utils.Constants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GifService implements IGifService{
	
	@Autowired
	private WebClient webClient;
	
	@Value("${apiKey}")
	private String apiKey; 
	
	@Value("${requiredCount}")
	private int requiredCount; 
	
	public GIFResponse callGiphyApi(String searchTerm, int pageNumber){
		log.info("GIF search term : {}", searchTerm);
		try {
			ResponseEntity<GIFResponseClient> res = webClient.get().uri(Constants.GIPHY_URL, apiKey, searchTerm, pageNumber*5).retrieve().toEntity(GIFResponseClient.class).block();
			GIFResponseClient clientRes = res.getBody();
			
			if(validate(clientRes)) {
				log.info("Found total: {} records for GIF search term : {}", clientRes.getPagination().getCount(), searchTerm);
				List<GIF> gifs = new ArrayList<>();
				boolean lastPage = false;
				
				for(GIFClient gif : clientRes.getGifs()) {
					gifs.add(GIF.builder().gifId(gif.getId()).url(gif.getUrl()).build());
				}
				
				if(clientRes.getPagination().getTotalCount()/5 == pageNumber || (clientRes.getPagination().getTotalCount()%5==0 && clientRes.getPagination().getTotalCount()/5 == pageNumber+1)) {
					lastPage = true;
				}
				
				return GIFResponse.builder().gifs(gifs).lastPage(lastPage).build();
			} else {
				log.info("Found no records/less than required records i.e. {} for GIF search term : {}", requiredCount, searchTerm);
				return GIFResponse.builder().gifs(new ArrayList<>()).lastPage(true).build();
			}
		}
		catch(Exception ex) {
			log.error("Failed to search gif data");
			ex.printStackTrace();
			throw ex;
		}
	}
	
	private boolean validate(GIFResponseClient clientRes) {
		if(clientRes==null || clientRes.getGifs()==null || clientRes.getGifs().isEmpty() || clientRes.getGifs().size()<requiredCount) {
			return false;
		}
		return true;
	}

}
