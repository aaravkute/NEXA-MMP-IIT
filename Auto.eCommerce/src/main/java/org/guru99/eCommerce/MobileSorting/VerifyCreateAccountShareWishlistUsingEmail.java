package org.guru99.eCommerce.MobileSorting;

import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyCreateAccountShareWishlistUsingEmail
{

	WebDriver driver;
	Random rnd = new Random();
	HashMap<String, String> hMap = new HashMap<String, String>();

	public VerifyCreateAccountShareWishlistUsingEmail(WebDriver driver) 
	{
		this.driver = driver;
	}

	
	
	public void accountlink()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//a[@href='http://live.demoguru99.com/index.php/customer/account/']")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='header-account']/div/ul/li/a[@href='http://live.demoguru99.com/index.php/customer/account/']")))).click();

	}
	
	
	public HashMap<String,String> registerCustomer(String email, String password) 
	{
		if(driver.findElement(By.xpath("//a[@title='Create an Account']")).isEnabled())
		{
			 JavascriptExecutor js = (JavascriptExecutor) driver;  
			 js.executeScript("window.scrollBy(0,100)");
			 driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
			
			WebElement firstnameTxtField = driver.findElement(By.id("firstname"));
			String fNameValue = "testFN" + (char) (65+rnd.nextInt(26));
			firstnameTxtField.sendKeys(fNameValue);
			hMap.put("firstname", firstnameTxtField.getAttribute("value"));
			
			WebElement middlenameTxtField = driver.findElement(By.id("middlename"));
			String mNameValue = "testLN" + (char) (65+rnd.nextInt(26));
			middlenameTxtField.sendKeys(mNameValue);
			hMap.put("middlename", middlenameTxtField.getAttribute("value"));
			
			WebElement lastnameTxtField = driver.findElement(By.id("lastname"));
			String lNameValue = "testLN" + (char) (65+rnd.nextInt(26));
			lastnameTxtField.sendKeys(lNameValue);
			hMap.put("lastname", lastnameTxtField.getAttribute("value"));
			
			WebElement emailTxtField = driver.findElement(By.id("email_address"));
		//	String emailValue = "testEmail" + rnd.nextInt(90)+ (char) (65+rnd.nextInt(26))+ "@gmail.com";
			emailTxtField.sendKeys(email);
			hMap.put("email_address", emailTxtField	.getAttribute("value"));
						
			WebElement passwordTxtField = driver.findElement(By.id("password"));
		//	String passwordValue = "testLN" + (char) (65+rnd.nextInt(26));
			passwordTxtField.sendKeys(password);
			hMap.put("password", passwordTxtField.getAttribute("value"));
			
			WebElement confirmpasswordTxtField = driver.findElement(By.id("confirmation"));
			confirmpasswordTxtField.sendKeys(password);
			hMap.put("confirmation", confirmpasswordTxtField.getAttribute("value"));
			
			
			driver.findElement(By.xpath("//button[@title='Register']")).click();

			
		}
		return hMap;
		
	}
	
	public String sharewishlist()
	{
		HelperMethod helpermethod = new HelperMethod(driver);
		helpermethod.productchoice("TV");
		
			driver.findElement(By.xpath("//a[@title='LG LCD']/ancestor::li/div/descendant::div/descendant::ul/li/a[@class='link-wishlist']")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Share Wishlist')]")).click();
			driver.findElement(By.xpath("//textarea[@id='email_address']")).sendKeys("hemangikute@gmail.com");
			driver.findElement(By.xpath("//div[@class='buttons-set form-buttons']//button[@class='button']")).click();
			
	

		
		return null;
}
}
