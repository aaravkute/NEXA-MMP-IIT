package org.guru99.eCommerce.MobileSorting;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyDiscountCoupanWorks {
	
	/*
	 *  1. Go to http://live.demoguru99.com/
		2. Go to Mobile and add IPHONE to cart
		3. Enter Coupon Code
		4. Verify the discount generated

	 */
	
	
	
	WebDriver driver;
	
	 HashMap<String, String> hMap = new HashMap<String, String>();

	
	public VerifyDiscountCoupanWorks(WebDriver driver)
	{
		this.driver = driver;
		
	}

	public HashMap<String,String> discountCoupan()
	{
		driver.findElement(By.xpath("ul[@class='products-grid products-grid--max-4-col first last odd']/li[2]/descendant::div[@class='actions']/button")).click();
		driver.findElement(By.id("coupon_code")).sendKeys("GURU50");
		driver.findElement(By.xpath("//span[contains(text(),'Apply')]")).click();
		
		hMap.put("Discount", driver.findElement(By.xpath("//table[@id='shopping-cart-totals-table']/tbody/tr[2]/td[2]/span")).getText());
		hMap.put("SubTotal",driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tbody/tr[1]/td[2]/span")).getText());
			
	return hMap;
	}
	
	
}
