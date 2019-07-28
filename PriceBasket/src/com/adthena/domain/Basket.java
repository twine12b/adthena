/**
 * @author Richard Renaud
 * 
 * Creates an instance on a shopping basket that stores a list
 * of BasketItem/s whilst keeping track of the total cost of all the items in the basket.
 * 
 * Assumptions
 * - The brief did NOT specify removal of items from the basket. function not implemented.
 * - The brief did NOT specify modifying the basket. function not implemented. 
 * - Basket is in the form of an entity.  Assumes retrieval of basket/s at a later stage.
 * 
 * -- Items --
 * BasketItem list which is a composite object of goods + quantity
 * 
 * -- Subtotal --
 * Calculated total of all items in the list
 */
package com.adthena.domain;

import java.util.ArrayList;

import com.adthena.utils.BasketItem;

public class Basket {

	private ArrayList<BasketItem> items;
	private float subtotal = (float) 0.00;

	//Default Constructors
	public Basket() {
		this.items = new ArrayList<BasketItem>();
	}

	public void addItem(BasketItem item) {
		this.items.add(item);
		this.subtotal += item.getItem().getPrice();
	}

	public ArrayList<BasketItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<BasketItem> items) {
		this.items = items;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal += subtotal;
	}

	public double getSubtotal() {
		return subtotal;
	}

	/**
	 * Store item using the following conditions:
	 * - add item to list if basket list isEmpty
	 * - increase item quantity if item already on list
	 * - add item to list if list not empty and item not on list
	 * 
	 * @param goods
	 */
	public void addAndUpdateQty(BasketItem goods) {
		
		if(this.getItems().isEmpty()) {
			addItem(goods);
		} else if(isInlist(goods.getItem().getName())) {
			 }  else {
				addItem(goods);
			}
		}
	
	/**
	 * Increase item quantity if item already on basket list
	 * 
	 * @param itemName
	 * @return
	 */
	public boolean isInlist(String itemName) {
		boolean b = false;
		for(int x=0; x < this.items.size(); x++) {
			if(this.items.get(x).getItem().getName()  == itemName) {
				
				b = true;

				  this.items.get(x).setQty(
						  this.items.get(x).getQty()  +1);
				  
				  setSubtotal(this.items.get(x).getItem().getPrice());  // Update subtotal

			} //end if
		 }  //end loop
		
		return b;
	}
	

}
