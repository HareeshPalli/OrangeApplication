package ohrmtest;




import java.io.IOException;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OHRM_Application {
	WebDriver driver;
	@BeforeTest
	public void LaunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver","D://Jar files//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@AfterTest
	public void CloseBrowser()
	{
		driver.close();
	}
	@Test(priority=1)
	public void OHRM_LoginApplication()
	{
		driver.findElement(By.id("txtUsername")).sendKeys("Hareesh");
		driver.findElement(By.id("txtPassword")).sendKeys("Hareesh143@");
		driver.findElement(By.id("btnLogin")).click();
	
	}
	@Test(priority=2)
	public void hrmApplication_Pim()
	{
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.id("menu_pim_addEmployee")).click();
	
		
	}
	@Test(priority=3)
	public void setAddElployee() throws IOException, InterruptedException
	{
		driver.findElement(By.id("firstName")).sendKeys("Hareesh");
		Actions action=new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys("Kumar");
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys("Palli");
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.ENTER).build().perform();
		
		Runtime.getRuntime().exec("./AutoItScripts//Photograph.exe");
		
	
		driver.findElement(By.id("btnSave")).click();
		
      }
	

	public void LApplication_Logout()
	{
		/*driver.findElement(By.id("welcome")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Logout")));
	
	    driver.findElement(By.linkText("Logout")).click();*/
	    
	}
	

			
		
		
	}


	

