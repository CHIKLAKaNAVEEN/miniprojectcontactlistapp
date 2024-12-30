package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ContactAdditionPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC101_SignUpTest extends BaseClass{
	
	@Test
	public void testSignUpRedirection() throws InterruptedException {
		
		logger.info("*****TC101_SignUpTest starts****");
		HomePage hp=new HomePage(driver);
		
		Assert.assertTrue(hp.IsSignUpButtonVisible(), "Sign up is not visible");
		logger.info("Sign Up button is visible");
		
		Assert.assertTrue(hp.IsSignUpButtonClickable(), "Sign up it not clickable");
		logger.info("Sign up button is clickable");
		hp.Click_SignUpButton();
		logger.info("click Sign up button");
		
		Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("addUser"), 
            "Not redirected to Add user page");
        System.out.println("Add user page Redirected Successfully");
        logger.info("***TC101_SignUpTest Ends*****");
        
        hp.enteruserdetails("chilaka", "naveen", "chilakanaveen@gmail.com", "naveen@123");
        hp.usersubmitbutton();
        
        
        
		
	}

}
