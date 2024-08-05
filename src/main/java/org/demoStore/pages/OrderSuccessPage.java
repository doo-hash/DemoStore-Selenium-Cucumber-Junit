package org.demoStore.pages;

import org.demoStore.utilities.HighlightElementClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OrderSuccessPage {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	HighlightElementClass highlightElement = new HighlightElementClass();
	
		
	@FindBy(xpath = "//a[contains(@class,'order-number')]")
	WebElement orderNumberLink;
	
	public OrderSuccessPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.actions = new Actions(driver);

		PageFactory.initElements(driver, this);
		
	}

	// get order number
	public String getOrderNumber() {
		highlightElement.highlightElement(driver, orderNumberLink);
		return orderNumberLink.getText();
	}
	
	//click ordernumber Link
	public void clickOrderNumber() {
		orderNumberLink.click();
	}
}
