package radiobutton;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public class BaseTest1 {
	public WebDriver driver;
	public Logger logger;
	@BeforeTest
	public void setup()
	{
		PropertyConfigurator.configure("Log4j.properties");
		logger=Logger.getLogger(BaseTest1.class);
		
		String ApplicationUrlAddress=("https://echoecho.com/htmlforms10.htm");
		System.setProperty("webdriver.chrome.driver", "//D://Jar files//chromedriver.exe");
		driver=new ChromeDriver();
		logger.info("Chrome browser Launch Successfull");
		driver.get(ApplicationUrlAddress);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}

}
