package com.adthena.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.adthena.domain.Basket;
import com.adthena.domain.Goods;
import com.adthena.service.BasketService;
import com.adthena.utils.BasketItem;

public class GoodsTest {
	
	List<BasketItem> basketList = new ArrayList<>();
	private BasketService util;

	@Before
	public void create_Goodtest() {
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
		
			this.basketList.add(item1);
			this.basketList.add(item2);
			this.basketList.add(item3);
			this.basketList.add(item4);
			
			
			
		assertTrue(basketList.size() == 4); //Check 4 items in list
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void getgoodsList_ShouldReturn_ListOfGoods() {
		List<Goods>myList = new ArrayList<>();
		myList = util.getData();
		
		assertTrue(myList.size() == 4);
		//Test item from 1 in list
		assertTrue(myList.get(0).getName() == "Soup");
		assertTrue(myList.get(0).getPrice() == 0.65);
//		assertTrue(myList.get(0).getDiscount() == 0.00);
				//Test item from 2 in list
				assertTrue(myList.get(1).getName() == "Bread");
				assertTrue(myList.get(1).getPrice() == 0.80);
//				assertTrue(myList.get(1).getDiscount() == 0.00);
		//Test item from 3 in list
		assertTrue(myList.get(2).getName() == "Milk");
		assertTrue(myList.get(2).getPrice() == 1.30);
//		assertTrue(myList.get(2).getDiscount() == 0.00);
				//Test item from 4 in list
				assertTrue(myList.get(3).getName() == "Apples");
				assertTrue(myList.get(3).getPrice() == 1.00);
//				assertTrue(myList.get(3).getDiscount() == 0.10);
				
	}
	
	@Test
	public void test_CreateBasket_shouldReturnBasket() {
		Basket myBasket = new Basket();
			
			for(BasketItem b : basketList) {
				myBasket.addItem(b);
			}
			
			
			assertTrue(myBasket.getItems().size() == 4);
			
			assertTrue(myBasket.getItems().get(0).getItem().getName() == "Soup");
			assertTrue(myBasket.getItems().get(0).getItem().getPrice() == 0.65);
//			assertTrue(myBasket.getItems().get(0).getDiscount() == 0.00);
			assertTrue(myBasket.getItems().get(1).getItem().getName() == "Bread");
			assertTrue(myBasket.getItems().get(1).getItem().getPrice() == 0.80);
//			assertTrue(myBasket.getItems().get(1).getDiscount() == 0.00);
			assertTrue(myBasket.getItems().get(2).getItem().getName() == "Milk");
			assertTrue(myBasket.getItems().get(2).getItem().getPrice() == 1.30);
//			assertTrue(myBasket.getItems().get(2).getDiscount() == 0.00);
			assertTrue(myBasket.getItems().get(3).getItem().getName() == "Apples");
			assertTrue(myBasket.getItems().get(3).getItem().getPrice() == 1.00);
//			assertTrue(myBasket.getItems().get(3).getDiscount() == 0.1);
			
	}
	
//	@Test
	public void getBasketSubtotal() {
		Basket myBasket = new Basket();

		//Test Empty basket
		assertTrue(myBasket.getSubtotal() == 0.00);
		
			myBasket.addItem(basketList.get(0));		
			assertTrue(Math.round(myBasket.getSubtotal() * 100.0) / 100.0 == 0.65);   // 0.00 + 0.65
			System.out.println("subtotal is:  " + Math.round(myBasket.getSubtotal() * 100.0) / 100.0);
			
			myBasket.addItem(basketList.get(1));			
			assertTrue(Math.round(myBasket.getSubtotal() * 100.0) / 100.0 == 1.45);  // 0.65 + 0.80
			System.out.println("subtotal is:  " + Math.round(myBasket.getSubtotal() * 100.0) / 100.0);
			
			myBasket.addItem(basketList.get(2));			
			assertTrue(Math.round(myBasket.getSubtotal() * 100.0) / 100.0 == 2.75);  // 1.45 + 1.30
			System.out.println("subtotal is:  " + Math.round(myBasket.getSubtotal() * 100.0) / 100.0);
			
			myBasket.addItem(basketList.get(3));			
			assertTrue(Math.round(myBasket.getSubtotal() * 100.0) / 100.0 == 3.75);  // 2.75 + 1.00
			System.out.println("subtotal is:  " + Math.round(myBasket.getSubtotal() * 100.0) / 100.0);
	}
	
	@Test
	public void testBasketDuplicatItem_shouldReturnQuantity_forEachItem() {
		Basket myBasket = new Basket();
		
		myBasket.addAndUpdateQty(basketList.get(0));
		myBasket.addAndUpdateQty(basketList.get(0));
		myBasket.addAndUpdateQty(basketList.get(1));
		myBasket.addAndUpdateQty(basketList.get(2));
		myBasket.addAndUpdateQty(basketList.get(2));
		myBasket.addAndUpdateQty(basketList.get(3));
		
		System.out.println(
			myBasket.getItems().toString()	
			);
		
		System.out.println(Math.round(myBasket.getSubtotal() * 100.0) / 100.0);
		assertTrue(Math.round(myBasket.getSubtotal() * 100.0) / 100.0 == 5.70);
		
	}
	
	@Test
	public void testItemInList_returnBooelan() {
		Basket myBasket = new Basket();
		
		myBasket.addItem(basketList.get(0));	
		myBasket.addItem(basketList.get(1));
		
		assertTrue(myBasket.isInlist("Soup"));
		assertTrue(myBasket.isInlist("Bread"));
		assertFalse(myBasket.isInlist("Milk"));
		assertFalse(myBasket.isInlist("Apples"));
	
	}
	
}
