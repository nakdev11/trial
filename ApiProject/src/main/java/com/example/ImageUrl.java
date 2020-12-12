package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageUrl {

	@JsonProperty("shop_image1")
	String shopImage1;

	public String getShopImage1() {
		return shopImage1;
	}

	public void setShopImage1(String shopImage1) {
		this.shopImage1 = shopImage1;
	}
	
}
