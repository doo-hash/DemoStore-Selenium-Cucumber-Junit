package org.demoStore.pages;

import org.demoStore.utilities.HighlightElementClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	WebDriver driver;
	HighlightElementClass highlightElementClass = new HighlightElementClass();

	@FindBy(name = "login[username]") 
	WebElement emailInput;
	
	@FindBy(name = "login[password]") 
	WebElement passwordInput;

	@FindBy(name = "send")
	WebElement loginButton;
	
	@FindBy(id = "email-error") 
	WebElement emailError;
	
	@FindBy(id = "pass-error") 
	WebElement passwordError;
	
	@FindBy(xpath = "//div[contains(@class,'page')]//div[contains(@class,'messages')]") 
	WebElement errorMessage;
	
	//constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//check url
	public boolean isUrl(String url) {
		return driver.getCurrentUrl().equals(url);
	}
	
	//set email input value
	public void setEmailInput(String email) {
		highlightElementClass.highlightElement(driver, emailInput);
		emailInput.sendKeys(email);
	}

	//set password input value
	public void setPasswordInput(String password) {
		highlightElementClass.highlightElement(driver, passwordInput);
		passwordInput.sendKeys(password);
	}
	
	//get email input value
	public String getEmailInputValue() {
		return emailInput.getDomProperty("value");
	}

	//get password input value
	public String getPasswordInputValue() {
		return passwordInput.getDomProperty("value");
	}

	//click login button
	public void clickLoginButton() {
		highlightElementClass.highlightElement(driver, loginButton);
		loginButton.click();
	}
	
	//check email error is present
	public boolean isEmailErrorPresent() {
		return emailError.isDisplayed();
	}
	
	//get email error message
	public String getEmailErrorMessage() {
		highlightElementClass.highlightElement(driver, emailError);
		return emailError.getText();
	}
	
	//check password error is present
	public boolean isPasswordErrorPresent() {
		return passwordError.isDisplayed();
	}
	
	//get password error message
	public String getPasswordErrorMessage() {
		highlightElementClass.highlightElement(driver, passwordError);
		return passwordError.getText();
	}
	
	//check error message is present
	public boolean isErrorMessagePresent() {
		return errorMessage.isDisplayed();
	}

	//get error message
	public String getErrorMessage() {
		highlightElementClass.highlightElement(driver, errorMessage);
		return errorMessage.getText();
	}
}
