package keyboardOperation;


import org.openqa.selenium.By;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Youtube_search {
	WebDriver driver;

	@BeforeTest
	public void applicationLaunch()
	{
	
		
		String ApplicationurlAddress="https://Youtube.com";
		System.setProperty("webdriver.chrome.driver","D://Jar files//chromedriver.exe");
		driver=new ChromeDriver();
        driver.get(ApplicationurlAddress);
	}

		
	
	@Test
	public void Seach() throws InterruptedException
	{
		WebElement Searchele=driver.findElement(By.name("search_query"));
		Searchele.sendKeys("Telugu Songs");
		
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(2000);
	
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.ENTER).build().perform();
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
	

}
