package com.example;

import javax.validation.constraints.Pattern;

public class SearchForm {

	@Pattern(regexp="[0-9]*")
	String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
