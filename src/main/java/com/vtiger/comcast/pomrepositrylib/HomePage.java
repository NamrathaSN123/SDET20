package com.vtiger.comcast.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class HomePage {
	
	WebDriver driver;
   @FindBy(linkText = "Organizations")
   private WebElement organizationLink;
   
   @FindBy(linkText = "Contacts")
   private WebElement contactsLink;
   
   @FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
   private WebElement administratorlink;
   
   @FindBy(linkText = "Sign Out")
   private WebElement signoutlink;

public WebElement getOrganizationLink() {
	return organizationLink;
}

public WebElement getContactsLink() {
	return contactsLink;
}

public WebElement getAdministratorlink() {
	return administratorlink;
}

public WebElement getSignoutlink() {
	return signoutlink;
}
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void logout() {
		WebDriverUtility wLib=new WebDriverUtility();
	wLib.mouseOver(driver, administratorlink);
		
		signoutlink.click();
			
		}
}
	
	

	
	

