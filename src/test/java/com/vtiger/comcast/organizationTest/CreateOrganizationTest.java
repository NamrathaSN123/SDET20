package com.vtiger.comcast.organizationTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.pomrepositrylib.CreateNewOrganizationPage;
import com.vtiger.comcast.pomrepositrylib.HomePage;
import com.vtiger.comcast.pomrepositrylib.OrganizationInfoPage;
import com.vtiger.comcast.pomrepositrylib.OrganizationPage;
@Listeners(com.vtiger.comcast.genericUtility.ListnerImpClass.class)
public class CreateOrganizationTest extends BaseClass {
	
	@Test(groups="Smoke testing")
	public void createorgtest() throws Throwable {
		
		ExcelUtility eLib=new ExcelUtility();
		String orgname = eLib.getDataFromExcel("sheet1", 1, 2) + randomInt;
		String expectedtextforadministrator = eLib.getDataFromExcel("sheet1", 1, 3);
		OrganizationInfoPage orinfo=new OrganizationInfoPage(driver);
		
		
		HomePage home=new HomePage(driver);
		home.getOrganizationLink().click();
		
	
		
		OrganizationPage organization=new OrganizationPage(driver);
		organization.getCreatenewOrgnamizationLink().click();
		
		 
		
		CreateNewOrganizationPage cno=new CreateNewOrganizationPage(driver);
		cno.creatOrg(orgname);
		String sucessmsg = orinfo.getSuccessfulmsg().getText();
		String actualtextforadmoinistrator = orinfo.getActualtextforAdministrator().getText();
	
		
		boolean expce = sucessmsg.contains(orgname);
		Assert.assertTrue(expce);
		
		//if(sucessmsg.contains(orgname)) {
			System.out.println("the organization is created with proviede organization name");
		//}
		//else
			//System.out.println("the organization name is not created with provided organization name");
	   
		Assert.assertEquals(actualtextforadmoinistrator, expectedtextforadministrator);
		
		//if(actualtextforadmoinistrator.equals(expectedtextforadministrator)) {
		System.out.println("the assigntype is administrator");
	//}
	//else
		//System.out.println("the assgn type is not administrator");
		

	}
	@Test(groups="Regression testing")
	public void createOrgMarketingTest() throws Throwable {
		
		 String orgname = eLib.getDataFromExcel("sheet1", 4, 2) + randomInt;
		 String expectedtextformarketing = eLib.getDataFromExcel("sheet1", 4, 3);
			OrganizationInfoPage orinfo=new OrganizationInfoPage(driver);
			
			
		HomePage home=new HomePage(driver);
		home.getOrganizationLink().click();
		
	
		
		OrganizationPage organization=new OrganizationPage(driver);
		organization.getCreatenewOrgnamizationLink().click();
		
		

		CreateNewOrganizationPage createnewOrga=new CreateNewOrganizationPage(driver);
		createnewOrga.createOrgWithMarketing(orgname);
		
		String sucessmsg = orinfo.getSuccessfulmsg().getText();
		String actualtextformarketing = orinfo.getActualMarketing().getText();
		boolean expected  = sucessmsg.contains(orgname);
		Assert.assertTrue(expected);
			
			
		//if(sucessmsg.contains(orgname)) {
			System.out.println("the organization is created with proviede organization name");
		//}
		//else
			//System.out.println("the organization name is not created with provided organization name");
	Assert.assertEquals(actualtextformarketing, expectedtextformarketing);
		
		//if(actualtextformarketing.equals(expectedtextformarketing)) {
		System.out.println("the assigntype is marketing");
	//}
	//else
		//System.out.println("the assgn type is not marketing");
			
		
	}
	@Test(groups="Regression testing")
	public void createOrgWithRatingTest() throws Throwable {
		
		 String orgname = eLib.getDataFromExcel("sheet1", 7, 2) + randomInt;
		 String expectedtextforrating = eLib.getDataFromExcel("sheet1", 7, 3);
		 OrganizationInfoPage orinfo=new OrganizationInfoPage(driver);
			
			
		
		
		
		HomePage home=new HomePage(driver);
		home.getOrganizationLink().click();
		
	
		
		OrganizationPage organization=new OrganizationPage(driver);
		organization.getCreatenewOrgnamizationLink().click();
		
		
		CreateNewOrganizationPage createneworg=new CreateNewOrganizationPage(driver);
		createneworg.createOrgWithRating(orgname);
		String actualtextforrating = orinfo.getActualtextforrating().getText();
		String sucessmsg = orinfo.getSuccessfulmsg().getText();
		boolean expect = sucessmsg.contains(orgname);
		Assert.assertTrue(expect);
		
		//if(sucessmsg.contains(orgname)) {
			System.out.println("the organization is created with proviede organization name");
		//}
		//else
			//System.out.println("the organization name is not created with provided organization name");
	Assert.assertEquals(actualtextforrating, expectedtextforrating);
		
		//if(actualtextforrating.equals(expectedtextforrating)) {
		System.out.println("the rating is active");
	//}
	//else
		//System.out.println("the rating  is not active");
			
		
	}

}



