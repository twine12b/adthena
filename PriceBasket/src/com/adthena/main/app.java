/**
 * @author twine
 * 
 * There are 2 types of discounts.
 * - Standard discount which apples to same item
 * - Multi-purchase discount which discounts a separate item
 * 
 *  Assumptions
 *  ===========
 *  
 *  - No validation has been done.  We assume that the command line input data
 *    has been checked and verified.
 *    
 *  - There may be more than 1 discount applied to a single basket of items.
 *  - Removing or modifying basket items is NOT in the brief so has not been implemented 
 *  - Unrecognised items will simply be ignored e.g. No Specific error feedback
 */
package com.adthena.main;

import java.util.List;

import com.adthena.domain.Basket;
import com.adthena.domain.Offer;
import com.adthena.service.BasketService;

public class app {
	
	//Default Constructor
	public app() {}
	
	private static BasketService util;	
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// Get hard coded Data items
		List<Offer> offers = util.getAllOffers();
				
		Basket myBasket = util.addItems(args); //populate a basket with selected items	
	
		// Display subtotal	
		util.printSubTotal(myBasket.getSubtotal());
		
		// Display Discounts
		util.displayDiscounts(myBasket, offers);
			
		// Display GradTotal
		util.printTotal(myBasket.getSubtotal());
	}
		
}
