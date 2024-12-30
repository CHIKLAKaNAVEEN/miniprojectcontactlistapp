package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactEditingPage extends BasePage{
	
	public ContactEditingPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath="//tr[1][@class='contactTableBodyRow']/td[2]")
	private WebElement contact;
	
	@FindBy (xpath="//button[@id='edit-contact']")
	private WebElement btn_editContact;
	
	@FindBy (xpath="//span[@id='firstName']")
	private WebElement field_firstname;
	
	@FindBy (xpath="//input[@id='firstName']")
	private WebElement txt_firstname;
	
	@FindBy (xpath="//input[@id='lastName']")
	private WebElement txt_lastname;
	
	@FindBy (xpath="//button[@id='submit']")
	private WebElement btn_submit;
	
	@FindBy (xpath="//span[@id='error']")
	private WebElement msg_error;
	
	public void click_contact() {
		contact.click();
	}
	
	public void set_firstname(String fname) throws InterruptedException {
		txt_firstname.clear();
		Thread.sleep(4000);
		txt_firstname.sendKeys(fname);
	}
	
	public String get_firstname() {
		return field_firstname.getText();		
	}
	
	public void click_editContact() {
		btn_editContact.click();
	}
	
	public void click_submitButton() {
		btn_submit.click();		
	}
	
	public void makeFields_empty() throws InterruptedException {
		txt_firstname.clear();
		Thread.sleep(3000);
		txt_lastname.clear();		
	}
	
	public String get_errormsg() {
		return msg_error.getText();
	}
	

}
