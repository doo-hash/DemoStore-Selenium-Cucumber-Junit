package org.demoStore.pages;

import org.demoStore.utilities.HighlightElementClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductPage {

	WebDriver driver;
	Actions actions;
	HighlightElementClass highlightElement = new HighlightElementClass();
	JavascriptExecutor executor;
	
	@FindBy(xpath = "//span[contains(@class,'base')]")
	WebElement productName;
		
	@FindBy(xpath = "(//li[contains(@class,'product-item')]//button)[1]")
	WebElement addToCartButton;
	
	
	//Constructor
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
		this.executor = (JavascriptExecutor) driver;
		
		PageFactory.initElements(driver, this);
	}

	//get Product name from product page
	public String getProductName() {
		highlightElement.highlightElement(driver, productName);
		return productName.getText();
	}
	
	
	public void clickAddToCartButton() {
		highlightElement.highlightElement(driver, addToCartButton);
		addToCartButton.click();
	}
}
