package com.crossassyst.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crossassyst.qa.base.TestBase;
import com.crossassyst.qa.pages.RegistrationPage;
import com.crossassyst.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	RegistrationPage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginTest(){
		loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test(priority=2)
	public void browseProduct(){
		loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		loginPage.browseProduct();
	}
	
	//@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
