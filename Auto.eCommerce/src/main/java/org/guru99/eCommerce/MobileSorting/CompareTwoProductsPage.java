package org.guru99.eCommerce.MobileSorting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompareTwoProductsPage {
	
	/* 
	 * 
	 TEST CASE : VERIFY THAT YOU ARE ABLE TO COMPARE TWO PRODUCTS
	 
	  1. GO  TO WEBSITE HTTP://LIVE.DEMOGURU99.COM/
	  2. CLICK ON MOBILE MENU
	  3. IN MOBILE PRODUCT LIST, CLICK ON 'ADD TO COMPARE' FOR 2 MOBILES
	  4. CLICK ON 'COMPARE' BUTTON
	  5. VERIFY THE POP UP WINDOW  AND CHECK THAT THE PRODUCTS ARE REFLECTED IN IT
	  6. CLOSE THE POP UP WINDOWS.
*/

	
	
WebDriver driver;
	
	public CompareTwoProductsPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	
	// creating a function to compare 2 products
	
	public void CompareTwoProducts()
	{

		HelperMethod helpermethod = new HelperMethod(driver);
		helpermethod.productchoice("Mobile");
		
		
   	 JavascriptExecutor js = (JavascriptExecutor) driver;  
     js.executeScript("window.scrollBy(0,300)");	
     System.out.println("page scrolled down");
     
     driver.findElement(By.xpath("	//li[@class='item last']/a[@title='Xperia']/following::div[1]/div[3]/ul/li[2]/a")).click();
     System.out.println("xperia added to compare");
     driver.findElement(By.xpath("	//li[@class='item last']/a[@title='IPhone']/following::div[1]/div[3]/ul/li[2]/a")).click();
     System.out.println("iphone added to compare");
     
  //   JavascriptExecutor js = (JavascriptExecutor) driver;  
     js.executeScript("window.scrollBy(300,0)");
     
     driver.findElement(By.xpath("//button[@title='Compare']")).click();
     System.out.println("clicked compare button");
     
	}
	
	public ArrayList<String> CompareTwoProductsWindow()
	{
		String mainWindow = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		
		
		Iterator<String> itr= set.iterator();
		
		while(itr.hasNext())
		    {
				String childWindow=itr.next();
					if(!mainWindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						String WindowTitle = driver.findElement(By.xpath("//div[@class='page-title title-buttons']")).getText();
						System.out.println(driver.switchTo().window(childWindow).getTitle());
						 ArrayList<String> MobileList = new ArrayList<String>();
						 if (!driver.findElements(By.xpath("//tr[@class='product-shop-row top first odd']/td/h2")).isEmpty())
						 {
							
							 for(WebElement we:driver.findElements(By.xpath("//tr[@class='product-shop-row top first odd']/td/h2")))
							 {
								 MobileList.add(we.getText());
							 }
						 }
						 return MobileList;
					}
		    }
		 driver.switchTo().window(mainWindow);
		return null;
	}
	
//	String StringComparedMobile(String xperia, String iphone)
	
   


}
