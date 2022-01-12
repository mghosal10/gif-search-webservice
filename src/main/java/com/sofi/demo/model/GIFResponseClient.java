package com.sofi.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class GIFResponseClient {
	
	@JsonProperty("data")
	private List<GIFClient> gifs;
	private Pagination pagination;
	private Metadata meta;
	
	@Data
	@Builder
	public static class GIFClient{
		private String id;
		private String url;
		
		public GIFClient() {
			
		}
		
		public GIFClient(String id, String url) {
			this.id = id;
			this.url = url;
		}
	}
	
	@Data
	@Builder
	public static class Pagination{
		public Pagination(int totalCount, int count, int offSet) {
			super();
			this.totalCount = totalCount;
			this.count = count;
			this.offSet = offSet;
		}
		public Pagination() {
			super();
			// TODO Auto-generated constructor stub
		}
		@JsonProperty("total_count")
		private int totalCount;
		private int count;
		private int offSet;
	}
	
	@Data
	public static class Metadata{
		public Metadata() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Metadata(String status, String message, String responseId) {
			super();
			this.status = status;
			this.message = message;
			this.responseId = responseId;
		}
		private String status;
		@JsonProperty("msg")
		private String message;
		@JsonProperty("response_id")
		private String responseId;
	}
	
	public GIFResponseClient(List<GIFClient> gifs, Pagination pagination,  Metadata meta) {
		this.gifs = gifs;
	    this.pagination = pagination;
		this.meta = meta;
	}
	
	public GIFResponseClient() {
		
	}
}
