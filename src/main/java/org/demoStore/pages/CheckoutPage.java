package org.demoStore.pages;

import org.demoStore.utilities.HighlightElementClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckoutPage {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	HighlightElementClass highlightElement = new HighlightElementClass();
	JavascriptExecutor executor;

	
	@FindBy(xpath = "(//div[contains(@class,'step-title')])[1]")
	WebElement shippingAddressText;
	
	@FindBy(xpath = "//div[contains(@class,'selected-item')]")
	WebElement shippingAddress;
	
	@FindBy(xpath = "//div[contains(@class,'opc-block-summary')]")
	WebElement orderSummary;
	
	@FindBy(xpath = "//div[contains(@class,'opc-block-summary')]//div[contains(@class,'title')]")
	WebElement orderListButton;
	
	@FindBy(xpath = "//div[contains(@class,'opc-block-summary')]//li[contains(@class,'product-item')]")
	WebElement productDetails;
	
	@FindBy(xpath = "//div[contains(@class,'opc-block-summary')]//div[contains(@class,'options')]")
	WebElement viewDetailsButton;
	
	@FindBy(xpath = "//span[contains(text(),'$5.00')]")
	WebElement flatRateButton;
	
	@FindBy(xpath = "//button[contains(@class,'continue')]")
	WebElement nextButton;
	
	@FindBy(className = "checkout-billing-address")
	WebElement billingAddress;
	
	@FindBy(name ="billing-address-same-as-shipping")
	WebElement billingAddressCheckBox;
	
	@FindBy(xpath ="//button[contains(@class,'checkout')]")
	WebElement placeOrderButton;
	
	//Constructor
	public CheckoutPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.actions = new Actions(driver);
		this.executor = (JavascriptExecutor) driver;

		PageFactory.initElements(driver, this);
	}
	
	
	//wait until shipping address text is displayed
	public void waitUntilShippingAddressVisible() {
		wait.until(d -> shippingAddressText.isDisplayed());
		highlightElement.highlightElement(driver, shippingAddressText);
	}
	
	//check shipping address is displayed
	public boolean isShippingAddressDisplayed() {
		wait.until(d -> shippingAddress.isDisplayed());		
		highlightElement.highlightElement(driver, shippingAddress);
		return shippingAddress.isDisplayed();
	}

	//click to check orders
	public void clickToSeeOrders() {
		executor.executeScript("window.scrollBy(0,100);");
		wait.until(ExpectedConditions.visibilityOf(orderListButton));
		wait.until(ExpectedConditions.elementToBeClickable(orderListButton));
		highlightElement.highlightElement(driver, orderSummary);
		highlightElement.highlightElement(driver, orderListButton);
		orderListButton.click();
		executor.executeScript("window.scrollBy(0,50);");
		wait.until(ExpectedConditions.elementToBeClickable(viewDetailsButton));
		viewDetailsButton.click();
		highlightElement.highlightElement(driver, productDetails);
	}
	
	//select shipping method rates
	public void selectShippingRate() {
		executor.executeScript("window.scrollBy(0,100);");
		wait.until(d -> flatRateButton.isDisplayed());
		highlightElement.highlightElement(driver, flatRateButton);
		flatRateButton.click();
	}

	
	//click to check orders
	public void clickNextButton() {
		executor.executeScript("window.scrollBy(0,100);");
		wait.until(d -> nextButton.isDisplayed());
		highlightElement.highlightElement(driver, nextButton);
		nextButton.click();
	}
	
	
	//check billing address is selected
	public boolean isBillingAddressSelected() {
		wait.until(d -> billingAddress.isDisplayed());		
		highlightElement.highlightElement(driver, billingAddress);
		return billingAddressCheckBox.isSelected();
	}
	
	//click to place orders
	public void clickPlaceOrderButton() {
		executor.executeScript("arguments[0].scrollIntoView();", placeOrderButton);
		wait.until(ExpectedConditions.visibilityOf(placeOrderButton));
		wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
		highlightElement.highlightElement(driver, placeOrderButton);
		placeOrderButton.click();
	}
	
}

