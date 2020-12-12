package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rest {

	@JsonProperty("name")
	String name;
	
	@JsonProperty("category")
	String category;
	
	@JsonProperty("address")
	String address;
	
	@JsonProperty("tel")
	String tel;

	@JsonProperty("image_url")
	ImageUrl imageUrl;
	
	public ImageUrl getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(ImageUrl imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
