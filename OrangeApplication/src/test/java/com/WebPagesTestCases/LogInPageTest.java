package com.WebPagesTestCases;

import org.testng.annotations.Test;

import com.BaseTest.TestBase;

import webPages.LogInPage;

public class LogInPageTest extends TestBase {
	LogInPage lip;
	@Test(priority=1)
	public void loginTest()
	{
		lip=new LogInPage();
		lip.login("Hareesh","Hareesh143@");
	}
	@Test(priority=2)
	public void imageTest()
	{
		lip=new LogInPage();
		lip.image();
	}
	@Test(priority=3)
	public void logInPageTitleValidationTest()
	{
		lip=new LogInPage();
		lip.logInPageTitleValidation();
	}
	@Test(priority=4)
	public void loginpageurlAddressValidationTest()
	{
		lip=new LogInPage();
		lip.loginpageurlAddressValidation();
	}
	
	
	@Test(priority=5)
	public void logoutTest()
	{
		lip=new LogInPage();
		lip.login("Hareesh","Hareesh143@");
		lip.logout();
	}
	

}
