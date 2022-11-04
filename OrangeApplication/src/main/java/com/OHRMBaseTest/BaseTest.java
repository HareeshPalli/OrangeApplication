package com.OHRMBaseTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;


public class BaseTest {
	public Logger logger;
	public WebDriver driver;
	String ApplicationURLAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	
	@BeforeTest
	public void setup()
	{
		PropertyConfigurator.configure("Log4j.properties");
		logger=Logger.getLogger(BaseTest.class);
		
		System.setProperty("webdriver.chrome.driver", "D:/Jar files/chromedriver.exe");
		driver=new ChromeDriver();
		
		logger.info("Chromebrowser Launch Successfully");

		driver.get(ApplicationURLAddress);
		driver.manage().window().maximize();
		logger.info("OrangeHRM Application Maximaized");
		
		//Screenshot.takePicture(driver,image1);
		
	/*	File OramgeHrmloginpage=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(OramgeHrmloginpage,new File("./OrangeApplication/Screenshots.png"));*/
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@AfterTest
	public void close()
	{
		driver.quit();
		logger.info("OrangeHRM Application close Successfully");
	}
	
	

}
