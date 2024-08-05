package org.demoStore.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrintOrderPage {

	WebDriver driver;
	JavascriptExecutor executor;
	
	@FindBy(xpath = "(//button/span[contains(text(),'Print')])[2]")
	WebElement printButton;
	
	@FindBy(xpath = "//button/span[contains(text(),'Cancel')]")
	WebElement cancelButton;
	
	public PrintOrderPage(WebDriver driver) {
		this.driver = driver;
		this.executor = (JavascriptExecutor) driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickPrintButton() {
		printButton.click();
	}
	
	public void clickCancelButton() {
		cancelButton.click();
	}

	public void scrollToBottom() {
		executor.executeScript("window.scrollBy(0,document.body.scrollHeight);");
	}
	
}
