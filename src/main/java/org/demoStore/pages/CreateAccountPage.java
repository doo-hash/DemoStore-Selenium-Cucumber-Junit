package org.demoStore.pages;

import org.demoStore.utilities.HighlightElementClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateAccountPage {

	WebDriver driver;
	HighlightElementClass highlightElementClass = new HighlightElementClass();

	@FindBy(id = "firstname") WebElement firstNameInput;
	@FindBy(id = "lastname") WebElement lastNameInput;
	@FindBy(name = "email") WebElement emailInput;
	
	@FindBy(xpath = "//div[contains(@class,'password')]//input[contains(@id,'password')]") 
	WebElement passwordInput;

	@FindBy(name = "password_confirmation")
	WebElement confirmPasswordInput;

	@FindBy(className = "submit")
	WebElement createAccountButton;
	
	@FindBy(xpath = "//div[contains(@role,'alert')]")
	WebElement accountFailMessage;

	@FindBy(id = "firstname-error") 
	WebElement firstnameError;
	
	@FindBy(id = "lastname-error") 
	WebElement lastnameError;
	
	@FindBy(id = "email_address-error") 
	WebElement emailError;
	
	@FindBy(id = "password-error") 
	WebElement passwordError;

	@FindBy(id = "password-confirmation-error") 
	WebElement confirmPasswordError;

	@FindBy(xpath = "//div[contains(@class,'page')]//div[contains(@class,'messages')]") 
	WebElement errorMessage;
	
	//constructor
	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//check url
	public boolean isUrl() {
		return driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/customer/account/create/");
	}
	
	//set firstname input value
	public void setFirstNameInput(String firstName) {
		highlightElementClass.highlightElement(driver, firstNameInput);
		firstNameInput.sendKeys(firstName);
	}

	//set lastname input value
	public void setLastNameInput(String lastName) {
		highlightElementClass.highlightElement(driver, lastNameInput);
		lastNameInput.sendKeys(lastName);
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

	//set password-confirmation input value
	public void setConfirmPasswordInput(String confirmPassword) {
		highlightElementClass.highlightElement(driver, confirmPasswordInput);
		confirmPasswordInput.sendKeys(confirmPassword);
	}
	
	//get firstname input value
	public String getFirstNameInputValue() {
		return firstNameInput.getDomProperty("value");
	}

	//get lastname input value
	public String getLastNameInputValue() {
		return lastNameInput.getDomProperty("value");
	}

	//get email input value
	public String getEmailInputValue() {
		return emailInput.getDomProperty("value");
	}

	//get password input value
	public String getPasswordInputValue() {
		return passwordInput.getDomProperty("value");
	}

	//get password-confirmation input value
	public String getConfirmPasswordInputValue() {
		return confirmPasswordInput.getDomProperty("value");
	}

	//click create account button
	public void clickCreateAccountButton() {
		highlightElementClass.highlightElement(driver, createAccountButton);
		createAccountButton.click();
	}
	
	//check whether element is displayed
	public boolean isMessageElementPresent() {
		return accountFailMessage.isDisplayed();
	}
	
	//return failed account creation message
	public String getCreateAccountFailMessage() {
		highlightElementClass.highlightElement(driver, accountFailMessage);
		String message = accountFailMessage.getText();
		return message;
	}
	
	//return first name error message
	public String getFirstnameErrorMessage() {
		highlightElementClass.highlightElement(driver, firstnameError);
		String message = firstnameError.getText();
		return message;
	}

	//return last name error message
	public String getLastnameErrorMessage() {
		highlightElementClass.highlightElement(driver, lastnameError);
		String message = lastnameError.getText();
		return message;
	}
	
	//return email error message
	public String getEmailErrorMessage() {
		highlightElementClass.highlightElement(driver, emailError);
		String message = emailError.getText();
		return message;
	}
	
	//return password error message
	public String getPasswordErrorMessage() {
		highlightElementClass.highlightElement(driver, passwordError);
		String message = passwordError.getText();
		return message;
	}
	
	//return confirm password error message
	public String getconfirmPasswordErrorMessage() {
		highlightElementClass.highlightElement(driver, confirmPasswordError);
		String message = confirmPasswordError.getText();
		return message;
	}

	//return error message
	public String getErrorMessage() {
		highlightElementClass.highlightElement(driver, errorMessage);
		String message = errorMessage.getText();
		return message;
	}
}

