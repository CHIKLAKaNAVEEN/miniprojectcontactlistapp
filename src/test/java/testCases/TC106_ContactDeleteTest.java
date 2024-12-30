package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ContactDeletionPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC106_ContactDeleteTest extends BaseClass {
	
	@Test
	public void testContactDelete() throws InterruptedException {
		logger.info("******TC106_ContactDeleteTest Starts****");
		logger.info("......testContactDelete.....");
		HomePage hp=new HomePage(driver);
		logger.info("Home Page");
		hp.set_Loginemail(prop.getProperty("email"));
		hp.set_Password(prop.getProperty("password"));
		logger.info("click login button");
		hp.Click_LoginButton();
		Thread.sleep(3000);	
		
		ContactDeletionPage cdp=new ContactDeletionPage(driver);
		logger.info("Contact details Page");
		cdp.click_contact();
		logger.info("click the contact to delete");
		Thread.sleep(3000);
		cdp.click_deleteButton();
		Assert.assertTrue(cdp.isAlertPresent(), "Popup is not present");
		logger.info("alert pop ups");
		cdp.acceptAlert();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("contactList"), "not deleted the contact");
		System.out.println("contact deletion confirmed");
		logger.info("******TC106_ContactDeleteTest Ends****");	
		Thread.sleep(3000);
	}
	
}
	
