package com.vtiger.comcast.genericUtility;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.comcast.genericUtility.ExcelUtility;
	import com.vtiger.comcast.genericUtility.FileUtility;
	import com.vtiger.comcast.genericUtility.JavaUtillity;
	import com.vtiger.comcast.genericUtility.WebDriverUtility;
	import com.vtiger.comcast.pomrepositrylib.HomePage;
	import com.vtiger.comcast.pomrepositrylib.LoginPage;
	import com.vtiger.comcast.pomrepositrylib.OrganizationPage;

	public class BaseClass {
		public static WebDriver s;
		public WebDriver driver=null;
		public FileUtility fLib=new FileUtility();
		public WebDriverUtility wLib=new WebDriverUtility();
		public ExcelUtility eLib=new ExcelUtility();
		public JavaUtillity jLib=new JavaUtillity();
		public int randomInt=jLib.getRanDomNumber();
		@BeforeSuite(groups= {"Smoke testing","Regression testing"})
		public void confiureBS() {
			
			
			System.out.println("the data base is connected");
		}
		//@Parameters("BROWSER")
		
		@BeforeClass(groups= {"Smoke testing","Regression testing"})
			public void configureBC() throws Throwable {
			
			String BROWSER = fLib.getPropertyKeyValue("browser");
			if(BROWSER.equals("chrome")) {
				driver=new ChromeDriver();
			}
			else if(BROWSER.equals("firefox")) {
				driver=new FirefoxDriver();
			}else {
				driver=new ChromeDriver();
			}
			wLib.waitUntilPageLoad(driver);
			driver.manage().window().maximize();
			s=driver;
		
			
		}
		
			@BeforeMethod(groups= {"Smoke testing","Regression testing"})
			public void configureBM() throws Throwable {
				
				
				String URL = fLib.getPropertyKeyValue("url");
				String USERNAME =fLib.getPropertyKeyValue("username");
				String PASSWORD = fLib.getPropertyKeyValue("password");
				driver.get(URL);
				LoginPage loginpage=new LoginPage(driver);
				loginpage.loginToApp(USERNAME, PASSWORD);
				
				
				
			}
			@AfterMethod(groups= {"Smoke testing","Regression testing"})
			public void configureAM() throws InterruptedException {
				//Thread.sleep(5000);
				HomePage home=new HomePage(driver);
				 home.logout();
				 
			
		}
			@AfterClass(groups= {"Smoke testing","Regression testing"})
			public void configureAC() {
				driver.close();
			}

		
		
		
		@AfterSuite(groups= {"Smoke testing","Regression testing"})
			public void configureAS() {
				
			
			System.out.println("the connection with data base is closed");
			
		}

	}



