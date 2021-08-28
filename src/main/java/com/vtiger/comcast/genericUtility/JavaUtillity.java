package com.vtiger.comcast.genericUtility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

/**
 * this class contains java specific generic libraries
 */


public class JavaUtillity {
	
	/**
	 * this method is used to generate the random number with in the range of 0 to 1000
	 * @return intData
	 */
public int getRanDomNumber() {
	Random ranDom=new Random();
	int ranDomNum = ranDom.nextInt(1000);
	return ranDomNum;
}

public String getSystemData() {
	Date date=new Date();
	String systemDateAndTime = date.toString();
	return systemDateAndTime;
}
/**
 * this method is used to get system date and time with yyyy-mm-dd format
 * @return 
 */

public String getsystemDate_YYYY_MM_DD() {
	Date date=new Date();
	String systemDateAndTime=date.toString();
	System.out.println(systemDateAndTime);
	String[] arr=systemDateAndTime.split("");
	String DD=arr[2];
	String YYYY=arr[5];
	int MM=date.getMonth()+1;
	
	String finalFormat=YYYY+"-"+MM+"-"+DD;
	return finalFormat;
	
}
	/**
	 * used to pass Virtual Keys to OS
	 * @throws Throwable
	 */

 public void pressVirtualEnterKey() throws Throwable{
	 
	 Robot robot=new Robot();
	 robot.keyPress(KeyEvent.VK_ENTER);
	 robot.keyRelease(KeyEvent.VK_ENTER);
 
 }

}
