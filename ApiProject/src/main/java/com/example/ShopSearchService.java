package com.example;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShopSearchService {

	// RestTemplateクラスをインスタンス化
	RestTemplate restTemplate = new RestTemplate();
	
	// 店舗名称を渡して、レストラン情報DTOを返す
	public SearchResultDto search(String name) {
		
		// ぐるなびAPIのURI情報、{変数名}と書ける
		String URI = "https://api.gnavi.co.jp/RestSearchAPI/v3/?keyid=[アクセスキー]&name={name}";
		
		// ぐるなびのAPIを叩いている
		return restTemplate.getForObject(URI, SearchResultDto.class, name);
		
	}
	
}
