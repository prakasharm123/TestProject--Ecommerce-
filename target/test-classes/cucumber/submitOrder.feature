@tag
Feature: Purchase the order from Ecommerce
	I want to use this tamplate for my feature
	
	Background:
	Given land on Ecommerce page
	
	@Regression
	Scenario Outline: Positive Test of submitting the order
	
		Given logged in with username <name> and password <password>
		When I add product <productName> to cart
		And checkout with <country> and submit the order
		Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page 
		
		Examples:
	 		| name                              |password|productName|country|
	 		|sharmaprakash1234321@gmail.com     |Durga111@|ZARA COAT 3|India|
