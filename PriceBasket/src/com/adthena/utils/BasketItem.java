/**
 * Basket items and added to baskets
 */
package com.adthena.utils;

import com.adthena.domain.Goods;

public class BasketItem {
	
	private Goods item;
	private int qty;
	
	public BasketItem() {}
	public BasketItem(Goods item, int qty) {
		super();
		this.item = item;
		this.qty = qty;
	}

	public Goods getItem() {
		return item;
	}

	public void setItem(Goods item) {
		this.item = item;
	}
	
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String toString() {
		return "BasketItem [item=" + item + ", qty=" + qty + "]";
	}

}
