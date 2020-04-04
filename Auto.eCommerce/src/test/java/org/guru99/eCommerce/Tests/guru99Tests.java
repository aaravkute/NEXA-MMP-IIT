package org.guru99.eCommerce.Tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.guru99.eCommerce.MobileSorting.Checkout;
import org.guru99.eCommerce.MobileSorting.CompareTwoProductsPage;
import org.guru99.eCommerce.MobileSorting.HelperMethod;
import org.guru99.eCommerce.MobileSorting.MobileSortingPage;
import org.guru99.eCommerce.MobileSorting.Reorder;
import org.guru99.eCommerce.MobileSorting.ScreenshotPage;
import org.guru99.eCommerce.MobileSorting.VerifyCostOfProduct;
import org.guru99.eCommerce.MobileSorting.VerifyCreateAccountShareWishlistUsingEmail;
import org.guru99.eCommerce.MobileSorting.VerifyDiscountCoupanWorks;
import org.guru99.eCommerce.MobileSorting.VerifyProductAvailability;
import org.guru99.eCommerce.MobileSorting.VerifyRecentOrders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class guru99Tests {
	
	Random rnd = new Random();
	HashMap<String, String> hMap = new HashMap<String, String>();
	

	WebDriver driver;
//	@BeforeMethod
//	@BeforeTest


	@BeforeTest
	public void launchBrowser() throws Exception
	{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	    driver.get("http://live.demoguru99.com/");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
	}
	
	
@Test(priority = 1, testName="mobilesort")
			
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
	
	public void mobileSorting11() throws Exception
	{
	
	    
		MobileSortingPage mobilesor = new MobileSortingPage(driver);
		
		String ActualDemoSiteText = mobilesor.mobileSorting("Name").trim();
		System.out.println("actual demo site text"+ActualDemoSiteText);
		String ExpectedDemoSiteText = "THIS IS DEMO SITE FOR";
		Assert.assertEquals(ExpectedDemoSiteText, ActualDemoSiteText);
		
		ScreenshotPage screenshot = new ScreenshotPage(driver);
		screenshot.takeSnapShot(driver, "C:\\Users\\heman\\OneDrive\\Desktop\\GURU99 PROJECT\\file.jpeg") ;  
	}
	

@Test(priority = 5,testName="costcomparison")

	/* 
	TEST CASE : VERIFY THAT COST OF PRODUCT IN LIST PAGE AND DETAILED PAGE ARE EQUAL
	1. GO  TO WEBSITE HTTP://LIVE.DEMOGURU99.COM/
	2. CLICK ON MOBILE MENU
	3. IN THE LIST OF ALL MOBILE, READ THE COST OF SONY EXPERIA MOBILE . NOTE THE VALUE
	4. CLICK ON SONY EXPERIA MOBILE
	5. READ THE SONY EXPERIA MOBILE FROM DETSIL PAGE
	6. COMAPRE VALUE IN LIST PAGE AND DETAILED PAGE
	*/
	

	public void verifyCostOfProduct()
	
		{
	  
			VerifyCostOfProduct verifyproduct = new VerifyCostOfProduct(driver);
			HashMap<String, String> list = verifyproduct.verifyxperiacostlistpage();
			
			HashMap<String, String> detail = verifyproduct.verifyxperiacostdetailpage();
		
			Assert.assertEquals(list, detail);
			
	
		}

@Test(priority =7)

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

	public void verifyProductAvailability() throws Exception
	{
		VerifyProductAvailability productavailability = new VerifyProductAvailability(driver);
		String Actualerror = productavailability.ProductAvailability("1000").trim();
		String ExpectedErrorMsg = "Some of the products cannot be ordered in requested quantity.";
		System.out.println("expected error message"+ExpectedErrorMsg);
		
		Assert.assertEquals(Actualerror, ExpectedErrorMsg);
			
	
		String ActualCartCount = productavailability.CartCount();
		String ExpectedCartCount = "";
		
		Assert.assertEquals(ActualCartCount, ExpectedCartCount);
			
	
	}


@Test(priority = 10)

		/* 
		TEST CASE : VERIFY THAT you are able to compare two products
		1. GO  TO WEBSITE HTTP://LIVE.DEMOGURU99.COM/
		2. CLICK ON MOBILE MENU
		3. IN MOBILE PRODUCT LIST, CLICK ON 'ADD TO COMPARE' FOR 2 MOBILES
		4. CLICK ON 'COMPARE' BUTTON
		5. VERIFY THE POP UP WINDOW  AND CHECK THAT THE PRODUCTS ARE REFLECTED IN IT
		6. CLOSE THE POP UP WINDOWS.
		*/

	public void verifyCompareProducts() throws Exception
	{
	
		 CompareTwoProductsPage compareproduct = new CompareTwoProductsPage(driver);	
		 compareproduct.CompareTwoProducts();
		 ArrayList<String> CompareMobileWIndowTitle = compareproduct.CompareTwoProductsWindow();
		 
		 System.out.println("\nUsing Iterator");
		 
		 
		 Iterator<String> itr=CompareMobileWIndowTitle.iterator();
		
		 while(itr.hasNext())
			   {
			 		String obj = (String) itr.next();
			 		System.out.println("printing compared list of mobile"+obj);
			   }
	
	
	}

@Test(priority = 15, enabled = false)
		
		/*
		 * TEST CASE: VERIFY YOU CAN CREATE ACCOUNT IN e COMMERCE SITE AND CAN SHARE WISHLIST TO OTHER PEOPLE 
		 * USING EMAIL
		 * 
		 * 1. GO  TO WEBSITE HTTP://LIVE.DEMOGURU99.COM/
		 * 2. CLICK ON MY ACCOUNT LINK
		 * 3. CLICK CREATE ACCOUNT LINK AND FILL NEW USER INFORMATION EXCPET EMAILID
		 * 4. CLICK REGISTER.
		 * 5. VERIFY REGISTRATION IS DONE
		 * 6. GO TO TV MENU
		 * 7. ADD PRODUCT IN YOUR WISHLIST  (LG LCD)
		 * 8. CICLK SHARE WISHLIST.
		 * 9. IN NEXT PAGE ENTER EMAIL AND A MESSAGE AND CLICK SHARE WISHLIST.
		 * 10. CHECK WISHLIST IS SHARED.
		 * 
		 */
	public void verifycreateaccount()
		{
			driver.get("http://live.demoguru99.com/index.php/mobile.html");
			VerifyCreateAccountShareWishlistUsingEmail sharewishlist = new VerifyCreateAccountShareWishlistUsingEmail(driver);
			sharewishlist.accountlink();
			hMap = sharewishlist.registerCustomer("chaudharihemangi@gmail.com", "password");
		//	String successmsg = accobj4.register();
		//	Assert.assertTrue(true,successmsg );
			//System.out.println("success msg"+successmsg);
			sharewishlist.sharewishlist();
			
		}

@Test(priority = 20, enabled = false)
		
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
	public void checkout()
	{
		 driver.get("http://live.demoguru99.com/");
		HelperMethod helpmethod = new HelperMethod(driver);
		VerifyCreateAccountShareWishlistUsingEmail sharewishlist = new VerifyCreateAccountShareWishlistUsingEmail(driver);
		sharewishlist.accountlink();
		helpmethod.Login("chaudhari@gmail.com", "aarav12");
		Checkout checkout = new Checkout(driver);
		helpmethod.navigateToSubMenu("My Wishlist");
		checkout.checkout("sdfsdwf", "feghh", "577767", "8545344");
	
	}

  @Test(priority = 25, enabled = false)
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

  public void verifyRecentOrders()
  {
	  
	  HelperMethod helpmethod = new HelperMethod(driver);
	  helpmethod.Login("chaudhari@gmail.com", "aarav12");
	  helpmethod.navigateToSubMenu("My Orders");
	  VerifyRecentOrders recentorders = new VerifyRecentOrders(driver);
	  String actual = recentorders.ViewRecentOrders();
	  Assert.assertEquals("Pending", actual);
	//  Assert.assertEquals("RECENT ORDERS", actual);
	  // unable to perform next step in a test case as required stes are not available 
	  
  }
  
  
  @Test(priority = 30, enabled = false)
  
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

  
  public void reorder()
  {
	  HelperMethod helpmethod = new HelperMethod(driver);
	  helpmethod.accountlink();
	  helpmethod.Login("chaudhari@gmail.com", "aarav12");
	  Reorder reorder = new Reorder(driver);
	  hMap = reorder.reorder("10");
	  String grandbeforeupdate = hMap.get("grandtotalbeforeupdate");
	  String grandafterupdate = hMap.get("grandtotalafterupdate");
	  
	  Assert.assertTrue("Price has been changed",grandbeforeupdate!=grandafterupdate );
	  
  }
  
  @Test(priority = 35, enabled = false)
  
	    /*
		 *  1. Go to http://live.demoguru99.com/
		 *  2. Go to Mobile and add IPHONE to cart
	     *  3. Enter Coupon Code
		 *  4. Verify the discount generated
		 */
  public void discountcoupan()
  {
	  HelperMethod helpmethod = new HelperMethod(driver);
	  helpmethod.productchoice("Mobile");
	  
	  VerifyDiscountCoupanWorks disocuntCoupan = new VerifyDiscountCoupanWorks(driver);
	  hMap = disocuntCoupan.discountCoupan();
	  
	  String discountPrice = hMap.get("Discount");
	  String suntotal = hMap.get("SubTotal");
  }
}
