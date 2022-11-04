package Redifapplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Application_launch {
	WebDriver driver;
	@BeforeTest
	public void performdata()
	
	{  
		
		String ApplicationurlAddress="https://register.rediff.com/register/register.php?FormName=user_details";
		System.setProperty("webdriver.chrome.driver","D://Jar files//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationurlAddress);
		
	}
	@AfterTest
	public void Applicationclose()
	{
		driver.close();
	}
	@Test
	public void perform()
	{
		WebElement FullnameELe=driver.findElement(By.xpath("/html/body/center/form/div/table[2]/tbody/tr[3]/td[3]/input"));
		FullnameELe.sendKeys("Palli Hareesh");
	}

}
