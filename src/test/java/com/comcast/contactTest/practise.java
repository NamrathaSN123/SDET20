package com.comcast.contactTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.comcast.genericUtility.BaseClass;
@Listeners(com.vtiger.comcast.genericUtility.ListnerImpClass.class)


public class practise extends BaseClass {
	@Test
	public void Test() throws Throwable {
		System.out.println("test1");
		System.out.println("test2");
		//Assert.assertEquals("adcd", "ABCD");
		System.out.println("test3");
		System.out.println("test4");
	}
	@Test
	public void Testrun() {
		System.out.println("test1");
		System.out.println("test2");
		SoftAssert soft=new SoftAssert();
		soft.assertEquals("abcd", "ABCD");
		System.out.println("test3");
		System.out.println("test4");
		soft.assertAll();
	}
	

}
