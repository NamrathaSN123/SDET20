package com.vtiger.comcast.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createnewOrgnamizationLink;

	public WebElement getCreatenewOrgnamizationLink() {
		return createnewOrgnamizationLink;
	}
	public OrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
