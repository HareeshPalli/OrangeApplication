package webPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.BaseTest.TestBase;

public class LogInPage extends TestBase
{
	public LogInPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="txtUsername")
	WebElement UserName;
	
	@FindBy(name="txtPassword")
	WebElement Password;
	
	@FindBy(className="button")
	WebElement logInButton;
	
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div/img")
	WebElement OrangeHRMImage;
	
	@FindBy(id="welcome")
	WebElement WelcomeAdmin;
	
	@FindBy(linkText="Logout")
	WebElement logoutButton;
	

public void login(String userName,String password)
{
	UserName.sendKeys(userName);
	Password.sendKeys(password);
	logInButton.click();
}
public void image()
{
	boolean flag=OrangeHRMImage.isDisplayed();
	Assert.assertTrue(flag,"OrangeHRM Logo not Found");
}
public void logInPageTitleValidation()
{
	String actual_LogInPageTitle=driver.getTitle();
	String expected_Title="OrangeHRM";
	Assert.assertEquals(actual_LogInPageTitle, expected_Title,"Title Not Matched");
}
public void loginpageurlAddressValidation()
{
	String actual_loginPageurlAddress=driver.getCurrentUrl();
	String expected_loginPageurlAddress="orangehrm-4.2.0.1";
	Assert.assertTrue(actual_loginPageurlAddress.contains(expected_loginPageurlAddress));
}
public void logout()
{
	WelcomeAdmin.click();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
	
	logoutButton.click();
}


}
