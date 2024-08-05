package org.demoStore.pages;

import org.demoStore.utilities.HighlightElementClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CustomerPage {

	WebDriver driver;
	HighlightElementClass highlightElementClass = new HighlightElementClass();

	@FindBy(xpath = "//div[contains(@role,'alert')]")
	WebElement accountSuccesMessage;

	@FindBy(xpath = "//span[contains(@class,'logged-in')]")
	WebElement welcomeMessage;
	
	@FindBy(xpath = "//div[contains(@class,'box-content')]/p")
	WebElement contactInformation;
	
	@FindBy(xpath = "//span/button")
	WebElement accountDropdownButton;
	
	@FindBy(xpath = "//div[contains(@class,'customer-menu')]/ul[contains(@class,'header')]")
	WebElement accountDropdown;
	
	@FindBy(linkText = "Sign Out")
	WebElement logout;
	
	
	//constructor
	public CustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//check whether element is displayed
	public boolean isMessageElementPresent() {
		return accountSuccesMessage.isDisplayed();
	}
	
	//return successful account creation message
	public String getCreateAccountSuccessMessage() {
		highlightElementClass.highlightElement(driver, accountSuccesMessage);
		String message = accountSuccesMessage.getText();
		return message;
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
	
	//check whether contact element is displayed
	public boolean iscontactElementPresent() {
		return contactInformation.isDisplayed();
	}
	
	//get contact info from page
	public String getContactInfo() {
		highlightElementClass.highlightElement(driver, contactInformation);
		return contactInformation.getText();
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
}
