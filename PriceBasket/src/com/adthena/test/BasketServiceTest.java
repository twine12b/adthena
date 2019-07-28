package com.adthena.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.adthena.domain.Basket;
import com.adthena.domain.Goods;
import com.adthena.domain.Offer;
import com.adthena.service.BasketService;

public class BasketServiceTest {
	
	private BasketService util;

	@SuppressWarnings("static-access")
	@Test
	public void test_getData_shouldReturnGoodsList() {
		List<Goods> items = util.getData();
		
		assertTrue(items.get(0).getName().equalsIgnoreCase("Soup"));
		assertTrue(items.get(0).getPrice() == 0.65);
		
		assertTrue(items.get(1).getName().equalsIgnoreCase("Bread"));
		assertTrue(items.get(1).getPrice() == 0.80);
		
		assertTrue(items.get(2).getName().equalsIgnoreCase("Milk"));
		assertTrue(items.get(2).getPrice() == 1.30);
		
		assertTrue(items.get(3).getName().equalsIgnoreCase("Apples"));
		assertTrue(items.get(3).getPrice() == 1.00);
		
		assertTrue(items.size() == 4);
	}
	
	@Test
	public void test_getAllOffers_shouldReturnOffers() {
		@SuppressWarnings("static-access")
		List<Offer> offers = util.getAllOffers();
		
		assertTrue(offers.get(0).getTriggerItem().equalsIgnoreCase("Apples"));
		assertTrue(offers.get(0).getTriggerQty() == 1);
		assertTrue(offers.get(0).getOfferItem().equalsIgnoreCase("Apples"));
		assertTrue(offers.get(0).getOfferDiscount() == 0.10);
		
		assertTrue(offers.get(1).getTriggerItem().equalsIgnoreCase("Soup"));
		assertTrue(offers.get(1).getTriggerQty() == 2);
		assertTrue(offers.get(1).getOfferItem().equalsIgnoreCase("Bread"));
		assertTrue(offers.get(1).getOfferDiscount() == 0.50);
		
		assertTrue(offers.size() == 2);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test_addItemsToBasket_shouldReturnFilledBasket() {
		String[] args = {"Apples", "Milk", "Bread"};
		
		Basket myBasket = util.addItems(args);
		
		assertTrue(myBasket.getItems().get(0).getItem().getName().equalsIgnoreCase("Apples"));
		assertTrue(myBasket.getItems().get(0).getItem().getPrice() == 1.00);
		
		assertTrue(myBasket.getItems().get(1).getItem().getName().equalsIgnoreCase("Milk"));
		assertTrue(myBasket.getItems().get(1).getItem().getPrice() == 1.30);
		
		assertTrue(myBasket.getItems().get(2).getItem().getName().equalsIgnoreCase("Bread"));
		assertTrue(myBasket.getItems().get(2).getItem().getPrice() == 0.80);
		
		assertTrue(myBasket.getItems().size() == 3);		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test_NumberOfAcutualDiscounts() {
		// When No. tins of Soup = 2 and discount rate is 2 tins and bread in basket = 1
			assertEquals(util.noOfTimesDiscountCanBeApplied(2, 2, 2), 1);
			
		// When No. tins of Soup = 4 and discount rate is 2 tins and bread in basket = 2
			assertEquals(util.noOfTimesDiscountCanBeApplied(4, 2, 2), 2);
		
		// When No. tins of Soup = 4 and discount rate is 2 tins and bread in basket = 2
			assertEquals(util.noOfTimesDiscountCanBeApplied(4, 2, 3), 2);
		
		// When No. tins of Soup = 5 and discount rate is 2 tins and bread in basket = 2
			assertEquals(util.noOfTimesDiscountCanBeApplied(5, 2, 3), 2);	
			
		// When No. tins of Soup = 5 and discount rate is 2 tins and bread in basket = 0
			assertEquals(util.noOfTimesDiscountCanBeApplied(5, 2, 0), 0);					
	}
	

}
