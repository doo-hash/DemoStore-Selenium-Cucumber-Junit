#Author: your.email@your.domain.com
@all
Feature: User login to demo store application
  User wants to login and manage his/her account details and orders

Background:
    Given user navigates to login page

  @login @validCredentials @smoke @regression
  Scenario: User logins with valid credentials
    When user enters email "johnDrew@test.com"
    And user enters password "Password123"
    And user clicks login button
    Then user was navigated back to home page
    And user name is visible "John Drew"

  @login @invalidCredentials
  Scenario Outline: User logins with invalid credentials
    When user enters email "<email>"
    And user enters password "<password>"
    And user clicks login button
    Then user should get proper warning message

    Examples: 
      | email               | password    |
      | feary@waq.com       | Password123 |
      | johnDrew@test.com   | wpasswed    |
      | johndrewos@test.com | wpasswed    |
      | john_@@test.com     | wpa@!swed   |

  @login @emptyCredentials @smoke @regression
  Scenario: User logins with empty credentials
    When user doesnot enters credentials
    And user clicks login button
    Then user gets email warning message "This is a required field."
    And user gets password warning message "This is a required field."