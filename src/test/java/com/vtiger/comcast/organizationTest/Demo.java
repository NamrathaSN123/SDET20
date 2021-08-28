package com.vtiger.comcast.organizationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.JavaUtillity;
import com.vtiger.comcast.genericUtility.WebDriverUtility;
import com.vtiger.comcast.pomrepositrylib.HomePage;
import com.vtiger.comcast.pomrepositrylib.LoginPage;
import com.vtiger.comcast.pomrepositrylib.OrganizationPage;

public class Demo {
	public WebDriver driver=null;
	FileUtility fLib=new FileUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtillity jLib=new JavaUtillity();
	public int randomInt=jLib.getRanDomNumber();
	@BeforeSuite
	public void confiureBS() {
		
		
		System.out.println("the data base is connected");
	}
	
	@BeforeClass
		public void configureBC() throws Throwable {
		
		String BROWSER = fLib.getPropertyKeyValue("browser");
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
	}
		@BeforeMethod
		public void configureBM() throws Throwable {
			
			
			String URL = fLib.getPropertyKeyValue("url");
			String USERNAME =fLib.getPropertyKeyValue("username");
			String PASSWORD = fLib.getPropertyKeyValue("password");
			driver.get(URL);
			LoginPage loginpage=new LoginPage(driver);
			loginpage.loginToApp(USERNAME, PASSWORD);
			
			
			
		}
		@AfterMethod
		public void configureAM() throws InterruptedException {
			Thread.sleep(5000);
			HomePage home=new HomePage(driver);
			 home.logout();
			 
		
	}
		@AfterClass
		public void configureAC() {
			driver.close();
		}

	
	
	
	@AfterSuite
		public void configureAS() {
			
		
		System.out.println("hi");
		
	}

}
