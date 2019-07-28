package com.adthena.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.adthena.domain.Basket;
import com.adthena.domain.Goods;
import com.adthena.domain.Offer;
import com.adthena.service.BasketService;
import com.adthena.utils.BasketItem;

public class OffersTest {
	
	private Basket myBasket = new Basket();
	private BasketService util;
	private List<Offer> allOffers = new ArrayList<>();
	
	@Before
	public void setUp() {
		Offer offer1 = new Offer("Soup",  2, "Bread", 0.5);
		Offer offer2 = new Offer("Apples",  1, "Apples", 0.1);
		allOffers.add(offer1);
		allOffers.add(offer2);
		
		// Create 4 Goods items
		Goods g1 = new Goods("Soup", 0.65);
		Goods g2 = new Goods("Bread", 0.80);
		Goods g3 = new Goods("Milk", 1.30);
		Goods g4 = new Goods("Apples", 1.00);
		
		// basket item
		BasketItem item1 = new BasketItem(g1, 1);
		BasketItem item2 = new BasketItem(g2, 1);	
		BasketItem item3 = new BasketItem(g3, 1);	
		BasketItem item4 = new BasketItem(g4, 1);
		
		this.myBasket.addAndUpdateQty(item1);
		this.myBasket.addAndUpdateQty(item1);			
		this.myBasket.addAndUpdateQty(item2);
		this.myBasket.addAndUpdateQty(item3);
		this.myBasket.addAndUpdateQty(item4);
	}
	
	/**
	 * 4 x Soup
	 * 2 x tins before discount applied
	 * 3 x no of bread
	 */
	@SuppressWarnings("static-access")
	@Test
	public void test_noOfTimesDiscountCanBeApplied() {
		// When No. tins of Soup = 5 and discount rate is 2 tins and bread in basket = 1
		assertEquals(util.noOfTimesDiscountCanBeApplied(5, 2, 1), 1);
		
		// When No. tins of Soup = 4 and discount rate is 2 tins and bread in basket = 2
				assertEquals(util.noOfTimesDiscountCanBeApplied(5, 2, 2), 2);
		
		// When No. tins of Soup = 3 and discount rate is 2 tins and bread in basket = 5
		assertEquals(util.noOfTimesDiscountCanBeApplied(3, 2, 5), 1);		

	}
	

	@SuppressWarnings("static-access")
	@Test
	public void test_DiscountTotals_shouldReturnTotal() {		
//		assertEquals(app.getDiscountTotal(1, 0.8, 0.5), 0.40);
		
		assertTrue(util.getDiscountTotal(1, 0.8, 0.5) == 0.4);
		assertTrue(util.getDiscountTotal(2, 0.8, 0.5) == 0.8);
		assertTrue(util.getDiscountTotal(1, 1.0, 0.1) == 0.1);
	}

}
