package pageObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactDisplay extends BasePage {
	
	public ContactDisplay(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//tr[@class='contactTableBodyRow']/td[2]")
	private List<WebElement> contact_names;
	
	@FindBy(xpath="//tr[@class='contactTableBodyRow']/td[5]")
	private List<WebElement> phone_number;
	
	@FindBy(xpath="//table[@class='contactTable']//tr")
	private List<WebElement> all_contacts;
	
	@FindBy(xpath="(//tr[@class='contactTableBodyRow']/td[2])[1]")
	private WebElement dob;        
       
	public String get_Contactdetails() throws InterruptedException {  
       
		List<WebElement> contacts=all_contacts;
		for(WebElement detail:contacts) {
			if (detail.findElements(By.tagName("td")).size() > 0) {	            
	            System.out.println(detail.getText());
			}
		}
		return null;
	}		
	
	public boolean verifyPhoneNumberFormat() {
		boolean flag=false;
		Iterator<WebElement> it=phone_number.iterator();
		while(it.hasNext())
		{
		    if (it.next().getText().contains("+91")) 
		        flag=true;     
		    else
		    	flag=false;		    
		}
		return flag;	   
	}
	
	public List<String> getAllContactNames() {
        List<String> names = new ArrayList<>();
        for (WebElement name : contact_names) {        	
        	 String fullname=name.getText();
            // Extract last name (assuming last word is last name)
            String[] nameParts = fullname.trim().split("\\s+");
            String lastname= nameParts[nameParts.length - 1];             	
        	names.add(lastname);      	
        }
        return names;
    }	

    public boolean isContactListSorted() {
        List<String> names = getAllContactNames();
        List<String> sortedNames = new ArrayList<>(names);
        java.util.Collections.sort(sortedNames);
        return names.equals(sortedNames);
    }
   
  } 
  
