package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

	@Autowired
	ShopSearchService sss;
	
	// レストラン検索画面を表示する
	@GetMapping("/")
	public String search(Model model) {
		model.addAttribute("msg", "レストラン検索");
		return "search";
	}
	
	// 検索ボタンを押下した時にぐるなびAPIを叩いて、検索結果画面へ遷移する
	@PostMapping("/")
	public String searchExec(
			Model model,
			@RequestParam("name") String name) {
		model.addAttribute("msg", "レストラン検索結果");
		// 店舗検索サービスを呼び出し、レストラン情報を取得し、結果をmodelへ設定する
		SearchResultDto searchResultDto = sss.search(name);
		model.addAttribute("restList", searchResultDto.getRest());
		// 検索結果画面へ遷移する
		return "search_result";
	}
	
}
