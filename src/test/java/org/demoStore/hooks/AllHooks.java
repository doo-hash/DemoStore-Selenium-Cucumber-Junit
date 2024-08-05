package org.demoStore.hooks;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.demoStore.utilities.AppUtilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class AllHooks extends AppUtilities {
	
	@Before(order = 0)
	public void driverSetup() {
		String browser = config.getBrowserName();
		ArrayList<String> options = new ArrayList<String>();
		options.add("start-maximized");
		options.add("--headless=new");

		switch (browser.toLowerCase()) {
			case "msedge":
				EdgeOptions edgeOptions = new EdgeOptions();
				edgeOptions.addArguments(options);
				driver = new EdgeDriver(edgeOptions);
				break;
			case "chrome": 
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments(options);
				driver = new ChromeDriver(chromeOptions);
				break;
			case "firefox": 
				driver = new FirefoxDriver();
				break;
			default:
				driver = null;
				break;
		}
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		logger.info("Scenario execution started");
	}
	

	@Before(order = 1)
	public void urlSetup() {
		driver.get(config.getBaseURL());
		logger.info("Opens the application");
	}
	
	@AfterStep
	public void stepScreenshot(Scenario scenario) throws IOException {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot,"image/png", scenario.getName());

		logger.info("Captured screenshot for step: " + scenario.getName());
	}
	
	@After(order = 1)
	public void closeWindow(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			captureScreenshot();
			logger.debug("Captured screenshot for failed scenario: " + scenario.getName());
		}
		
//		logger.info("Closed browser window");
//		driver.close();
	}

	@After(order = 0)
	public void tearDown() {
		if(driver != null) {
			logger.info("Scenario execution over");
			driver.quit();			
		}
	}
	
}
