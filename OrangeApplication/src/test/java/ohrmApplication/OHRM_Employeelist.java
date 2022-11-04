package ohrmApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class OHRM_Employeelist extends OHRMAddEmployeeTest {
	@Test(priority=9)
	public void employeemultipledata() throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\haree\\eclipse-workspace\\OrangeApplication\\Excelfiles\\OHRMScriptSheet.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		
		int Rows=sheet.getLastRowNum();
		for(int i=4;i<Rows;i++) {
			
		Row row=sheet.getRow(i);
		WebElement Firstname=driver.findElement(By.id("firstName"));
		Cell cell=row.getCell(0);
		String EmployeeFirstname=cell.getStringCellValue();
		Firstname.clear();
		Firstname.sendKeys(EmployeeFirstname);
		logger.info(EmployeeFirstname);
		
		WebElement Mddlename=driver.findElement(By.id("middleName"));
		cell=row.getCell(1);
		String Employemddlename=cell.getStringCellValue();
		Mddlename.clear();
		Mddlename.sendKeys(Employemddlename);
		logger.info(Employemddlename);
		
		WebElement Lastname=driver.findElement(By.id("lastName"));
		cell=row.getCell(2);
		String Employelastname=cell.getStringCellValue();
		Lastname.clear();
		Lastname.sendKeys(Employelastname);
		logger.info(Employelastname);
		
		WebElement Employeeid=driver.findElement(By.id("employeeId"));
		String employeeid=Employeeid.getAttribute("value");
		employeeid.toString();
		logger.info(employeeid);
	
		driver.findElement(By.id("btnSave")).click();
		
		driver.navigate().back();
		
	}
		
		
	}
	@Test(priority=10)
	public void saveEmployeelist() throws IOException, InterruptedException
	{
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		
		WebElement pagesele=driver.findElement(By.className("top"));
		List<WebElement>pages=pagesele.findElements(By.tagName("a"));
		int Links=pages.size();
		
		
	    List<WebElement>NextbtnLinks=pagesele.findElements(By.className("tiptip"));
	    int NxtBtnlinks=NextbtnLinks.size();
		int NextButtonsSize=Links-NxtBtnlinks;
		System.out.println("Links of Btns:"+NextButtonsSize);
	  
         for(int s=1;s<=NextButtonsSize;s++) 
           {
			   WebElement EmployelistTable=driver.findElement(By.id("frmList_ohrmListComponent"));
			   List<WebElement>Rows=EmployelistTable.findElements(By.tagName("tr"));
			   int rowscount =Rows.size();
		       System.out.println("Total no fo rows" +rowscount);
			    
		       FileInputStream file=new FileInputStream("C:\\Users\\haree\\eclipse-workspace\\OrangeApplication\\Excelfiles\\Readshhet.xlsx");
			   XSSFWorkbook workbook=new XSSFWorkbook(file);
			   XSSFSheet sheet=workbook.getSheet("Sheet"+s);
			    
			    
		    for(int i=1;i<rowscount;i++)
		   {
			Row row=sheet.createRow(i);
			List<WebElement> cells=Rows.get(i).findElements(By.tagName("td"));
			int cellscount=cells.size();
			
			for(int j=1;j<cellscount;j++)
			{
				String cellsdata=cells.get(j).getText();
			    System.out.print(cellsdata);

			    Cell cell=row.createCell(j);
				cell.setCellValue(cellsdata);
			}
				
			System.out.println();

			FileOutputStream file1=new FileOutputStream("C:\\Users\\haree\\eclipse-workspace\\OrangeApplication\\Excelfiles\\Readshhet.xlsx");
				workbook.write(file1);
		    }
		   Thread.sleep(3000);
	
		   driver.findElement(By.linkText("Next")).click();
	
		}
	
	
	}

}
