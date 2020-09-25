package com.crossassyst.qa.pages;

import com.crossassyst.qa.base.TestBase;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.eclipse.jetty.util.annotation.Name;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends TestBase{
	JavascriptExecutor jse;
	
	//Page Factory - OR
	@FindBy(xpath="//a[contains(text(), 'Sign in')]")
	WebElement signInBtn;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="passwd")
	WebElement password;
	
	@FindBy(name="SubmitLogin")
	WebElement submitBtn;
	
	@FindBy(xpath="//a[contains(text(), 'Women')]")
	WebElement browseProduct;
	
	@FindBy(xpath="//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img")
	WebElement productDiv;
	
	@FindBy(xpath="//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[2]/span")
	WebElement viewProduct;
	
	@FindBy(className="fancybox-iframe")
	WebElement frameClass;
	
	
	//Initializing the Page objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public void login(String em, String pass){
		signInBtn.click();
		email.sendKeys(em);
		password.sendKeys(pass);
		submitBtn.click();
	}
	
	public void browseProduct(){
		browseProduct.click();
		
		jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,800)");
				
		//Browse product and click on view details
		Actions builder = new Actions(driver);
		Action mouseOverBrowseCourse = builder.moveToElement(productDiv)
				.build();
		mouseOverBrowseCourse.perform();
		viewProduct.click();
		
		//Frame Add to Cart
		driver.switchTo().frame(frameClass);
		WebElement qty = driver.findElement(By.xpath("/html/body/div/div/div[3]/form/div/div[2]/p[1]/a[2]"));
		qty.click();
		WebElement submitFrame = driver.findElement(By.name("Submit"));
		submitFrame.click();
		driver.switchTo().defaultContent();
		//Proceed to checkout
		WebElement checkout = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a")); 
		//WebDriverWait wait = new WebDriverWait(driver, 20); 
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(checkout));
		//element.click();
		//wait.until(ExpectedConditions.visibilityOf(checkout));
		//checkout.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", checkout);
		
		//Summary Check Out
		WebElement proceedCheckout = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]/span"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(proceedCheckout));
		proceedCheckout.click();
		
		//Address Check Out
		WebElement addressCheckout = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button/span"));
		addressCheckout.click();
		
		//Shipping Check Out
		WebElement tsCheckout = driver.findElement(By.id("cgv"));
		tsCheckout.click();
		
		WebElement shippingCheckout = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/p/button/span"));
		shippingCheckout.click();
		
		//Payment Check Out		
		WebElement paymentCheckout = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[1]/div/p/a/span"));
		paymentCheckout.click();
		
		//Confirm Payment		
		WebElement confirmPayment = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button/span"));
		confirmPayment.click();
		
	}
	
}
