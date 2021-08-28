package pac;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganization {

	public static void main(String[] args) throws  IOException, InterruptedException{
		FileInputStream fisc=new FileInputStream("./data/commonData.properties");		

     // FileInputStream fis=new FileInputStream("‪‪C:\\Users\\gsrav\\Desktop\\testScriptData.xlsx");
      
      Properties pobj=new Properties();
      pobj.load(fisc);
      String BROWSER = pobj.getProperty("browser");
      String URL = pobj.getProperty("url");
      String USERNAME= pobj.getProperty("username");
      String PASSWORD = pobj.getProperty("password");
      String ACCOUNTNAME =pobj.getProperty("accountname");
      
      WebDriver driver= null;
      
      if(BROWSER.contains("chrome")) {
    	 driver= new ChromeDriver();
      }
      else if(BROWSER.equals("firefox")) {
    	 driver= new FirefoxDriver();
      }
     driver.get(URL);
     System.out.println("login page should be displayed");
     driver.findElement(By.name("user_name")).sendKeys(USERNAME);
     driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
     driver.findElement(By.id("submitButton")).click();
     System.out.println("home page should be displayed");
     
     driver.findElement(By.linkText("Organizations")).click();
     
     System.out.println("organization page should be displayed");
     driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
     
     System.out.println("creating new organization page should be displayed");
     
     driver.findElement(By.name("accountname")).sendKeys(ACCOUNTNAME);
     driver.findElement(By.xpath("//input[@name='assigntype' and @value='U']")).click();
     WebElement dropdown = driver.findElement(By.xpath("//select[@name='assigned_user_id']"));
     Select s=new Select(dropdown);
     s.selectByIndex(0);
     driver.findElement(By.xpath("//input[@title='Save [Alt+S]' and @accesskey='S']")).click();
  
     System.out.println("user as administrator should be selected and new organization should be displayed");
     
     
     if(driver.getPageSource().contains("Organization Information")) {
    	 System.out.println("the text is correct");
     }
     else
    	System.out.println("the text is incorrect");
     
     Thread.sleep(5000);
   
     WebElement logoutdropdown = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
     Actions actions=new Actions(driver);
     
     actions.moveToElement(logoutdropdown).perform();
     
     driver.findElement(By.linkText("Sign Out")).click();
     
     System.out.println("the page is logged out");
     
    
     
	}

}
