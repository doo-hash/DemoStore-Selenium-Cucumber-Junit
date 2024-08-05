@all
Feature: User searches for a product in demo store application

  @search @smoke @regression
  Scenario Outline: User searches a product
  	When user login to the application with "johndrew@gmail.com" and "Password123"
  	And user was navigated back to home page
    When user enters product name "<product>"
    And user finds searched product "<product>"
    And user clicks product name link
    Then user checks product details
    And user logs out of the application

	Examples:
	| product            |
	| Selene Yoga Hoodie |
    