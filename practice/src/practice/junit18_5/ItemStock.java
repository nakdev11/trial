package practice.junit18_5;

import java.util.ArrayList;
import java.util.List;

public class ItemStock {

	List<Item> list = new ArrayList<>();

	void add(Item item) {
		list.add(item);
	}

	int getNum(Item item) {
		int cnt = 0;
		for (Item itemStock : list) {
			if (itemStock.name == item.name) {
				cnt++;
			}
		}
		return cnt;
	}



}
