package helpers;

import java.util.ArrayList;

import db.Item;

public class ShoppingCart {
	private ArrayList<Item> items = new ArrayList<Item>();

	public ShoppingCart() {
		this.items = items;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public void clear() {
	items.clear();
	}

	public void removeItem(Item item) {
	items.remove(item);
	}

}
