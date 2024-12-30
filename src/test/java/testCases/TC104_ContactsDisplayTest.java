package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ContactDisplay;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC104_ContactsDisplayTest extends BaseClass {
	
	@Test (priority=1)
	public void testContactsAlphabeticalOrder() throws InterruptedException {
		logger.info("******TC104_ContactsDisplayTest Starts****");
		logger.info("......testContactsAlphabeticalOrder.....");
		HomePage hp=new HomePage(driver);
		logger.info("Home Page");
		hp.set_Loginemail(prop.getProperty("email"));
		hp.set_Password(prop.getProperty("password"));
		logger.info("click login button");
		hp.Click_LoginButton();
		Thread.sleep(3000);	
		
		ContactDisplay cd=new ContactDisplay(driver);
		System.out.println("Contact details");
		cd.get_Contactdetails();
		logger.info("contact details are displayed");
		
		logger.info("verify alphabetical order");
        Assert.assertTrue(cd.isContactListSorted(), 
                    "Contacts are not in alphabetical order");	
        
	}	
	
	@Test(priority=2)
	public void testPhonenumberwithExtension() throws InterruptedException {
		logger.info(".....testPhonenumberwithExtension.....");
		ContactDisplay cd=new ContactDisplay(driver);
	    Thread.sleep(3000);
	    Assert.assertTrue(cd.verifyPhoneNumberFormat(), 
                "phone numbers doesn't have extensions"); 
	    logger.info("Phone number having extensions");
	    logger.info("*****TC104_ContactsDisplayTest Ends*****");
		
	}

}
