package org.guru99.eCommerce.MobileSorting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


/*
 ********************************************************************************* 
   Step 1. Goto http://live.demoguru99.com/
   Step 2. Verify Title of the page
   Step 3. Click on ‘MOBILE’ menu
   Step 4. Verify Title of the page
   Step 5. In the list of all mobile , select ‘SORT BY’ dropdown as ‘name’
   Step 6. Verify all products are sorted by name

 **********************************************************************************
 */
public class MobileSortingPage {
	
	WebDriver driver;
	
	public MobileSortingPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	
	public String mobileSorting(String sortby) throws Exception
	{
		//Thread.sleep(3000);
	System.out.println("into the function");
		String ActualDemoSiteText = driver.findElement(By.tagName("h2")).getText();
		System.out.println("demo text"+ActualDemoSiteText);
	//	 driver.findElement(By.linkText("Mobile")).click();	
	//	driver.findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();
		HelperMethod helpermethod = new HelperMethod(driver);
		helpermethod.productchoice("Mobile");
		 System.out.println("click mobile");
	        // Step 5. In the list of all mobile , select ‘SORT BY’ dropdown as ‘name’		
new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]"))).selectByVisibleText(""+sortby+"");
		    return ActualDemoSiteText;
	}

}
