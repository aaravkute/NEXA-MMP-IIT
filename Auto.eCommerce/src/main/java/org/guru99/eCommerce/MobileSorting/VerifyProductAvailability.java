package org.guru99.eCommerce.MobileSorting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class VerifyProductAvailability {
	
	/* 
	 TEST CASE : VERIFY THAT YOU CAN NOT ADD MORE PRODUCT IN A CART THAN THE PRODUCT AVAILABLE IN STORE
  1. GO  TO WEBSITE HTTP://LIVE.DEMOGURU99.COM/
  2. CLICK ON MOBILE MENU
  3. IN THE LIST OF ALL MOBILE, CLICK ON 'ADD TO CART' FOR SONY EXPERIA
  4. CHANGE 'QTY' VALUE TO 1000 AND CLICK THE 'UPDATE BUTTON
  5. VERIFY THE ERROR MESSAGE
  6. THEN CLICK ON 'EMPTY CART' LINK IN THE FOOTER OF LIST OF ALL MOBILES.
  7. VERIFY CART IN EMPTY.
 
*/
	WebDriver driver;
	
	public VerifyProductAvailability(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	
	
	public String ProductAvailability(String Qty) throws Exception
	{
		HelperMethod helpermethod = new HelperMethod(driver);
		helpermethod.productchoice("Mobile");
	    
	    if (driver.findElement(By.xpath("//li[1]//div[1]//div[3]//button[1]//span[1]//span[1]")).isEnabled())
		 {
			
	    	driver.findElement(By.xpath("//li[1]//div[1]//div[3]//button[1]//span[1]//span[1]")).click();
	    	System.out.println("Add to Cart clicked");
		 }
		
	    if(driver.findElement(By.xpath("//tr[@class='first last odd']/td[@class='product-cart-actions']/input[@title='Qty']")).isEnabled())
	    {
	    	driver.findElement(By.xpath("//tr[@class='first last odd']/td[@class='product-cart-actions']/input[@title='Qty']")).click();
	    	driver.findElement(By.xpath("//tr[@class='first last odd']/td[@class='product-cart-actions']/input[@title='Qty']")).clear();
	    	driver.findElement(By.xpath("//tr[@class='first last odd']/td[@class='product-cart-actions']/input[@title='Qty']")).sendKeys(Qty);
	    	System.out.println("quantity"+Qty);
	    	    	
	    }
	    
	    driver.findElement(By.xpath("//td[@class='product-cart-actions']//button[@name='update_cart_action']")).click();
	    String ErrorMsg = driver.findElement(By.xpath("	//ul[@class='messages']/li/ul/li/span")).getText();
	    System.out.println("actual Error Message"+ErrorMsg);
	 
	    JavascriptExecutor js = (JavascriptExecutor) driver;  
	    js.executeScript("window.scrollBy(0,500)");

	 //   _popup.click();
		return ErrorMsg;

	}
	    
	    public String CartCount()
	    {

	    if(driver.findElement(By.xpath("//span[contains(text(),'Empty Cart')]")).isEnabled())
	    {
	    	driver.findElement(By.xpath("//span[contains(text(),'Empty Cart')]")).click();
	    	System.out.println("Empty cart clicked");
	    }
	    
	    String ActualCartValue = driver.findElement(By.xpath("//span[@class='count']")).getText();
	    System.out.println("Actualcart value"+ActualCartValue);
        return ActualCartValue;
	}
	
}
