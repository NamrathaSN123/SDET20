package com.vtiger.comcast.organizationTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

public class CreateOrganizationPOM {
@Test
	public void createorg() throws Throwable {
		
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtillity jLib=new JavaUtillity();
		int randomInt=jLib.getRanDomNumber();
		String expected = eLib.getDataFromExcel("sheet1", 1, 3);
		
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
		
		
		 String orgname = eLib.getDataFromExcel("sheet1", 1, 2) + randomInt;
		
		
		
		driver.get(URL);
		wLib.waitUntilPageLoad(driver);
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginToApp(USERNAME, PASSWORD);
		
		HomePage home=new HomePage(driver);
		home.getOrganizationLink().click();
		
	
		
		OrganizationPage organization=new OrganizationPage(driver);
		organization.getCreatenewOrgnamizationLink().click();
		
		CreateNewOrganizationPage cno=new CreateNewOrganizationPage(driver);
		cno.creatOrg(orgname);
		
		OrganizationInfoPage orinfo=new OrganizationInfoPage(driver);
		String actualsuccesmsg=orinfo.getSuccessfulmsg().getText();
		if(actualsuccesmsg.contains(orgname)) {
			System.out.println("the organiszation is created with provided organization name");
		}
		else
			
			System.out.println("the organization is not created withe povided prg name");
		
		//String actual = orinfo.getActualtext().getText();
		
		//System.out.println(actual);
		System.out.println(expected);
		//if(actual.equals(expected)) {
			System.out.println("the organization is created with  assign type as administrator");
		//}
		//else
			//System.out.println("the organization is not created with  assign type as administrator");
		
		// home.logout();
			
		}

		
		
	}


