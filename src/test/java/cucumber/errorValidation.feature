@tag
Feature: validate credentials 
	I want to use this tamplate for my feature
	
	Background:
	Given land on Ecommerce page
	
	@ErrorValidation
	Scenario Outline: Cheacking credentials are right or not 
	
		Given logged in with username <name> and password <password>
		When check incorrect email and password "Incorrect email or password." 

		Examples:
	 		| name                              |password |
	 		|sharmaprakash1234321@gmail.com     |Durga111 |
