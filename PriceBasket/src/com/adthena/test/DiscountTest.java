package com.adthena.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
import com.adthena.utils.Discount;

public class DiscountTest {
	
	private List<Discount> discounts = new ArrayList<>();
	private BasketService util = new BasketService();
	private List<Offer> offers = new ArrayList<>();
	private Basket myBasket = new Basket();
	
	
	@SuppressWarnings("unused")
	@Before
	public void setUp() {
		Offer offer1 = new Offer("Soup",  2, "Bread", 0.5);
		Offer offer2 = new Offer("Apples",  1, "Apples", 0.1);
		offers.add(offer1);
		offers.add(offer2);
		
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
		
		// Add Apples Milk Bread to basket
		this.myBasket.addAndUpdateQty(item4);
		this.myBasket.addAndUpdateQty(item3);
		this.myBasket.addAndUpdateQty(item2);
		
	}

	@Test
	public void test_createDuscount_shouldReturnDiscount() {
		Offer offer = new Offer("Apples",  1, "Apples", 0.1);
		Discount myDiscount = new Discount(offer, 0.1);
		
		assertNotNull(myDiscount);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test_activeBasketDiscounts_shouldReturnDiscount() {
		this.discounts = util.getActiveDiscounts(myBasket, offers);
		
		assertNotNull(discounts);
		
		assertTrue(discounts.get(0).getOffer().getTriggerItem().equalsIgnoreCase("Apples"));
		assertTrue(discounts.get(0).getSubtotal() == 0.10);
		
		assertEquals(discounts.size(), 1);
		
	}

	
}
