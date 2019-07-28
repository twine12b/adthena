/**
 * Discounts are not persisted so appear under the utils package
 */
package com.adthena.utils;

import com.adthena.domain.Offer;

public class Discount {

	private Offer offer;
	private double subtotal;

	public Discount() {
	}

	public Discount(Offer offer, double subtotal) {
		this.offer = offer;
		this.subtotal = subtotal;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public String toString() {
		return "Discount [offer=" + offer + ", subtotal=" + subtotal + "]";
	}

}
