package com.sofi.demo.service;

import com.sofi.demo.model.GIFResponse;

public interface IGifService {
	
	GIFResponse callGiphyApi(String searchTerm, int pageNumber);

}
