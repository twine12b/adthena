/**
 * Test Case mirrors command line input ONLY
 */
package com.adthena.test;

import org.junit.Test;

import com.adthena.main.app;

public class AppTest {
	
//	@Test
	public void testAppResults_PrintsResultsToConsole () {
//		String[] example1 = {"Apples", "Milk", "Bread"};
		
//		String[] example2 = {"Milk"};
		
//		String[] apples2 = {"Apples", "Milk", "Bread", "Apples"};
		
		String[] discounts2 = {"Apples", "Milk", "Soup", "Bread", "Apples", "Soup", "Soup", "Soup", "Soup", "Bread"};
		
//		String[] items = {"Soup", "Milk", "Bread", "Soup"}; 
		
		
		app.main(discounts2);
		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void run_App_withExample1Input() {
		app app = new app();
		System.out.println("-------------------------");
		String[] args = {"Apples", "Milk", "Bread"};
		app.main(args);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void run_App_withExample2Input() {
		app app1 = new app();
		System.out.println("-------------------------");
		String[] args = {"Milk"};
		app1.main(args);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void run_App_WithMultipleDiscounts() {
		app app = new app();
		System.out.println("-------------------------");
		String[] args = {"Apples", "Milk", "Soup", "Bread", "Apples", "Soup", "Soup", "Soup", "Soup", "Bread"};
		app.main(args);
		System.gc();
	}

	@SuppressWarnings("static-access")
	@Test
	public void run_App_WithNoDiscounts() {
		app app = new app();
		System.out.println("-------------------------");
		String[] args = {"Milk", "Soup", "Bread"};
		app.main(args);
		System.gc();
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void run_App_nonIdentifiedItems() {
		app app = new app();
		System.out.println("-------------------------");
		String[] args = {"Eggs", "Cheese", "Ham"};
		app.main(args);
		System.gc();
	}
	
	
}
