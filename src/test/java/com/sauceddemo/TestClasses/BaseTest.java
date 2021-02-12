package com.sauceddemo.TestClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.saucedemo.FileHandling.PropertyManager;

public class BaseTest {

	protected WebDriver driver;
	public static ExtentReports extent;
	@BeforeSuite
	public void Setup() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	
	@BeforeClass
	public void SetupTest() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", PropertyManager.getProperty("path.driver.chrome"));
		driver = new ChromeDriver();
		  driver.get(PropertyManager.getProperty("url.app"));
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
	@AfterSuite
	public void tearDownflush()
	{
		extent.flush();

	}


}
