package com.sauceddemo.TestClasses;

import java.io.File;
import java.util.concurrent.TimeUnit;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.saucedemo.FileHandling.PropertyManager;
import com.saucedemo.pageobjects.Cart;
import com.saucedemo.pageobjects.Home;

public class TestAdditem extends BaseTest {
	ExtentTest test;
	

	 
	
	@Test(dataProvider = "signIn")
	public void AddItem(String Name, String pass) throws Exception
	{
		

        // Create a Logger with a null value 
       
       
		
		
		test = extent.createTest("cart", "Add cart");
		driver.get(PropertyManager.getProperty("url.app"));

		test.info("sauceDemo");
		
		
		Home home=new Home(driver);
		
		home.EnterUserName(Name);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		home.Enterpassword(pass);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		home.clickLoginButton();
		

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		Cart cart=new Cart(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		cart.clickonAddcart();

		
		
		
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		cart.clickonCart();

	
		
		
		
		File screenshotFile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(screenshotFile, new File(".//screenshots/screen.png"));



	 
					
	}
	
	



	@DataProvider(name="signIn")			
	public Object[][] getCredentials() {			

		return new Object[][] {				

			{"standard_user","secret_sauce"} 	

		};
	}




}
