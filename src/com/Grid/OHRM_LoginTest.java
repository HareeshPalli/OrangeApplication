package com.Grid;

import java.net.MalformedURLException;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OHRM_LoginTest {
	
	@Parameters("Browser")
	
	@Test
	public void login(String browserName) throws MalformedURLException
	{
		System.out.println("The Browser Name is" +browserName);
		DesiredCapabilities cap=null;
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			cap=DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
		}
		else
			if(browserName.equalsIgnoreCase("edge"))
			{
				cap=DesiredCapabilities.edge();
				cap.setBrowserName("edge");
				cap.setPlatform(Platform.WINDOWS);
			}
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.1.14:4444/wd/hub"),cap);
		
		String ApplicationurlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		driver.get(ApplicationurlAddress);
		
        driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.id("txtUsername")).sendKeys("Hareesh");
		driver.findElement(By.id("txtPassword")).sendKeys("Hareesh143@");
		driver.findElement(By.id("btnLogin")).click();
		
        driver.findElement(By.id("welcome")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Logout")));
	
	    driver.findElement(By.linkText("Logout")).click();
	
	
	}
	

}
