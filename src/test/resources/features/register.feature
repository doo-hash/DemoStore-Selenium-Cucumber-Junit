@all
Feature: User creates an account in demo store application

Background:
    Given user navigates to register page

  @register @validRegister @smoke @regression
  Scenario: User registers with all fields
    When user enters firstname "John"
    And user enters lastname "Drew"
    And user enters new random email
    And user enters new password "Password123"
    And user enters confirm password "Password123"
    And user clicks create account button
    Then user was navigated back to customer page
    And user name in welcome message "John Drew"

  @register @invalidRegisterCredentials
  Scenario Outline: User registers with invalid data
    When user enters firstname "<firstname>"
    And user enters lastname "<lastname>"
    And user enters new email "<email>"
    And user enters new password "<password>"
    And user enters confirm password "<password>"
    And user clicks create account button
    Then user should get proper register warning message

    Examples: 
      | firstname | lastname | email              | password    |
      | John12    | Drew12   | johndrew@gmail.com | wqassword   |
      | 45        | 12       | johndrew@com       | wqa   |
      
  @register @emptyCredentials @smoke @regression
  Scenario: User registers with empty credentials
    When user doesnot enters any details
    And user clicks create account button
    Then user gets firstname warning message "This is a required field."
    And user gets lastname warning message "This is a required field."
   	And user gets email error message "This is a required field."
    And user gets password and confirm password warning message "This is a required field."
            