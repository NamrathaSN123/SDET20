package com.comcast.contactTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports {
	WebDriver driver;
	public ExtentHtmlReporter reporter;
	public ExtentReports reports;
	public ExtentTest test;
	@BeforeSuite
	public void configeBS() {
		reporter=new ExtentHtmlReporter("../SeleniumProjectMaven/ExtentReport/SDET20.html");
		System.out.println("the data base is connected");
		reporter.config().setDocumentTitle("SDET");
		reporter.config().setTheme(Theme.DARK);
		reports=new ExtentReports();
		reports.attachReporter(reporter);
	}
	@BeforeClass
	public void configBC() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@BeforeMethod()
	public void configBM() {
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		
	}
	@Test
	

	public void login() {
		test = reports.createTest("login");
		String tiltle = driver.getTitle();
		System.out.println(tiltle);
		String expected = "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
		Assert.assertEquals(tiltle, expected);
		 
		
	}
	@Test
	public void home() {
		test = reports.createTest("home");
		driver.findElement(By.linkText("Organizations")).click();
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		String homepage = driver.getTitle();
		System.out.println(homepage);
		String expectedorg = "Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM";
		 Assert.assertEquals(homepage, expectedorg);
		
		 
		
	}
	@AfterMethod()
	public void configAM() {
		Actions actions=new Actions(driver);
		WebElement administratorlink = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		actions.moveToElement(administratorlink).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
	}
	@AfterClass()
	public void configAC() {
		driver.close();
	}
	@AfterSuite
	public void configAS()
	{
		reports.flush();
		System.out.println("the data base is connected");
	}
}


 