package com.sofi.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GIFResponse {
	
	public GIFResponse(List<GIF> gifs, boolean lastPage) {
		super();
		this.gifs = gifs;
		this.lastPage = lastPage;
	}

	public GIFResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@JsonProperty("data")
	private List<GIF> gifs;
	
	@JsonProperty("last_page")
	boolean lastPage;
}
