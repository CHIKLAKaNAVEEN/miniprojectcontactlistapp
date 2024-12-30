package pageObjects;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactDeletionPage extends BasePage{
	
	public ContactDeletionPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath="//tr[6][@class='contactTableBodyRow']/td[2]")
	private WebElement contact;
	
	@FindBy (xpath="//button[@id='delete']")
	private WebElement btn_delete;
	
	public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
	
	public void click_contact() {
		contact.click();
	}
	
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	public void click_deleteButton() {
		btn_delete.click();
	}	

}
