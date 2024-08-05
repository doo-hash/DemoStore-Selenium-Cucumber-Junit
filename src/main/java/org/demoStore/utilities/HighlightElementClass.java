package org.demoStore.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighlightElementClass {

	public HighlightElementClass() {
		
	}
	
	public void highlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid yellow;')", element);
	}
}
