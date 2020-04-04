package org.guru99.eCommerce.MobileSorting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout {
	
	/*
	 * TEST CASE : 	VERIFY USER IS ABLE TO PURCHASE PRODUCT USING REGISTRERED EMAIL ID
	 * 1.  GO  TO WEBSITE HTTP://LIVE.DEMOGURU99.COM/
	 * 2. CLICK ON MY ACCOUNT LINK 
	 * 3. LOGIN IN APPLICATION USING CREDENTIALS
	 * 4. CLICK ON MY WISHLIST LINK
	 * 5. IN NEXT PAGE, CLICK ADD TO CART LINK
	 * 6. CLICK PROCCEED TO CHECKOUT.
	 * 7. ENTER SHIPPING INFORMATION
	 * 8. CLICK ESTIMATE
	 * 9. VERIFY SHIPPING COST GENERATED
	 * 10 SELECT SHIPPING COST AND UODATE TOTAL
	 * 11 VERIFY SHIPPING COST IS ADDDED TO TOTAL
	 * 12. CLICK "PROCEED TO CHECKOUT
	 * 13. ENTER BILLING INFORMATION
	 * 14 	IN SHIPPING METHOD , CLIKC OCNTINUE
	 * 15 IN PAYMENT INFORMATION SELECT CHECK MONEY ORDER RADIA BUTTON CLICK OCNTINE 
	 * 16 CLICK PLACE ORFDRE BUTTON 
	 * 17  VERIFY ORDER IS GENERATED. NOTE THE ORDER NO
	 */

	WebDriver driver;
	
	//calling constructor from new created branch from eclipse
	
	public Checkout(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	
	
 
	public void checkout(String street, String city, String pincode, String phoneno)
	{
		driver.findElement(By.xpath("//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@class='button btn-proceed-checkout btn-checkout']//span//span[contains(text(),'Proceed to Checkout')]")).click();
		driver.findElement(By.xpath("//input[@id='billing:street1']")).sendKeys(street);
		driver.findElement(By.xpath("//input[@id='billing:city']")).sendKeys(city);
		new Select(driver.findElement(By.xpath("//select[@id='billing:region_id']"))).selectByVisibleText("Illinois");
		driver.findElement(By.xpath("//input[@id='billing:postcode']")).sendKeys(pincode);
		new Select(driver.findElement(By.xpath("//select[@id='billing:country_id']"))).selectByVisibleText("United States");
		driver.findElement(By.xpath("//input[@id='billing:telephone']")).sendKeys(phoneno);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		 js.executeScript("window.scrollBy(0,100)");
		
		WebDriverWait wait = new WebDriverWait(driver,30);
	//	 js.executeScript("window.scrollBy(0,100)");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='billing-buttons-container']//button[@class='button']")))).click();
		
		//WebDriverWait wait = new WebDriverWait(driver,30);
		 js.executeScript("window.scrollBy(0,100)");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']//button[@class='button']")))).click();
		
	     if(driver.findElement(By.xpath("	//label[contains(text(),'Check / Money order')]")).isEnabled())
	     {
	    	 driver.findElement(By.xpath("	//label[contains(text(),'Check / Money order')]")).click();
	     }
	     js.executeScript("window.scrollBy(0,100)");
	     wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='payment-buttons-container']//button[@class='button']")))).click();
			
	     js.executeScript("window.scrollBy(0,100)");	
	     WebElement placeorder  = driver.findElement(By.xpath("//button[@class='button btn-checkout']"));
	     wait.until(ExpectedConditions.elementToBeClickable(placeorder)).click();

	}
	


	
	
	
}
