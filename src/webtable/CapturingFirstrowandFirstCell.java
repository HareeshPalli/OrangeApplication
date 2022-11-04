package webtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CapturingFirstrowandFirstCell {
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
	public void CapturingFirstrowandFirstcell()
	{
		///html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]/a
		//html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[1]/a
		String part1="/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[";
		String part2="]/td[1]";
		for(int i=1;i<=36;i++)
		{
			
			//WebElement webtableEle=driver.findElement(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+i+"]/td[1]/a"));
			WebElement webtableEle=driver.findElement(By.xpath(part1+i+part2));

			String webtableData=webtableEle.getText();
			System.out.println(webtableData);
			
		}
		
		
	}

}
