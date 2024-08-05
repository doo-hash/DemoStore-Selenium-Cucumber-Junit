package org.demoStore.stepDefinitions;

import org.demoStore.pages.HomePage;
import org.demoStore.pages.LoginPage;
import org.demoStore.utilities.AppUtilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef extends AppUtilities {

	@Given("user navigates to login page")
	public void user_navigates_to_login_page() {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);

		homePage.clickLoginElement();
		logger.trace("Login URL: " + driver.getCurrentUrl());
		logger.trace("Navigated to login page");
	}

	@When("user enters email {string}")
	public void user_enters_email(String email) {
		loginPage.setEmailInput(email);
		logger.trace("Email entered: " + email);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.setPasswordInput(password);
		logger.trace("Password entered: " + password);
	}

	@When("user clicks login button")
	public void user_clicks_login_button() {
		loginPage.clickLoginButton();
		logger.trace("Clicked login button");
	}

	@Then("user was navigated back to home page")
	public void user_was_navigated_back_to_home_page() {
		String currentUrl = config.getBaseURL();
		if(homePage.isUrl(currentUrl)) {
			logger.trace("Redirected to home page");			
		}else {			
			logger.fatal("Not navigated to home page");
		}
	}

	@Then("user name is visible {string}")
	public void user_name_is_visible(String username) {
		if(homePage.isWelcomeElementPresent()) {
			String message = homePage.getWelcomeMessage();
			if(message.contains(username)) {
				logger.trace("Logged in Username: " + username);			
			}else {
				logger.error("Username not found");			
			}
		}
	}

	@Then("user should get proper warning message")
	public void user_should_get_proper_warning_message() {
		String message = loginPage.getErrorMessage();
		if(message.isEmpty()) {
			logger.trace("Warning message recieved");			
		}else {
			logger.warn("warning message not found");
		}

	}

	@When("user doesnot enters credentials")
	public void user_doesnot_enters_credentials() {
		loginPage.setEmailInput(" ");
		loginPage.setPasswordInput(" ");
		logger.trace("Entered empty credentials");
	}

	@Then("user gets email warning message {string}")
	public void user_gets_email_warning_message(String errMessage) {
		String message = loginPage.getEmailErrorMessage();
		if(message.equals(errMessage)) {
			logger.trace("email warning message: " + errMessage);			
		}else {
			logger.warn("warning message not found");
		}
	}

	@Then("user gets password warning message {string}")
	public void user_gets_password_warning_message(String errMessage) {
		String message = loginPage.getPasswordErrorMessage();
		if(message.equals(errMessage)) {
			logger.trace("password warning message: " + errMessage);
		}else {
			logger.warn("warning message not found");
		}
	}
}
