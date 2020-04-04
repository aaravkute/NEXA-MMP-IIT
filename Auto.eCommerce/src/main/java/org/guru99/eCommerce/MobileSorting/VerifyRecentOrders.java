package org.guru99.eCommerce.MobileSorting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyRecentOrders {
	
	/*
	 * STEP1. GOTO LINK HTTP://LIVE.GURU99.COM/
	 * STEP2. CLICK ON MY ACCOUNT LINK
	 * STEP3. LOGIN INI AAPLICATION USING PRECIOUSLY CREAED CREDITANLS
	 * STEP4. CLICK ON 'MY ORDERS'
	 * STEP5. CLICK ON VIEW ORDERS
	 * STEP6. VERIFY THE PREVIOUSLY CREATED ORDERS IS DISPLAYED IN 'RECENT ORDER TABLE AND STATUS IS PENDING 
	 * STEP7. CLICK ON 'PRINT ORDER' LINK
	 * STEP8. VERIFY ORDER IS SAVED AS PDF.
	 */

	WebDriver driver;
	
	public VerifyRecentOrders(WebDriver driver) 
	{
		this.driver = driver;
	}

	
	public String ViewRecentOrders()
	{
		String actual = driver.findElement(By.xpath("//tr[@class='first odd']//em[contains(text(),'Pending')]")).getText();
		System.out.println("actual oreders pending"+actual);
		
		driver.findElement(By.xpath("//tr[@class='first odd']//a[contains(text(),'View Order')]")).click();
		driver.findElement(By.xpath("//a[@class='link-print']")).click();
		return actual;
	}
	
	

}
