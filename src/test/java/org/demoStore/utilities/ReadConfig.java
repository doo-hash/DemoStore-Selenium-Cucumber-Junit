package org.demoStore.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	String configFilePath = System.getProperty("user.dir") + "/src/test/resources/configuration/config.properties";
	
	//constructor
	public ReadConfig() {
		try {
			//reading properties from config.properties file
			properties = new Properties();
			FileInputStream inputStream = new FileInputStream(configFilePath);
			properties.load(inputStream);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	//get baseURL from properties
	public String getBaseURL() {
		String url = properties.getProperty("baseURL");
		if(url != null)
			return url;
		else
			throw new RuntimeException("baseURL not specified in config file;");
	}

	//get browserName from properties
	public String getBrowserName() {
		String browserName = properties.getProperty("browserName");
		if(browserName != null)
			return browserName;
		else
			throw new RuntimeException("browserName not specified in config file;");
	}
	
}
