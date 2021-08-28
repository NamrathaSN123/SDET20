package com.vtiger.comcast.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class CreateNewOrganizationPage {
	
	WebDriver driver;
	
	@FindBy(name = "accountname")
	private WebElement orgnametxt;
	
	@FindBy(xpath = "//input[@name='assigntype' and @value='U']")
	private WebElement userradioBtn;
	
	@FindBy(name = "assigned_user_id")
	private WebElement userdropdown;
	
	@FindBy(xpath="//input[@name='assigntype' and @value='T']")
	private WebElement groupradiobtn;
	
	@FindBy(xpath="//select[@name='assigned_group_id']")
	private WebElement gruopdropdown;
	
	@FindBy(xpath = "//select[@name='rating']")
	private WebElement ratingdropdown;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement typedropdown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savelink;

	public WebElement getSavelink() {
		return savelink;
	}

	public WebElement getOrgnametxt() {
		return orgnametxt;
	}

	public WebElement getUserradioBtn() {
		return userradioBtn;
	}

	public WebElement getUserdropdown() {
		return userdropdown;
	} 
	
	public WebElement getGroupradiobtn() {
		return groupradiobtn;
	}

	public WebElement getGruopdropdown() {
		return gruopdropdown;
	}

	public WebElement getRatingdropdown() {
		return ratingdropdown;
	}

	public WebElement getTypedropdown() {
		return typedropdown;
	}
	
	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void creatOrg(String orgname) {
		orgnametxt.sendKeys(orgname);
		userradioBtn.click();
	WebDriverUtility wLib=new WebDriverUtility();
		wLib.select(userdropdown, "Administrator");
		
		savelink.click();
		
		
		
	}
	public void createOrgWithMarketing(String orgname) {
		orgnametxt.sendKeys(orgname);
		groupradiobtn.click();
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.select(gruopdropdown, "Marketing Group");

		savelink.click();
		
	}
	public void createOrgWithRating(String orgname) {
		orgnametxt.sendKeys(orgname);
		ratingdropdown.click();
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.select(ratingdropdown, "Active");
		savelink.click(); 
		
	}
	
	

	

}
