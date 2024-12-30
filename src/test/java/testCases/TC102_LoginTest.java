package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC102_LoginTest extends BaseClass {
	
	 @Test (priority=1)
     public void testValidLoginPage() throws InterruptedException {
		
		logger.info("*****TC102_LoginTest Starts****");
		HomePage hp=new HomePage(driver);
		
		Assert.assertTrue(hp.IsLoginButtonVisible(), "Login button is not visible");
		logger.info("Login button is visible");
		
		Assert.assertTrue(hp.IsSignUpButtonClickable(), "Login Button is not clickable");
		logger.info("Login button is clickable");
		
		hp.set_Loginemail(prop.getProperty("email"));
		hp.set_Password(prop.getProperty("password"));
		logger.info("Provided login credentials");
		hp.Click_LoginButton();
		logger.info("click Login button");
		Thread.sleep(3000);
		
        Assert.assertTrue(driver.getCurrentUrl().contains("contactList"), 
            "Not redirected to Contact List page");
        System.out.println("Contact list page Redirected Successfully");
        hp.Click_LogOutButton();
        logger.info("click logout button");
        Thread.sleep(3000);
        logger.info("***TC102_LoginTest Ends*****");    		
	}
	
     @Test (priority=2)
     public void testInvalidLogin() throws InterruptedException {
    	 
    	 logger.info("Invalid Login Credentials");
    	 HomePage hp=new HomePage(driver);
    	 Thread.sleep(3000);
    	 hp.set_Loginemail("naveenchilaka@gmail.com");
    	 hp.set_Password("naveench@123");
    	 logger.info("provided invalid credentials");
    	 hp.Click_LoginButton();
    	 
    	 Assert.assertFalse(driver.getCurrentUrl().contains("contactList"), 
            " redirected to Contact List page");
    	 logger.info("Not redirected to login page for Invalid credentials");
    	 System.out.println("Invalid login credentils unable to login");    	 
     }
}
