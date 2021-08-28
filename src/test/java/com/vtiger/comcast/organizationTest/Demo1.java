package com.vtiger.comcast.organizationTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.comcast.pomrepositrylib.CreateNewOrganizationPage;
import com.vtiger.comcast.pomrepositrylib.HomePage;
import com.vtiger.comcast.pomrepositrylib.LoginPage;
import com.vtiger.comcast.pomrepositrylib.OrganizationInfoPage;
import com.vtiger.comcast.pomrepositrylib.OrganizationPage;

public class Demo1  extends BaseClass{

	@Test
	public void createorgtest() throws Throwable {
		//WebDriver driver=null;
		
		HomePage home=new HomePage(driver);
		home.getOrganizationLink().click();
		
	
		
		OrganizationPage organization=new OrganizationPage(driver);
		organization.getCreatenewOrgnamizationLink().click();
		
		 String orgname = eLib.getDataFromExcel("sheet1", 1, 2) + randomInt;
		
		CreateNewOrganizationPage cno=new CreateNewOrganizationPage(driver);
		cno.creatOrg(orgname);
		
		OrganizationInfoPage orinfo=new OrganizationInfoPage(driver);
		String actsucessfulMsg=orinfo.getSuccessfulmsg().getText();
		if(actsucessfulMsg.contains(orgname)) {
			System.out.println("created");
		}
		else
			System.out.println("not created");
	
		

	}
	@Test
	public void createOrgMarketing() throws Throwable {
		HomePage home=new HomePage(driver);
		home.getOrganizationLink().click();
		
	
		
		OrganizationPage organization=new OrganizationPage(driver);
		organization.getCreatenewOrgnamizationLink().click();
		
		 String orgname = eLib.getDataFromExcel("sheet1", 4, 2) + randomInt;

		CreateNewOrganizationPage createnewOrga=new CreateNewOrganizationPage(driver);
		createnewOrga.createOrgWithMarketing(orgname);
			
			
			OrganizationInfoPage orinfo=new OrganizationInfoPage(driver);
			String actsucessfulMsg=orinfo.getSuccessfulmsg().getText();
			
			
			if(actsucessfulMsg.contains(orgname)) {
				System.out.println("created");
			}
			else
				System.out.println("not created");
			
		
	}
	@Test
	public void createOrgWithRating() throws Throwable {
		
		
		
		HomePage home=new HomePage(driver);
		home.getOrganizationLink().click();
		
	
		
		OrganizationPage organization=new OrganizationPage(driver);
		organization.getCreatenewOrgnamizationLink().click();
		String orgname = eLib.getDataFromExcel("sheet1", 7, 2) + randomInt;
		
		CreateNewOrganizationPage createneworg=new CreateNewOrganizationPage(driver);
		createneworg.createOrgWithRating(orgname);
		
		OrganizationInfoPage orinfo=new OrganizationInfoPage(driver);
		String actsucessfulMsg=orinfo.getSuccessfulmsg().getText();
		if(actsucessfulMsg.contains(orgname)) {
			System.out.println("created");
		}
		else
			System.out.println("not created");
		
	}

}
