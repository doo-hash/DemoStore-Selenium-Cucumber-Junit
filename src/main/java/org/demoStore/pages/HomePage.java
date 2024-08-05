package org.demoStore.pages;

import org.demoStore.utilities.HighlightElementClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

	private WebDriver driver;
	HighlightElementClass highlightElementClass = new HighlightElementClass();
	
	@FindBy(linkText = "Create an Account")
	WebElement createAccount;
	
	@FindBy(linkText = "Sign In")
	WebElement signInLink;
	
	@FindBy(xpath = "//span[contains(@class,'logged-in') and contains(text(),'Welcome')]")
	WebElement welcomeMessage;
		
	@FindBy(xpath = "//button[contains(@class,'switch')]")
	WebElement accountDropdownButton;

	@FindBy(xpath = "//div[contains(@class,'customer-menu')]/ul[contains(@class,'header')]")
	WebElement accountDropdown;
	
	@FindBy(linkText = "Sign Out")
	WebElement logout;

	@FindBy(id = "search")
	WebElement searchInput;
	
	//constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//check url
	public boolean isUrl(String url) {
		return driver.getCurrentUrl().equals(url);
	}
	
	//click create an account link
	public void clickCreateAccountElement() {
		highlightElementClass.highlightElement(driver, createAccount);
		createAccount.click();;
	}
	
	//click login link
	public void clickLoginElement() {
		highlightElementClass.highlightElement(driver, signInLink);
		signInLink.click();;
	}
	
	//check whether welcome element is displayed
	public boolean isWelcomeElementPresent() {
		return welcomeMessage.isDisplayed();
	}
	
	//get welcome message from page
	public String getWelcomeMessage() {
		highlightElementClass.highlightElement(driver, welcomeMessage);
		return welcomeMessage.getText();
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
		highlightElementClass.highlightElement(driver, logout);
		logout.click();
	}
	
	public void setSearchInputData(String search) {
		highlightElementClass.highlightElement(driver, searchInput);
		searchInput.sendKeys(search);
	}
}
