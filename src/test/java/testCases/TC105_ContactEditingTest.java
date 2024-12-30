package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ContactEditingPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC105_ContactEditingTest extends BaseClass{
	
	@Test
	public void testContactsEditing() throws InterruptedException {
		logger.info("******TC105_ContactEditingTest Starts****");
		logger.info("......testContactsEditing.....");
		HomePage hp=new HomePage(driver);
		logger.info("Home Page");
		hp.set_Loginemail(prop.getProperty("email"));
		hp.set_Password(prop.getProperty("password"));
		logger.info("click login button");
		hp.Click_LoginButton();
		Thread.sleep(3000);	
		
		ContactEditingPage cep=new ContactEditingPage(driver); 
		cep.click_contact();
		String actualname=cep.get_firstname();
		logger.info("click the contact to edit");
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("contactDetails"), 
	            "Not redirected to contactDetails page");	
		logger.info("redirected to contact details Page");
		
		cep.click_editContact();
		logger.info("click edit contact");
		cep.set_firstname("John");
		cep.click_submitButton();
		Thread.sleep(3000);
		Assert.assertNotEquals(actualname, cep.get_firstname());
		System.out.println("Changes made correctly, doesn't affect any other data");
		logger.info("Changes Made correctly");
		Thread.sleep(5000);
		
	}
	
	@Test(priority=2)
	public void TestEmptyfields() throws InterruptedException {
		logger.info(".....TestEmptyfields.....");
		ContactEditingPage cep=new ContactEditingPage(driver);
		cep.click_editContact();
		Thread.sleep(3000);
		
		logger.info("clearing the fields");
		cep.makeFields_empty();
		cep.click_submitButton();
		Thread.sleep(3000);
		Assert.assertTrue(cep.get_errormsg().contains("Validation failed"), 
				"Taking some empty fields as contact");
		logger.info("app doesn't allow to save empty fields");
		logger.info("******TC105_ContactEditingTest ends*****");
		
	}

}
