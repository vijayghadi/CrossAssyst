package com.crossassyst.qa.pages;

import com.crossassyst.qa.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends TestBase{
	
	//Page Factory - OR
	@FindBy(xpath="//a[contains(text(), 'Sign in')]")
	WebElement signInBtn;
	
	@FindBy(name="email_create")
	WebElement emailCreateBtn;
	
	@FindBy(xpath="//*[@id='SubmitCreate']/span")
	WebElement createAccBtn;
	
	@FindBy(xpath="//*[@id='uniform-id_gender1']")
	WebElement radioBtn1;
	
	@FindBy(id="customer_firstname")
	WebElement custFirstName;
	
	@FindBy(id="customer_lastname")
	WebElement custLastName;
	
	@FindBy(id="passwd")
	WebElement passwd;
	
	@FindBy(name="days")
	WebElement day;
	
	@FindBy(name="months")
	WebElement month;
	
	@FindBy(name="years")
	WebElement year;
	
	@FindBy(id="company")
	WebElement company;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(name="id_state")
	WebElement state;
	
	@FindBy(id="postcode")
	WebElement zip;
	
	@FindBy(id="phone_mobile")
	WebElement mobile;
	
	@FindBy(id="alias")
	WebElement alias;
	
	@FindBy(xpath="//*[@id='submitAccount']/span")
	WebElement submitBtn;
	
	//Initializing the Page objects:
	public RegistrationPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void registration (String email){
		signInBtn.click();
		emailCreateBtn.sendKeys(email);
		createAccBtn.click();
		
		radioBtn1.click();
		custFirstName.sendKeys(prop.getProperty("firstname"));
		custLastName.sendKeys(prop.getProperty("lastname"));
		passwd.sendKeys(prop.getProperty("password"));
		
		Select bday = new Select(day);
		bday.selectByValue(prop.getProperty("bday"));
		
		Select bmonth = new Select(month);
		bmonth.selectByValue(prop.getProperty("bmonth"));
		
		Select byear = new Select(year);
		byear.selectByValue(prop.getProperty("byear"));
		
		company.sendKeys(prop.getProperty("company"));
		address1.sendKeys(prop.getProperty("address1"));
		city.sendKeys(prop.getProperty("city"));
		
		Select states = new Select(state);
		states.selectByVisibleText(prop.getProperty("state"));
		
		zip.sendKeys(prop.getProperty("zip"));
		mobile.sendKeys(prop.getProperty("mobile"));
		alias.sendKeys(prop.getProperty("address2"));
		
		submitBtn.click();
	}

}
