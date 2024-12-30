package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ContactAdditionPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC103_ContactAdditionTest extends BaseClass {
	
	@Test (priority=1)
	public void testContactListMandatoryfileds() throws InterruptedException {	
		logger.info("******TC103_ContactAdditionTest Starts****");
		logger.info("......testContactListMandatoryfileds.....");
		HomePage hp=new HomePage(driver);
		logger.info("Home Page");
		hp.set_Loginemail(prop.getProperty("email"));
		hp.set_Password(prop.getProperty("password"));
		logger.info("click login button");
		hp.Click_LoginButton();
		Thread.sleep(3000);		
		
		logger.info("Contact List page");
		ContactAdditionPage clp=new ContactAdditionPage(driver);
		clp.click_addContact();		
		logger.info("click add contact");
		Thread.sleep(4000);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("addContact"), 
	            "Not redirected to add contact page");
	    		
		clp.set_FirstName("Naveen");
		clp.set_LastName("Chilaka");
		clp.set_DateOfBirth("1996-07-05");
		clp.set_email("test@sample.com");
		clp.set_PhoneNumber("8983878389");
		clp.set_Street1("kukatpally hyderabad");
		clp.set_Street2("kphb colony");
		clp.set_city("Hyderabad");
		clp.set_country("India");		
		logger.info("provided the contact details");
		clp.click_submit();		
		logger.info("click submit button");	
		Thread.sleep(3000);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("contactList"), 
		            "Not redirected to Contact List page");
		logger.info("redirected to contact list page");
		System.out.println("added the contact with mandatory fields"); 		
	}
	
	@Test (priority=2)
	public void testContactListoptionalfileds() throws InterruptedException {
		logger.info("....testContactListoptionalfileds.......");
		logger.info("Contact List page");
		ContactAdditionPage clp=new ContactAdditionPage(driver);
		clp.click_addContact();		
		logger.info("click add contact");
		Thread.sleep(3000);
		
		clp.set_FirstName("harsh");
		clp.set_LastName("Danny");
		clp.click_submit();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("contactList"), 
	            "not redirected to Contact List page");		
	}
	
	@Test(priority=3)
	public void duplicateContactList() throws InterruptedException {
		logger.info("....testduplicateContactList.......");
		logger.info("Contact List page");
		ContactAdditionPage clp=new ContactAdditionPage(driver);
		clp.click_addContact();		
		logger.info("click add contact");
		Thread.sleep(3000);
		
		clp.set_FirstName("ken");
		clp.set_LastName("Smith");
		clp.set_DateOfBirth("12-05-2000");
		clp.click_submit();
		logger.info("Provided mandatory files for contact");
		Thread.sleep(3000);
		Assert.assertTrue(clp.get_errorMessage().contains("Birthdate is invalid"), 
				      "Birthdate is not following any format");
		
		logger.info("Check for duplicate contact error");
		clp.click_CancelButton();
		clp.click_addContact();		
		logger.info("click add contact");
		Thread.sleep(3000);
		
		clp.set_FirstName("John");
		clp.set_LastName("David");
        String errorMsg = clp.get_errorMessage();
        Assert.assertTrue(
            errorMsg.toLowerCase().contains("duplicate") || 
            errorMsg.toLowerCase().contains("already exists"), 
            "Expected error message for duplicate contact, but got: " + errorMsg);	
        
	}
}










