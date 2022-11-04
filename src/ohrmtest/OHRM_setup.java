package ohrmtest;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OHRM_setup {
	WebDriver driver;
	@BeforeTest
	public void LaunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver","D://Jar files//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		
	}

	@Test(priority=1)
	public void OHRM_LoginApplication()
	{
		driver.findElement(By.id("txtUsername")).sendKeys("Hareesh");
		driver.findElement(By.id("txtPassword")).sendKeys("Hareesh143@");
		driver.findElement(By.id("btnLogin")).click();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//driver.findElement(By.id("menu_pim_viewPimModule")).click();

		//driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		
		
		//driver.findElement(By.linkText("Next")).click();
		

}

}
