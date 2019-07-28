# Adthena Technical Test

## Coding Test - Shopping Basket
Write a program driven by unit tests that can price a basket of goods taking into account some special offers.

The goods that can be purchased, together with normal prices are:
```
* Soup - 65p per tin
* Bread - 80p per loaf
* Milk - £1.30 per bottle
* Apples - £1.00 per bag
```

Current Special Offers
```
* Apples have a 10% discount off their normal price this week.
* Buy 2 tins of Soup and get a loaf of Bread for half price. 
```

The program should accept a list of items in the basket and output the subtotal, the special offer discounts
and the final price.

Input should be via the command line in the form PriceBasket item1 item2 item3 ...

For example:

PriceBasket Apples Milk Bread

```
Output should be to the console, for example:
Subtotal: £3.10
Apples 10% off: 10p
Total: £3.00
```


```
If no special offers are applicable the code should output:
Subtotal: £1.30
(No offers available)
Total price: £1.30
```


## The Approach
Create Entities to mock `Basket / Goods / Offers`
Basket will have a list of goods and 
Will hold subtotal/total values.

Create composite objects `Discount and BasketItem`. A Discount is an OFFER with a quantity.  A BasketItem is a GOODS with a quantity.
```
* BASKETITEM summary of each type of 'GOODS' that has been added to the basket. [e.g. 2 Soup, 1 Milk etc...]
* DISCOUNT summary of the discount being applied to each item in the basket 'IF' the discount rules apply.
```

Multi buy discounts are applied to alternative items.  E.g. Buy 2 tins of Soup and get 50% off bread.  If no bread has been added to the basket and 2 tins of soup have been, then NO Discount should be applied as there is No bread in the list

A OFFER has a 'triggerItem' - [item that needs to be in the BASKET].  A 'triggerQty' - [the quantity of a particular item in the BASKET].  An 'OfferItem' - [The associated item that any discount will be applied to] and a 'offerDiscount' - [discount percentage].

##BasketService
```
== Methods ==
* addItem - takes a string and looks up the corresponding GOODS item before adding it to a BASKET.
* displayDiscounts - Displays all applicable DISCOUNT/s.
* fixNumberFormat - Fixes rounding issues when using type double.
* getActiveDiscounts - Gets all DISCOUNT/S that apply to a basket.
* getAllOffers - MOCKS a data fetch of objects of type OFFER.
* getData - Mocks a data fetch of objects of type GOODS.
* getDiscountTotal - total discount for a single basket item.
* noOfTimesDiscountCanBeApplied - decides how many times a discount can be applied to a BASKET item.
* Print Methods are self explanatory:
	- printDiscount ['prints 1 or more discount lines']
	- printNoOffersAvailable
	- printSubTotal
	- printTotal
  
```

##Running the App
```
* Copy the PriceBasket.jar file into a directory of your choosing.  
* Open a command /terminal window and navigate to the directory that you have copied the PriceBasket.jar into. 
* Type the following command:
* java -jar PriceBasket.jar item item item …

e.g.  java -jar PriceBasket.jar Soup Apples Milk Bread
```

`Note` - My Machines CLASSPATH was not configured so I was unable to compile and test the app using the given method of 'PriceBascket item item item ...'  Once compiled correctly the App should execute using the given format on the  command line.   