package com.saucedemo.pageobjects;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home extends BasePage{

	public Home(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = "//*[@id='user-name']")
	 WebElement UserName;
	
	@FindBy(xpath="//*[@id='password']")
	 WebElement Password;
	
	
	@FindBy(id="login-button")
	WebElement LoginButton;
	
	
	
	public void EnterUserName(String Name) {
		this.UserName.click();
		this.UserName.sendKeys(Name);
	}
	


	public void Enterpassword(String pass) {
		this.Password.click();
		this.Password.sendKeys(pass);
	}

	
	public void clickLoginButton() {
		this.LoginButton.click();
	}
	

}
