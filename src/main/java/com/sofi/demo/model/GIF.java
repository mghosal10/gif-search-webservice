package com.sofi.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GIF {
	
	@JsonProperty("gif_id")
	private String gifId;
	
	private String url;
}
