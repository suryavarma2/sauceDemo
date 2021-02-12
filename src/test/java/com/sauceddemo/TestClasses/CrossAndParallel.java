package com.sauceddemo.TestClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.logging.*;

import com.saucedemo.FileHandling.PropertyManager;

public class CrossAndParallel {
	
	WebDriver driver;

	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{
		//Check if parameter passed from TestNG is 'firefox'
		 Logger logger = Logger.getLogger(CrossAndParallel.class.getName()); 
		
		if(browser.equalsIgnoreCase("chrome")){
		
			System.setProperty("webdriver.chrome.driver", PropertyManager.getProperty("path.driver.chrome"));	
			driver = new ChromeDriver();
			
	      logger.info("chrome initiated");
		}
		
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("firefox")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.gecko.driver", PropertyManager.getProperty("path.driver.gecko"));
			
			driver = new FirefoxDriver();
		}
		
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testCheck() throws IOException {
		driver.get(PropertyManager.getProperty("url.app"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
}
}
