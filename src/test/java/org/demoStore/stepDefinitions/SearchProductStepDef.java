package org.demoStore.stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.demoStore.pages.HomePage;
import org.demoStore.pages.LoginPage;
import org.demoStore.pages.LogoutSuccessPage;
import org.demoStore.pages.ProductPage;
import org.demoStore.pages.SearchProductPage;
import org.demoStore.utilities.AppUtilities;
import org.openqa.selenium.Keys;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProductStepDef extends AppUtilities {

	@When("user login to the application with {string} and {string}")
	public void user_enters_product_name(String email, String password) {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);

		homePage.clickLoginElement();
		
		logger.info(driver.getCurrentUrl());
		logger.trace("Navigated to login page");

		loginPage.setEmailInput(email);
		loginPage.setPasswordInput(password);
		loginPage.clickLoginButton();
		
		logger.info("Successfull login");
		homePage.isWelcomeElementPresent();
		String message = homePage.getWelcomeMessage();
		logger.trace("Welcome Message: " + message);			
	}
	
	@When("user enters product name {string}")
	public void user_enters_product_name(String product) {
		homePage.setSearchInputData(product + Keys.ENTER);
		logger.trace("Entered product name in search box: "+ product);
	}
	
	@When("user finds searched product {string}")
	public void user_finds_searched_product(String product) {
		searchProductPage = new SearchProductPage(driver, wait);
		boolean status = searchProductPage.searchedProductPresent(product);
		if(status) {
			searchProductPage.getSearchedProduct();
			logger.trace("Searched product - "+ product + " found");
		}else {
			logger.warn("product not found");
		}
	}
	
	@When("user clicks product name link")
	public void user_clicks_product_name_link() {
		searchProductPage.clickProductLink();
		logger.info(driver.getCurrentUrl());
		logger.trace("Clicked product link and was navigated to product page");
	}
	
	@Then("user checks product details")
	public void user_checks_product_details() {
		productPage = new ProductPage(driver);
		String productName = productPage.getProductName();
		logger.trace("Product found : " + productName);
	}

	@Then("user logs out of the application")
	public void user_logs_out_of_the_application() {
		logoutSuccessPage = new LogoutSuccessPage(driver);
		homePage.clickAccountDropdown();
		homePage.clickLogoutLink();
		logger.trace("Clicked logout button");
		wait.until(d -> logoutSuccessPage.isUrl());
		logger.info(driver.getCurrentUrl());
		assertTrue(logoutSuccessPage.isSignoutMessagePresent());			
		logger.info("logout successful");
	}
	
}
