package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddCustomerPage 
{
	@FindBy(xpath="(//a[@href='a_customerslist.php'])[2]")
	WebElement ObjCustomerLink;
	@FindBy(xpath="(//span[contains(@data-phrase,'AddLink')])[1]")
	WebElement ObjClickAddIcon;
	@FindBy(xpath="//input[@id='x_Customer_Number']")
	WebElement ObjCustomerNumber;
	@FindBy(xpath="//input[@id='x_Customer_Name']")
	WebElement ObjCustomerName;
	@FindBy(xpath="//textarea[@id='x_Address']")
	WebElement ObjAddress;
	@FindBy(xpath="//input[@id='x_City']")
	WebElement ObjCity;
	@FindBy(xpath="//input[@id='x_Country']")
	WebElement ObjCountry;
	@FindBy(xpath="//input[@id='x_Contact_Person']")
	WebElement ObjContactPerson;
	@FindBy(xpath="//input[@id='x_Phone_Number']")
	WebElement ObjPhoneNumber;
	@FindBy(xpath="//input[@id='x__Email']")
	WebElement ObjEmail;
	@FindBy(xpath="//input[@id='x_Mobile_Number']")
	WebElement ObjMobileNumber;
	@FindBy(xpath="//input[@id='x_Notes']")
	WebElement ObjNotes;
	@FindBy(id="btnAction")
	WebElement ObjClickAdd;
	@FindBy(xpath="//button[normalize-space()='OK!']")
	WebElement ObjConfirmButton;
	@FindBy(xpath="//button[@class='ajs-button btn btn-primary']")
	WebElement ObjAlertOkButoon	;
	@FindBy(xpath="//span[@class='glyphicon glyphicon-search ewIcon']")
	WebElement ObjSearchPanelButton;
	@FindBy(xpath="//input[@id='psearch']")
	WebElement ObjSearchtextBox;
	@FindBy(xpath="//button[@id='btnsubmit']")
	WebElement ObjSearchButton;
	@FindBy(xpath="//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")
	WebElement WebTable;
	
	public boolean addCustomer(String Cname,String Address,String city,String country,
			String Cperson,String Pnumber,String Email,String Mnumber,String Notes) throws Throwable 
	{
		ObjCustomerLink.click();
		ObjClickAddIcon.click();
		String Emp_Id = ObjCustomerNumber.getAttribute("value");
		ObjCustomerName.sendKeys(Cname);
		ObjAddress.sendKeys(Address);
		ObjCity.sendKeys(city);
		ObjCountry.sendKeys(country);
		ObjContactPerson.sendKeys(Cperson);
		ObjPhoneNumber.sendKeys(Pnumber);
		ObjEmail.sendKeys(Email);
		ObjMobileNumber.sendKeys(Mnumber);
		ObjNotes.sendKeys(Notes);
		ObjClickAdd.click();
		Thread.sleep(2000);
		ObjConfirmButton.click();
		Thread.sleep(2000);
		ObjAlertOkButoon.click();
		
		if(!ObjSearchtextBox.isDisplayed())
			ObjSearchPanelButton.click();
		
		ObjSearchtextBox.clear();
		ObjSearchtextBox.sendKeys(Emp_Id);
		ObjSearchButton.click();
		
		String Actual_Id = WebTable.getText();
		
		if(Emp_Id.equals(Actual_Id))
		{
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
}
