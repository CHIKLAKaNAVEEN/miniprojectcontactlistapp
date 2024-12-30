package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactAdditionPage extends BasePage{	
	
	public ContactAdditionPage(WebDriver driver) {		
		super(driver);
	}	
	
	@FindBy (xpath="//button[@id='add-contact']")
	private WebElement btn_addContact;
	
	@FindBy (xpath="//input[@id='firstName']")
	private WebElement txt_firstname;
	
	@FindBy (xpath="//input[@id='lastName']")
	private WebElement txt_lastname;
	
	@FindBy (xpath="//input[@id='birthdate']")
	private WebElement txt_birthdate;
	
	@FindBy (xpath="//input[@id='email']")
	private WebElement txt_email;
	
	@FindBy (xpath="//input[@id='phone']")
	private WebElement txt_phone;
	
	@FindBy (xpath="//input[@id='street1']")
	private WebElement txt_street1;
	
	@FindBy(xpath="//input[@id='street2']")
	private WebElement txt_street2;
	
	@FindBy (xpath="//input[@id='city']")
	private WebElement txt_city;
	
	@FindBy (xpath="//input[@id='stateProvince']")
	private WebElement txt_state;
	
	@FindBy (xpath="//input[@id='postalCode']")
	private WebElement txt_postalcode;
	
	@FindBy (xpath="//input[@id='country']")
	private WebElement txt_country;
	
	@FindBy (xpath="//button[@id='submit']")
	private WebElement btn_submit;
	
	@FindBy (xpath="//button[@id='cancel']")
	private WebElement btn_cancel;
	
	@FindBy (xpath="//span[@id='error']")
	private WebElement msg_error;
	
	public void click_addContact() {
	    mywait.until(ExpectedConditions.visibilityOf(btn_addContact)).click();	
	}
	
	public void set_FirstName(String fname) {
		txt_firstname.sendKeys(fname);
	}
	
	public void set_LastName(String lname) {
		txt_lastname.sendKeys(lname);
	}
	
	public void set_DateOfBirth(String dob) {
		txt_birthdate.sendKeys(dob);
	}
	
	public void set_email(String email) {
		txt_email.sendKeys(email);
	}
	
	public void set_PhoneNumber(String pnumber) {
		txt_phone.sendKeys(pnumber);
	}
	
	public void set_Street1(String street1) {
		txt_street1.sendKeys(street1);
	}
	
	public void set_Street2(String street2) {
		txt_street1.sendKeys(street2);
	}
	
	public void set_city(String city) {
		txt_city.sendKeys(city);
	}
	
	public void set_state(String state) {
		txt_state.sendKeys(state);
	}
	
	public void set_postalcode(String pcode) {
		txt_postalcode.sendKeys(pcode);
	}
	
	public void set_country(String country) {
		txt_country.sendKeys(country);
	}
	
	public void click_submit() {
		mywait.until(ExpectedConditions.elementToBeClickable(btn_submit)).click();
	}
	
	public String get_errorMessage() {
		return msg_error.getText();
	}
	
	public void click_CancelButton() {
		btn_cancel.click();
	}	

}
