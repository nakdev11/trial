package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchResultDto {

	@JsonProperty("total_hit_count")
	Integer totalHitCount;
	
	@JsonProperty("rest")
	Rest[] rest;

	public Integer getTotalHitCount() {
		return totalHitCount;
	}

	public void setTotalHitCount(Integer totalHitCount) {
		this.totalHitCount = totalHitCount;
	}

	public Rest[] getRest() {
		return rest;
	}

	public void setRest(Rest[] rest) {
		this.rest = rest;
	}
	
	
}
