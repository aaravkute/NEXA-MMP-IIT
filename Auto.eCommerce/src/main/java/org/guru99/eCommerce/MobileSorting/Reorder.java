package org.guru99.eCommerce.MobileSorting;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

	/*  Verify you are able to change or reorder previously added product
	 *  Test Data = QTY = 10
	Test Steps:
	1. Go to http://live.demoguru99.com/
	2. Click on my account link
	3. Login in application using previously created credential
	4. Click on 'REORDER' link , change QTY & click Update
	5. Verify Grand Total is changed
	6. Complete Billing & Shipping Information
	7. Verify order is generated and note the order number
	
	Expected outcomes:
	1) Grand Total is Changed
	2) Order number is generated
	*/

public class Reorder {
	

	WebDriver driver;
	HashMap<String, String> hmap = new HashMap<String, String>();
	
	public Reorder(WebDriver driver) 
	{
		this.driver = driver;
	}


	public HashMap<String,String> reorder(String Qty)
	{
		
	
driver.findElement(By.xpath("//tr[@class='first odd']//a[@class='link-reorder'][contains(text(),'Reorder')]"))
	.click();
	String grandtotalbeforeupdate = driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText();
	hmap.put("grandtotalbeforeupdate", grandtotalbeforeupdate);
	System.out.println("pritnitng grandtotal"+grandtotalbeforeupdate
			
			);
		 if(driver.findElement(By.xpath("//tbody/tr[@class='first odd']/td[4]/input[@title='Qty']")).isEnabled())
		    {
		    	driver.findElement(By.xpath("//tbody/tr[@class='first odd']/td[4]/input[@title='Qty']")).click();
		    	driver.findElement(By.xpath("//tbody/tr[@class='first odd']/td[4]/input[@title='Qty']")).clear();
		    	driver.findElement(By.xpath("//tbody/tr[@class='first odd']/td[4]/input[@title='Qty']")).sendKeys(Qty);
		    	System.out.println("quantity"+Qty);
		   	}
		 
  driver.findElement(By.xpath("//td[@class='product-cart-actions']//button[@name='update_cart_action']")).click();

	String grandtotalafterupdate = driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText();
	
	hmap.put("grandtotalafterupdate", grandtotalafterupdate);

	System.out.println("pritnitng grandtotal"+grandtotalafterupdate);
	
return hmap;
}
}
