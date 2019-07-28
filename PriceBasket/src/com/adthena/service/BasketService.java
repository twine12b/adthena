/**
 * @author Richard Renaud
 * 
 * Collection of methods that perform all basket functions 
 * 
 * Note: All data is hard coded. The get data method can 
 * be enhanced to retrieve from a database
 */
package com.adthena.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.adthena.domain.Basket;
import com.adthena.domain.Goods;
import com.adthena.domain.Offer;
import com.adthena.utils.BasketItem;
import com.adthena.utils.Discount;

public class BasketService {
	
	//Default Constructor
	public BasketService() {}
	
	/**
	 * Fixes double display issues
	 * @param number
	 * @return
	 */
	public static BigDecimal fixNumberFormat(double number) {
		return new BigDecimal(number).setScale(2, RoundingMode.HALF_UP);
	}
	
	/**
	 * Prints formatted discount line as specified in the brief.
	 * 
	 * @param name
	 * @param rate
	 * @param val
	 */
	public static void printDiscount(String name, double rate, double val) {
		System.out.println(name + " " + new Integer((int) (rate * 100))
				+"% off: -" + new Integer ((int) (val*100)) +"p");
	}
	
	/**
	 * Calculates the actual number of times that a discount can be applied
	 * @param itemQty
	 * @param offerQty
	 * @return
	 */
	public static int noOfTimesDiscountCanBeApplied(int itemQty, int offerQty, int offerItemQty) {
		int noOfPossibleDiscounts = itemQty / offerQty;
		if(offerItemQty <= noOfPossibleDiscounts) {
			return offerItemQty;
		} else {
			return noOfPossibleDiscounts;
		}
 
	}

	/**
	 * return total discount of a single basket item
	 * 
	 * @param noOfActualDiscounts
	 * @param itemPrice
	 * @param disCountRate
	 */
	public static double getDiscountTotal(int noOfActualDiscounts, double itemPrice, double disCountRate) {
		return (noOfActualDiscounts * (itemPrice * disCountRate));
	}
	
	/**
	 * Add Selected items to basket
	 * @param args
	 * @return
	 */
	public static Basket addItems(String[] args) {
		List<Goods> items = getData(); // get all Data items
		Basket myBasket = new Basket();
		
		// Populate basket and ignoring invalid items 
		for(String s: args) {
			for(Goods g : items) {
				if(s.equalsIgnoreCase(g.getName())) {
					myBasket.addAndUpdateQty(new BasketItem(g, 1));					
				}
			}
		} //end loop
		
		return myBasket;	
	}
	
	/**
	 * Returns Hard coded list of Goods
	 * @return
	 */
	public static List<Goods> getData(){
		List<Goods> lst = new ArrayList<>();
		
		lst.add(new Goods("Soup", 0.65));
		lst.add(new Goods("Bread", 0.80));
		lst.add(new Goods("Milk", 1.30));
		lst.add(new Goods("Apples", 1.00));
		
		return lst;
		
	}

	/**
	 * Returns hard coded list of Offers
	 * @return
	 */
	public static List<Offer> getAllOffers() {
		List<Offer> offers = new ArrayList<>();
		
		offers.add(new Offer("Apples", 1, "Apples", 0.10));
		offers.add(new Offer("Soup", 2, "Bread", 0.5));
		
		return offers;
	}
	
	/**
	 * Prints basket subtotal
	 * @param subtotal
	 */
	public static void printSubTotal(double subtotal) {
		System.out.println("Subtotal: £" + fixNumberFormat(subtotal));
		
	} 
	
	/**
	 * Prints Basket total 
	 * @param total
	 */
	 public static void printTotal(double total) {
		System.out.println("Total price: £" + fixNumberFormat(total));
			
		}
		
		/**
		 * Prints if basket has no offers
		 */
		public static void printNoOffersAvailable () {
			System.out.println("(No offers available)");
		}
		

		/**
		 * Get Active Basket Discounts
		 * @param myBasket
		 * @param offers
		 * @return
		 */
		public static List<Discount> getActiveDiscounts(Basket myBasket, List<Offer> offers) {

			List<Discount> discounts = new ArrayList<>();
			List<BasketItem> basketList = myBasket.getItems();
			String offerName = "-1";
						
			//Loop through offers
			for(Offer o : offers) {
				offerName = o.getTriggerItem();
				
				for(BasketItem item : basketList) {
					// Check if Offer applies to item in basket
					if(item.getItem().getName().equalsIgnoreCase(offerName) && item.getQty() >= o.getTriggerQty() ) {
						
						// find if list has offerItem
						for(BasketItem offerItem : basketList) {
							if(offerItem.getItem().getName().equalsIgnoreCase(o.getOfferItem())) {
								
								//calculate discount value
								int actualDiscounts = noOfTimesDiscountCanBeApplied(item.getQty(), o.getTriggerQty(), offerItem.getQty());
								double discountVal = getDiscountTotal(actualDiscounts, offerItem.getItem().getPrice(), o.getOfferDiscount());
								
								//create a new discount
								discounts.add(new Discount(o, discountVal));
								
								// apply discount to subtotal						
								myBasket.setSubtotal(-discountVal); 
								
							}
						}
					}
					
				}
			}
			
			return discounts;
		}
		
		/**
		 * Display Active discounts
		 * @param myBasket
		 * @param offers
		 */
		public static void displayDiscounts(Basket myBasket, List<Offer> offers) {
			List<Discount> activeDiscounts = getActiveDiscounts(myBasket, offers); 
			if(activeDiscounts.isEmpty() == true) {
				printNoOffersAvailable();
			} else {
				for(Discount d : activeDiscounts) {
					printDiscount(d.getOffer().getTriggerItem(), d.getOffer().getOfferDiscount(), d.getSubtotal());
				}
			}
			
		}

}
