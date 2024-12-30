package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LogOutPage;
import testBase.BaseClass;

public class TC107_LogoutTest extends BaseClass{
	
	@Test
	public void testLogout() throws InterruptedException {
		logger.info("******TC107_LogoutTest Starts****");		
		logger.info("......testLogout.....");
		HomePage hp=new HomePage(driver);
		logger.info("Home Page");
		hp.set_Loginemail(prop.getProperty("email"));
		hp.set_Password(prop.getProperty("password"));
		logger.info("click login button");
		hp.Click_LoginButton();
		Thread.sleep(3000);	
		
		LogOutPage lop=new LogOutPage(driver);
		lop.click_logoutButton();
		Thread.sleep(3000);		
		Assert.assertTrue(driver.getTitle().contains("Contact List App"),
				"Not logged out properly");
		logger.info("logged out");
		logger.info("******TC107_LogoutTest Ends****");		
		
	}

}
