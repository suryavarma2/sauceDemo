package com.saucedemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart extends BasePage{

	public Cart(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@id='inventory_container']/div/div[1]/div[3]/button")
	public WebElement addtocart;
	@FindBy(xpath = "//*[@id='shopping_cart_container']/a")
	public WebElement cart;
	
	public void clickonAddcart()
	{
		this.addtocart.click();	
		//open login page
	}
	public void clickonCart()
	{
		this.cart.click();	
		
	}
	

		
	}

