package com.crossassyst.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crossassyst.qa.base.TestBase;
import com.crossassyst.qa.pages.RegistrationPage;
import com.crossassyst.qa.pages.LoginPage;

public class RegistrationPageTest extends TestBase{
	LoginPage loginPage;
	RegistrationPage registrationPage;
	
	public RegistrationPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		registrationPage = new RegistrationPage();
	}
	
	@Test(priority=1)
	public void registration(){
		registrationPage.registration(prop.getProperty("email"));
	}
	
	//@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}