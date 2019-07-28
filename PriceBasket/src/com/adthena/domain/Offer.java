/**
 * 
 * @author Richard Renaud
 * 
 * -- TriggerItem -- 
 *  An item of Goods which induces discount.
 *  
 * -- TriggerQty --
 * Number of Goods items required to induce discount.  
 * 
 * -- OfferItem --
 * Item that discount will be applied to.
 * 
 * -- OfferDiscount --
 * Amount of discount to be applied to offer.
 */
package com.adthena.domain;

public class Offer {
	
	private String triggerItem;
	private int triggerQty;
	private String offerItem;
	private double offerDiscount;
	
	// Default Constructor
	public Offer() {}
	public Offer(String item, int qty, String offerItem, double offerDiscount) {
		this.triggerItem = item;
		this.triggerQty = qty;
		this.offerItem = offerItem;
		this.offerDiscount = offerDiscount;
	}
	
	public String getTriggerItem() {
		return triggerItem;
	}
	
	public void setTriggerItem(String triggerItem) {
		this.triggerItem = triggerItem;
	}
	
	public int getTriggerQty() {
		return triggerQty;
	}
	
	public void setTriggerQty(int triggerQty) {
		this.triggerQty = triggerQty;
	}
	
	public String getOfferItem() {
		return offerItem;
	}
	
	public void setOfferItem(String offerItem) {
		this.offerItem = offerItem;
	}
	
	public double getOfferDiscount() {
		return offerDiscount;
	}

	public void setOfferDiscount(double offerDiscount) {
		this.offerDiscount = offerDiscount;
	}

	public String toString() {
		return "Offer [triggerItem=" + triggerItem + ", triggerQty=" + triggerQty + ", offerItem=" + offerItem
				+ ", offerDiscount=" + offerDiscount + "]";
	}

	
}
