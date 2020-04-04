package org.guru99.eCommerce.MobileSorting;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyCostOfProduct {
	
	WebDriver driver;
	
	public VerifyCostOfProduct(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	
	
	public HashMap<String,String> verifyxperiacostlistpage()
     {
     	 
		//driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();
		HelperMethod helpermethod1 = new HelperMethod(driver);
		helpermethod1.productchoice("Mobile");
		 HashMap<String, String> objMap = new HashMap<String, String>();
		    objMap.put(driver.findElement(By.xpath("//a[@title='Sony Xperia']")).getText(), driver.findElement(By.xpath("//div[@class='price-box']//span[@id='product-price-1']/span")).getText());
		    driver.findElement(By.xpath("//a[@title='Sony Xperia']")).click();

		return objMap;
		    
	 }
	 
	 
	 
	 public HashMap<String, String> verifyxperiacostdetailpage()
	 {
		
		 
		 HashMap<String, String> objMap1 = new HashMap<String, String>();
		    objMap1.put(driver.findElement(By.xpath("//span[text()='Sony Xperia']")).getText(), driver.findElement(By.xpath("//div[@class='product-shop']//span[@class='price']")).getText());
		 
		return objMap1;
		    
	 }

	



}
