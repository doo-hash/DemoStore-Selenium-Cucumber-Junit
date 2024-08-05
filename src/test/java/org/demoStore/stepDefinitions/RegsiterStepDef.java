package org.demoStore.stepDefinitions;

import org.demoStore.pages.CreateAccountPage;
import org.demoStore.pages.CustomerPage;
import org.demoStore.pages.HomePage;
import org.demoStore.utilities.AppUtilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegsiterStepDef extends AppUtilities {
		
	@Given("user navigates to register page")
	public void user_navigates_to_register_page() {
		homePage = new HomePage(driver);
		accountPage = new CreateAccountPage(driver);

		homePage.clickCreateAccountElement();
		logger.trace("Create account button clicked");
		logger.info(driver.getCurrentUrl());
		logger.trace("Create account page opened");
	}

	@When("user enters firstname {string}")
	public void user_enters_firstname(String firstname) {
		accountPage.setFirstNameInput(firstname);
		logger.trace("First name entered");
	}

	@When("user enters lastname {string}")
	public void user_enters_lastname(String lastname) {
		accountPage.setLastNameInput(lastname);
		logger.trace("Last name entered");
	}

	@When("user enters new random email")
	public void user_enters_new_random_email() {
		accountPage.setEmailInput(getRandomString() + "@example.com");
		logger.trace("Random email entered");
	}

	@When("user enters new email {string}")
	public void user_enters_new_email(String email) {
		accountPage.setEmailInput(email);
		logger.trace("Email entered");
	}

	@When("user enters new password {string}")
	public void user_enters_new_password(String password) {
		accountPage.setPasswordInput(password);
		logger.trace("Password entered");
	}
	
	@When("user enters confirm password {string}")
	public void user_enters_confirm_password(String password) {
		accountPage.setConfirmPasswordInput(password);
		logger.trace("Confirm password entered");
	}

	@When("user clicks create account button")
	public void user_clicks_create_account_button() {
		accountPage.clickCreateAccountButton();
		logger.trace("Creat account button clicked");
	}

	@Then("user was navigated back to customer page")
	public void user_was_navigated_back_to_customer_page() {
		customerPage = new CustomerPage(driver);
		customerPage.getCreateAccountSuccessMessage();
		logger.info(driver.getCurrentUrl());
		logger.trace("Navigated to customer page");
	}

	@Then("user name in welcome message {string}")
	public void user_name_in_welcome_message(String username) {
		if(customerPage.isWelcomeElementPresent() && customerPage.getWelcomeMessage().contains(username)) {
			customerPage.getContactInfo();
			logger.trace("Username is visible");
		}else {
			logger.error("Username not found");
		}
	}

	@Then("user should get proper register warning message")
	public void user_should_get_proper_register_warning_message() {
		String message = accountPage.getErrorMessage();
		if(message.isEmpty()) {
			logger.trace("Warning message recieved");			
		}else {
			logger.warn("warning message not found");
		}

	}
	
	@When("user doesnot enters any details")
	public void user_doesnot_enters_any_details() {
		accountPage.setFirstNameInput(" ");
		accountPage.setLastNameInput(" ");
		accountPage.setEmailInput(" ");
		accountPage.setPasswordInput(" ");
		accountPage.setConfirmPasswordInput(" ");
		logger.trace("Empty credentials");	
	}
	
	@Then("user gets firstname warning message {string}")
	public void user_gets_firstname_warning_message(String message) {
		String fnMessage = accountPage.getFirstnameErrorMessage();
		if(fnMessage.equals(message)) {
			logger.trace("First name warning message is visible");			
		}else {
			logger.warn("Warning message not found");
		}
	}

	@Then("user gets lastname warning message {string}")
	public void user_gets_lastname_warning_message(String message) {
		String lnMessage = accountPage.getLastnameErrorMessage();
		if(lnMessage.equals(message)) {
			logger.trace("Last name warning message is visible");			
		}else {
			logger.warn("Warning message not found");
		}
	}

	@Then("user gets email error message {string}")
	public void user_gets_email_error_message(String message) {
		String emailMessage = accountPage.getEmailErrorMessage();
		if(emailMessage.equals(message)) {
			logger.trace("Email warning message is visible");			
		}else {
			logger.warn("Warning message not found");
		}
	}

	@Then("user gets password and confirm password warning message {string}")
	public void user_gets_password_and_confirm_password_warning_message(String message) {
		String psdMessage = accountPage.getPasswordErrorMessage();
		String cnfrmPsdMsg = accountPage.getconfirmPasswordErrorMessage();
		if(psdMessage.equals(message) && cnfrmPsdMsg.equals(message)) {
			logger.trace("Password warning message is visible");			
		}else {
			logger.warn("Warning message not found");
		}
	}
}
