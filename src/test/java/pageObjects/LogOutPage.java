package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogOutPage extends BasePage {
	
	public LogOutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath="//button[@id='logout']")
	private WebElement btn_logout;
	
	public void click_logoutButton() {
		mywait.until(ExpectedConditions.visibilityOf(btn_logout)).click();
	}

}
