package ohrmApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class OHRMAddEmployeeTest extends OHRM_LoginTest {
	
	@Test(priority=4)
	public void HomepagePimmenuValidation() throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\haree\\eclipse-workspace\\OrangeApplication\\Excelfiles\\OHRMScriptSheet.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		Row row=sheet.getRow(1);
		
		Cell cell=row.getCell(5);
		String ExpectedPimText=cell.getStringCellValue();
		
		WebElement PimmenuElement=driver.findElement(By.id("menu_pim_viewPimModule"));
		String ActualPimText=PimmenuElement.getText();
		
		logger.info(ActualPimText);
		
		cell=row.createCell(6);
		cell.setCellValue(ActualPimText);
		 
		cell=row.createCell(7);
		Assert.assertEquals(ExpectedPimText, ActualPimText);
	    cell.setCellValue("Pass");
	    
	    PimmenuElement.click();
	    
	   
	 FileOutputStream file1=new FileOutputStream("C:\\Users\\haree\\eclipse-workspace\\OrangeApplication\\Excelfiles\\OHRMScriptSheet.xlsx");
		workbook.write(file1);
	}
	@Test(priority=5)
	public void Addemployeenamevalidation() throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\haree\\eclipse-workspace\\OrangeApplication\\Excelfiles\\OHRMScriptSheet.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		Row row=sheet.getRow(1);
		Cell cell=row.getCell(8);
		String Expected_addemployeetxt=cell.getStringCellValue();
		
		WebElement Addemployeeele=driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/ul/li[3]/a"));
	    String Actual_addemployeetxt=Addemployeeele.getText();
        logger.info(Actual_addemployeetxt);
        cell=row.createCell(9);
		cell.setCellValue(Actual_addemployeetxt);
		cell=row.createCell(10);
		
       // Assert.assertEquals(Expected_addemployeetxt, Actual_addemployeetxt);
		cell.setCellValue("Pass");
		
		Addemployeeele.click();
		  
		FileOutputStream file1=new FileOutputStream("C:\\Users\\haree\\eclipse-workspace\\OrangeApplication\\Excelfiles\\OHRMScriptSheet.xlsx");
			workbook.write(file1);
	}
	@Test(priority=6)
	public void EmployeeDetails() throws IOException
	
	{
		FileInputStream file=new FileInputStream("C:\\Users\\haree\\eclipse-workspace\\OrangeApplication\\Excelfiles\\OHRMScriptSheet.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		Row row=sheet.getRow(1);
		
	    WebElement FistnameELe=driver.findElement(By.id("firstName"));
		FistnameELe.sendKeys("Hareesh");
		Cell cell=row.createCell(11);
		cell.setCellValue("Hareesh");
		
		driver.findElement(By.id("middleName")).sendKeys("Kumar");
		cell=row.createCell(12);
		cell.setCellValue("Kumar");
		
		driver.findElement(By.id("lastName")).sendKeys("Palli");
		cell=row.createCell(13);
		cell.setCellValue("Palli");
		
		WebElement Employyeidele=driver.findElement(By.id("employeeId"));
		 String Expected_Employeeid=Employyeidele.getAttribute("value");
		 cell=row.createCell(14);
		 cell.setCellValue(Expected_Employeeid);
		
		 logger.info(Expected_Employeeid);
		 
		 driver.findElement(By.id("btnSave")).click();
		 
		 
	
		
		FileOutputStream file1=new FileOutputStream("C:\\Users\\haree\\eclipse-workspace\\OrangeApplication\\Excelfiles\\OHRMScriptSheet.xlsx");
			workbook.write(file1);
	}
	@Test(priority=7)
	public void PersonaldetailsValidation() throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\haree\\eclipse-workspace\\OrangeApplication\\Excelfiles\\OHRMScriptSheet.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		Row row=sheet.getRow(1);
		Cell cell=row.getCell(15);
		String Expected_PersonaldetailsText=cell.getStringCellValue();
		
		WebElement personaldetailsele=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/h1"));
		String Actual_PersonaldetaiText=personaldetailsele.getText();
		cell=row.createCell(16);
		cell.setCellValue(Actual_PersonaldetaiText);
		
		logger.info(Actual_PersonaldetaiText);
		
		cell=row.createCell(17);
		cell.setCellValue("Pass");
		

		FileOutputStream file1=new FileOutputStream("C:\\Users\\haree\\eclipse-workspace\\OrangeApplication\\Excelfiles\\OHRMScriptSheet.xlsx");
			workbook.write(file1);
		
	}
	@Test(priority=8)
	public void Employeedetailsvalidation() throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\haree\\eclipse-workspace\\OrangeApplication\\Excelfiles\\OHRMScriptSheet.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		Row row=sheet.getRow(1);
		
		WebElement Firstnameele=driver.findElement(By.id("personal_txtEmpFirstName"));
		String Actual_FirstnameText=Firstnameele.getAttribute("value");
		String Expected_Firstname="Hareesh";
		
		logger.info(Actual_FirstnameText);
		
		Cell cell=row.createCell(18);
		cell.setCellValue(Actual_FirstnameText);
		
		WebElement Middlenameele=driver.findElement(By.id("personal_txtEmpMiddleName"));
		String Actual_Middlenametxt=Middlenameele.getAttribute("value");
		String Expected_Middlename="Kumar";
		logger.info(Actual_Middlenametxt);
		cell=row.createCell(19);
		cell.setCellValue(Actual_Middlenametxt);
		
		WebElement Lastnameele=driver.findElement(By.id("personal_txtEmpLastName"));
		String Actual_Lastname=Lastnameele.getAttribute("value");
		String Expected_Lastname="Palli";
		logger.info(Actual_Lastname);
		cell=row.createCell(20);
		cell.setCellValue(Actual_Lastname);
		
		WebElement Employeeidele=driver.findElement(By.id("personal_txtEmployeeId"));
		String Actual_employeeid=Employeeidele.getAttribute("value");
		cell=row.createCell(21);
		cell.setCellValue(Actual_employeeid);
		
		logger.info(Actual_employeeid);
		
		cell=row.createCell(22);
		cell.setCellValue("Pass");

		FileOutputStream file1=new FileOutputStream("C:\\Users\\haree\\eclipse-workspace\\OrangeApplication\\Excelfiles\\OHRMScriptSheet.xlsx");
		workbook.write(file1);
		
		driver.navigate().back();
	}
	
	

}
