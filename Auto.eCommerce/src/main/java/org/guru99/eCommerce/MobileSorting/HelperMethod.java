package org.guru99.eCommerce.MobileSorting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperMethod {

	

	WebDriver driver;
	
	public HelperMethod(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	
	public void productchoice(String product)
	{
			driver.findElement(By.xpath("//a[contains(text(),'"+product+"')]")).click();
		
	}
	
	
	
	public void Login(String email, String pwd)
	{
	
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		
	}
	
	public void navigateToSubMenu(String subMenuText)
	{
		// Method-1 Click on Sub menu for Schedule Appointment
		//_blockcontent.click();
		driver.findElement(By.xpath("//div[@class='block-content']//a[contains(text(),'"+subMenuText+"')]")).click();
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
	}

	public void accountlink()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//a[@href='http://live.demoguru99.com/index.php/customer/account/']")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='header-account']/div/ul/li/a[@href='http://live.demoguru99.com/index.php/customer/account/']")))).click();

	}
	
}
