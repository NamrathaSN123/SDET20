package popup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToHandleCalenderPopupTest {

	public static void main(String[] args) {
		String date="31";
		String monthyear="December 2021";
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		Actions actions=new Actions(driver);
		actions.moveByOffset(0, 100).click().perform();
		driver.findElement(By.xpath("//div[@class='fsw_inputBox dates inactiveWidget ']")).click();
		
		
		String xpathdate="//div[text()='"+monthyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
        String xpatharrow = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']";
	
         for(;;) {
        	 
      
         try {
        	 driver.findElement(By.xpath(xpathdate)).click();
        	 break;
         }
			
		catch (Exception e) {
			driver.findElement(By.xpath(xpatharrow)).click();
			
		}
	}
	}

}
