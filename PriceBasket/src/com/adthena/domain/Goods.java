/**
 * Models a Goods item with the addition of quantity and discount
 * 
 * discount
 * - stores standard discounts which are applied to items. 
 *   e.g. Apples have a 10% discount off their normal price this week.
 *   
 * qty
 * - when goods are added to a basket this will store the number of a 
 *   particular goods item in the given basket.
 *   e.g.  Soup has [qty] of 2, therefore there are 2 Soup tins in the basket.   
 */
package com.adthena.domain;

public class Goods {

	private String name;
	private double price;

	public Goods() {}
	public Goods(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Goods [name=" + name + ", price=" + price + "]";
	}
	
}
