package com.vtiger.comcast.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
		@FindBy(name ="user_name")
		private WebElement usernametxt;
		
		@FindBy(name="user_password")
		private WebElement passwordtxt;
		
		@FindBy(id = "submitButton")
		private WebElement submitbutton;

		public WebElement getUsernametxt() {
			return usernametxt;
		}

		public WebElement getPasswordtxt() {
			return passwordtxt;
		}

		public WebElement getSubmitbutton() {
			return submitbutton;
		}
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		public void loginToApp(String username , String password) {
			usernametxt.sendKeys(username);
			passwordtxt.sendKeys(password);;
			submitbutton.click();
			
		}
		
	
	
}
