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


public class SearchProductPage {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	HighlightElementClass highlightElement = new HighlightElementClass();
	JavascriptExecutor executor;

	
	@FindBy(xpath = "//span[contains(@class,'base')]")
	WebElement searchResultElement;
	
	@FindBy(xpath = "(//li[contains(@class,'product-item')])[1]")
	WebElement searchedProduct;
	
	@FindBy(xpath = "(//li[contains(@class,'product-item')]//a[contains(@class,'product-item-link')])[1]")
	WebElement searchedProductName;
	
	@FindBy(xpath = "(//li[contains(@class,'product-item')]//div[contains(text(),'L')])[1]")
	WebElement productLSize;
	
	@FindBy(xpath = "(//li[contains(@class,'product-item')]//div[contains(@id,'option-label-color-93-item-56')])[1]")
	WebElement productColor;
	
	@FindBy(xpath = "(//li[contains(@class,'product-item')]//button)[1]")
	WebElement addToCartButton;

	@FindBy(xpath = "//div[contains(@role,'alert')]")
	WebElement addToCartSuccesMessage;

	@FindBy(xpath = "//span[contains(@class,'counter-number')]")
	WebElement cartCount;
	
	@FindBy(xpath = "//a[contains(@class,'showcart')]")
	WebElement cartButton;

	@FindBy(xpath = "//button[contains(@id,'top-cart-btn-checkout')]")
	WebElement checkOutButton;
	
	//Constructor
	public SearchProductPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.actions = new Actions(driver);
		this.executor = (JavascriptExecutor) driver;
		
		PageFactory.initElements(driver, this);
	}

	//check search value present in search heading
	public boolean searchValuePresent(String search) {
		highlightElement.highlightElement(driver, searchResultElement);
		return searchResultElement.getText().contains(search);
	}

	//move to searched product element
	public void getSearchedProduct() {
		executor.executeScript("arguments[0].scrollIntoView();", searchedProduct);
		wait.until(d -> searchedProduct.isDisplayed());
		highlightElement.highlightElement(driver, searchedProduct);
		actions.moveToElement(searchedProduct).build().perform();
		actions.moveToElement(searchedProduct).build().perform();		
		actions.moveToElement(searchedProduct).build().perform();
	}

	//check product name is same as search entry
	public boolean searchedProductPresent(String search) {
		highlightElement.highlightElement(driver, searchedProductName);
		System.out.println(searchedProductName.getText());
		return searchedProductName.getText().contains(search);
	}

	//click on product name
	public void clickProductLink() {
		highlightElement.highlightElement(driver, searchedProductName);
		searchedProductName.click();
	}
	
	//Select L size for product
	public void selectLSize() {
		highlightElement.highlightElement(driver, productLSize);
		productLSize.click();
	}
	
	//Select product color
	public void selectProductColor() {
		highlightElement.highlightElement(driver, productColor);
		productColor.click();
	}
	
	//click add to cart button
	public void clickAddToCartButton() {
		highlightElement.highlightElement(driver, addToCartButton);
		addToCartButton.click();
	}
	
	//check alert message if product is successfully added to cart 
	public boolean isProductAddedToCartAlertPresent() {
		executor.executeScript("arguments[0].scrollIntoView();", addToCartSuccesMessage);		
		highlightElement.highlightElement(driver, addToCartSuccesMessage);
		return addToCartSuccesMessage.isDisplayed();
	}
	
	//check cart count is updated 
	public boolean iscartCountUpdated() {
		executor.executeScript("arguments[0].scrollIntoView();", cartButton);		
		highlightElement.highlightElement(driver, cartButton);
		return cartCount.isDisplayed();
	}
	
	//click cart button
	public void clickCartButton() {
		cartButton.click();
	}
	
	//click proceed to checkout button
	public void clickCheckOutButton() {
		wait.until(ExpectedConditions.elementToBeClickable(checkOutButton));
		highlightElement.highlightElement(driver, checkOutButton);
		checkOutButton.click();
//		checkOutButton.click();
	}
	
}
