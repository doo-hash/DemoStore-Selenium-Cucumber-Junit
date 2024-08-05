@all
Feature: User buys a product in demo store application

Background:
  	When user login to the application with "johndrew@gmail.com" and "Password123"
  	And user was navigated back to home page

  @product @smoke @regression
  Scenario: User buys a product
    When user search and find product "Selene Yoga Hoodie"
		And user selects color and size
		And user adds product to cart
		Then user clicks checkout button
		And user verifies address and order details
		And user clicks place order button
		Then user checks order receipt "Selene Yoga Hoodie" 
		And user signs out of the application