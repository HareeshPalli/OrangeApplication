package ohrmApplication;




import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OHRMBaseTest.BaseTest;

public class OHRM_LoginTest extends BaseTest 
{
	@Test(priority=1)
	public void TitleValidation()
	{
		
		String Actual_OHRMTitle=driver.getTitle();
		String Expected_OHRMTitle="OrangeHRM";
		Assert.assertEquals(Actual_OHRMTitle, Expected_OHRMTitle,"Title Not Matched");
	}
	@Test(priority=2)
	public void OrangeHRMloginpanelValidation() throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\haree\\eclipse-workspace\\OrangeApplication\\Excelfiles\\OHRMScriptSheet.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		Row row=sheet.getRow(1);
		Cell cell=row.getCell(0);
		String Expected_LoginpanelTxt=cell.getStringCellValue();
		
		WebElement LoginPannel=driver.findElement(By.id("logInPanelHeading"));
		String Actual_LoginpanelTxt=LoginPannel.getText();
		cell=row.createCell(1);
		cell.setCellValue(Actual_LoginpanelTxt);
		
		logger.info(Actual_LoginpanelTxt);
		
		Assert.assertEquals(Actual_LoginpanelTxt,Expected_LoginpanelTxt,"LOginPannel not matched");
		cell=row.createCell(2);
		cell.setCellValue("Pass");
		
		FileOutputStream file1=new FileOutputStream("C:\\Users\\haree\\eclipse-workspace\\OrangeApplication\\Excelfiles\\OHRMScriptSheet.xlsx");
		workbook.write(file1);
		
	}
	@Test(priority=3)
	public void LoginTest() throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\haree\\eclipse-workspace\\OrangeApplication\\Excelfiles\\OHRMScriptSheet.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		Row row=sheet.getRow(1);
		Cell cell=row.createCell(3);
		cell.setCellValue("Hareesh");
		
		WebElement UsernameELe=driver.findElement(By.id("txtUsername"));
		UsernameELe.sendKeys("Hareesh");
		
		driver.findElement(By.id("txtPassword")).sendKeys("Hareesh143@");
		cell=row.createCell(4);
		cell.setCellValue("Hareesh143@");
		driver.findElement(By.id("btnLogin")).click();
		
		FileOutputStream file1=new FileOutputStream("C:\\Users\\haree\\eclipse-workspace\\OrangeApplication\\Excelfiles\\OHRMScriptSheet.xlsx");
		workbook.write(file1);
	}

}
