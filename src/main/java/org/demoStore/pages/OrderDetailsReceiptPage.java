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


public class OrderDetailsReceiptPage {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	HighlightElementClass highlightElement = new HighlightElementClass();
	JavascriptExecutor executor;

	@FindBy(xpath = "(//div[contains(@class,'order-date')]/span)[2]")
	WebElement orderDate;
	
	@FindBy(linkText = "Print Order")
	WebElement printOrderLink;
	
	@FindBy(xpath = "//div[contains(@class,'order-details-items ordered')]")
	WebElement orderedItemsBlock;
	
	@FindBy(xpath = "//h1")
	WebElement orderID;
	
	@FindBy(xpath = "//td/strong[contains(@class,'product-item-name')]")
	WebElement productName;

	@FindBy(xpath = "//div[contains(@class,'block block-order-details-view')]")
	WebElement addressBlock;

	@FindBy(xpath = "//button[contains(@class,'switch')]")
	WebElement accountDropdownButton;
	
	@FindBy(xpath = "//div[contains(@class,'customer-menu')]/ul[contains(@class,'header')]")
	WebElement accountDropdown;
	
	@FindBy(linkText = "Sign Out")
	WebElement logout;

	
	//Constructor
	public OrderDetailsReceiptPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.actions = new Actions(driver);
		this.executor = (JavascriptExecutor) driver;
		
		PageFactory.initElements(driver, this);
	}
	
	//get order id
	public String getOrderID() {
		highlightElement.highlightElement(driver, orderID);
		return orderID.getText();
	}
	
	//get product name
	public String getProductName() {
		highlightElement.highlightElement(driver, productName);
		return productName.getText();
	}

	//scroll down to ordered items
	public void scrollDownToOrederedItems() {
		executor.executeScript("arguments[0].scrollIntoView();", orderedItemsBlock);
	}
	
	
	//scroll down to order information(it includes shipping and billing address)
	public void scrollDownToOrederInfo() {
		executor.executeScript("arguments[0].scrollIntoView();", addressBlock);
	}
	

	//get order date
	public String getOrderDate() {
		highlightElement.highlightElement(driver, orderDate);
		return orderDate.getText();
	}
	
	
	//click print order link
	public void clickPrintOrder() {
		executor.executeScript("arguments[0].scrollIntoView();", printOrderLink);
		wait.until(ExpectedConditions.visibilityOf(printOrderLink));
		highlightElement.highlightElement(driver, printOrderLink);
		printOrderLink.click();
	}
	
	//click account dropdown button
	public void clickAccountDropdown() {
		accountDropdownButton.click();
	}
	
	//check whether account dropdown is displayed
	public boolean isDropdownVisible() {
		return accountDropdown.isDisplayed();
	}
	
	//logout
	public void clickLogoutLink() {
		highlightElement.highlightElement(driver, logout);
		logout.click();
	}
}
