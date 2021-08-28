package com.vtiger.comcast.organizationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.JavaUtillity;
import com.vtiger.comcast.genericUtility.WebDriverUtility;
import com.vtiger.comcast.pomrepositrylib.CreateNewOrganizationPage;
import com.vtiger.comcast.pomrepositrylib.HomePage;
import com.vtiger.comcast.pomrepositrylib.LoginPage;
import com.vtiger.comcast.pomrepositrylib.OrganizationInfoPage;
import com.vtiger.comcast.pomrepositrylib.OrganizationPage;

public class CreateOrganizationWithMarketingUsingPOM {
@Test
	public void createorgwithmar() throws Throwable {
		
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtillity jLib=new JavaUtillity();
		int randomInt=jLib.getRanDomNumber();
		
		WebDriver driver=null;
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME =fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		
		
		 String orgname = eLib.getDataFromExcel("sheet1", 4, 2)+randomInt;
		
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginToApp(USERNAME, PASSWORD);
		
		HomePage home=new HomePage(driver);
		home.getOrganizationLink().click();
		
	
		
		OrganizationPage organization=new OrganizationPage(driver);
		organization.getCreatenewOrgnamizationLink().click();

			CreateNewOrganizationPage createnewOrga=new CreateNewOrganizationPage(driver);
			createnewOrga.createOrgWithMarketing(orgname);
			
			
			OrganizationInfoPage orinfo=new OrganizationInfoPage(driver);
			String actsucessfulMsg=orinfo.getSuccessfulmsg().getText();
			String act=orinfo.getActualMarketing().getText();
			
			if(actsucessfulMsg.contains(orgname)) {
				System.out.println("created");
			}
			else
				System.out.println("not created");
			
			 home.logout();
		

	}

}
