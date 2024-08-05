package org.demoStore.stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.demoStore.pages.CheckoutPage;
import org.demoStore.pages.HomePage;
import org.demoStore.pages.LogoutSuccessPage;
import org.demoStore.pages.OrderDetailsReceiptPage;
import org.demoStore.pages.OrderSuccessPage;
import org.demoStore.pages.SearchProductPage;
import org.demoStore.utilities.AppUtilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BuyProductStepDef extends AppUtilities {
	
	
	@When("user search and find product {string}")
	public void user_search_and_find_product (String product) {
		wait = new WebDriverWait(driver, Duration.ofMillis(1000));
		
		homePage = new HomePage(driver);
		searchProductPage = new SearchProductPage(driver, wait);

		homePage.setSearchInputData(product + Keys.ENTER);
		logger.trace("product name entered in search box: " + product);
		assertTrue(searchProductPage.searchValuePresent(product));

		boolean status = searchProductPage.searchedProductPresent(product);
		if(status) {
			searchProductPage.getSearchedProduct();
			logger.trace("Searched product found: " + product);
		}else {
			logger.warn("product not found");
		}
	}
		
	@When("user selects color and size")
	public void user_selects_color_and_size() {
		searchProductPage.selectLSize();
		searchProductPage.selectProductColor();
		logger.trace("Selected color and Size");
	}
	
	@When("user adds product to cart")
	public void user_adds_product_to_cart() {
		searchProductPage.clickAddToCartButton();
		logger.trace("Clicked add to cart");
		boolean alertStatus = searchProductPage.isProductAddedToCartAlertPresent();
		boolean cartStatus = searchProductPage.iscartCountUpdated();
		if(alertStatus || cartStatus) {
			assertTrue(alertStatus);
			assertTrue(cartStatus);			
			logger.trace("Alert and cart count status is updated");
			searchProductPage.clickCartButton();
			logger.trace("Cart button clicked to proceed checkout");
		}else {
			logger.error("Alert or cart count status is not updated");			
		}
	}

	@Then("user clicks checkout button")
	public void user_clicks_checkout_button() {
		searchProductPage.clickCheckOutButton();
		logger.trace("Checkout button is clicked");
		logger.info(driver.getCurrentUrl());
		wait.until(d -> driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/checkout/"));
		logger.info(driver.getCurrentUrl());
	}
	
	@Then("user verifies address and order details")
	public void user_verifies_address_and_order_details() {
		checkoutPage = new CheckoutPage(driver, wait);
		checkoutPage.waitUntilShippingAddressVisible();
		checkoutPage.isShippingAddressDisplayed();
		checkoutPage.clickToSeeOrders();
		checkoutPage.selectShippingRate();
		checkoutPage.clickNextButton();
		logger.trace("Checked prdouct details and billing address");

		wait.until(d -> driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/checkout/#shipping"));
		logger.info(driver.getCurrentUrl());
		
		boolean addressStatus = checkoutPage.isBillingAddressSelected();
		if(addressStatus) {
			assertTrue(true);
			logger.trace("Selected billing address");
		}else {
			logger.warn("billing address not selected");
		}
	}
	
	@Then("user clicks place order button")
	public void user_clicks_place_order_button() throws InterruptedException {
		Thread.sleep(2000);
		checkoutPage.clickPlaceOrderButton();
		logger.trace("Clicked place order button");
		logger.info(driver.getCurrentUrl());
		wait.until(d -> driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/checkout/#payment"));
		logger.info(driver.getCurrentUrl());
	}
	
	@Then("user checks order receipt {string}")
	public void user_checks_order_receipt(String product) {
		orderSuccessPage = new OrderSuccessPage(driver, wait);
		orderDetailsReceiptPage = new OrderDetailsReceiptPage(driver, wait);

		String orderNumber = orderSuccessPage.getOrderNumber();
		logger.trace("order number is: " + orderNumber);
		orderSuccessPage.clickOrderNumber();
		logger.trace("Clicked order number link");
		wait.until(d -> driver.getCurrentUrl().contains("https://magento.softwaretestingboard.com/sales/order/view/order_id/"));
		logger.info(driver.getCurrentUrl());
		String orderID = orderDetailsReceiptPage.getOrderID();
		if(orderID.contains(orderNumber)) {
			assertTrue(true);
			String productName = orderDetailsReceiptPage.getProductName();
			assertTrue(productName.contains(product));
			orderDetailsReceiptPage.scrollDownToOrederedItems();
			orderDetailsReceiptPage.scrollDownToOrederInfo();
			logger.trace("Checked order details");
		}else {
			logger.fatal("Order number is wrong");
		}

	}
	
	@Then("user signs out of the application")
	public void user_signs_out_of_the_application() {
		logoutSuccessPage = new LogoutSuccessPage(driver);
		orderDetailsReceiptPage.clickAccountDropdown();
		wait.until(d -> orderDetailsReceiptPage.isDropdownVisible());

		orderDetailsReceiptPage.clickLogoutLink();
		logger.trace("Clicked logout button");

		wait.until(d -> logoutSuccessPage.isUrl());
		logger.info(driver.getCurrentUrl());
		assertTrue(logoutSuccessPage.isSignoutMessagePresent());			
		logger.trace("logout successful");
	}

}
