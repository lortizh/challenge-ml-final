package com.chalenge.ml.clients;

import java.util.ArrayList;

public class Root {
	
    public String kind;
    public int totalItems;
    public ArrayList<Item> items;
    
    public Root() {
		// TODO Auto-generated constructor stub
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
    
    
}
