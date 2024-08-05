package org.demoStore.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.demoStore.pages.CheckoutPage;
import org.demoStore.pages.CreateAccountPage;
import org.demoStore.pages.CustomerPage;
import org.demoStore.pages.HomePage;
import org.demoStore.pages.LoginPage;
import org.demoStore.pages.LogoutSuccessPage;
import org.demoStore.pages.OrderDetailsReceiptPage;
import org.demoStore.pages.OrderSuccessPage;
import org.demoStore.pages.ProductPage;
import org.demoStore.pages.SearchProductPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppUtilities {
	
	public static WebDriver driver; 
	public static WebDriverWait wait;

	public static Logger logger = LogManager.getLogger("DemoStoreJunit");
	public static ReadConfig config = new ReadConfig();
		
	public static HomePage homePage;
	public static LoginPage loginPage;
	public static CreateAccountPage accountPage;
	public static CustomerPage customerPage;
	public static SearchProductPage searchProductPage;
	public static ProductPage productPage;
	public static LogoutSuccessPage logoutSuccessPage;
	public static CheckoutPage checkoutPage;
	public static OrderDetailsReceiptPage orderDetailsReceiptPage;
	public static OrderSuccessPage orderSuccessPage;

	public String getRandomString() {
		return(RandomStringUtils.randomAlphabetic(5));
	}
	
	public void captureScreenshot() throws IOException {
		if(driver!= null) {
			TakesScreenshot screenshot = ((TakesScreenshot)driver);
			
			File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
			
			File destFile = new File(System.getProperty("user.dir") + "//Screenshots//test.png");
			
			FileUtils.copyFile(srcFile, destFile);
			logger.info("screenshot captured");
		}
	}
	
	public void captureScreenshot(String name) throws IOException {
		if(driver!= null) {
			TakesScreenshot screenshot = ((TakesScreenshot)driver);
			
			File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
			
			File destFile = new File(System.getProperty("user.dir") + "//Screenshots//"+name+".png");
			
			FileUtils.copyFile(srcFile, destFile);
			logger.info("screenshot captured");
		}
	}

}
