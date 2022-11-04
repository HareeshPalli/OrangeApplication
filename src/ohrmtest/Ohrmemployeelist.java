package ohrmtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

public class Ohrmemployeelist extends OHRM_Application  {

	@Test(priority=4)
	public void Employeelist()
	{			
		driver.navigate().back();

        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
	}
	
	

}
