package com.vtiger.comcast.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	WebDriver driver;
	
	public OrganizationInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(className = "dvHeaderText")
	private WebElement successfulmsg;
	
	@FindBy(linkText = "Marketing Group")
	private WebElement actualMarketing;
	
	@FindBy(xpath = "//a[@href='index.php?module=Users&action=DetailView&record=1']")
	private WebElement actualtextforAdministrator;
	
	@FindBy(xpath = "//a[@href='index.php?module=Settings&action=GroupDetailView&groupId=3']")
	private WebElement actualtextformarketing;
	
	@FindBy(xpath = "//span[@id='dtlview_Rating']")
	private WebElement actualtextforrating;
			
	public WebElement getActualtextformarketing() {
		return actualtextformarketing;
	}

	public WebElement getActualtextforrating() {
		return actualtextforrating;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getActualtextforAdministrator() {
		return actualtextforAdministrator;
	}

	public WebElement getActualMarketing() {
		return actualMarketing;
	}

	public WebElement getSuccessfulmsg() {
		return successfulmsg;
		
	}

	
	
	
		
		
	}
	
	


