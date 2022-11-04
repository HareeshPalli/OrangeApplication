package webtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ApplicationLaunch {
WebDriver driver;
	
	@BeforeTest
	public void applicationLaunch()
	{
		String ApplicationUrlAddress="https://www.timeanddate.com/worldclock/";
		System.setProperty("webdriver.chrome.driver","//D://Jar files//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationUrlAddress);
		driver.manage().window().maximize();
	}
	@AfterTest
	public void applicationclose()
	{
		driver.close();
	}
	@Test
	public void draft()
	{
		
	}

}
