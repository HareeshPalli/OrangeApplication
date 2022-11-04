package webtable;

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

public class WebTableData extends ApplicationLaunch {
	@Test
	public void CapturingwebtableData() throws IOException
	{
		// /html/body/div[5]/section[1]/div/section/div[1]/div/table
	WebElement webTable=driver.findElement(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table"));
	List<WebElement> rows=webTable.findElements(By.tagName("tr"));
    int	rowscount=rows.size();
    System.out.println("Total no of Rows:" +rowscount);
    
    FileInputStream file=new FileInputStream("C:\\Users\\haree\\eclipse-workspace\\Excel\\Excelsheet\\time.xlsx");
    XSSFWorkbook workbook=new XSSFWorkbook(file);
	XSSFSheet sheet=workbook.getSheet("Sheet1");
	
	  for(int i=0;i<rowscount;i++)
	 {
		  Row row=sheet.createRow(i);
		 List<WebElement> cells=rows.get(i).findElements(By.tagName("td"));
		
		 int cellscount=cells.size();
		
		
		for(int j=0;j<cellscount;j++) {
			String data=cells.get(j).getText();
			System.out.print(data+ "");
		  
			Cell cell=row.createCell(j);	
		    cell.setCellValue(data);
		
		}
		
		System.out.println();
		FileOutputStream file1=new FileOutputStream("C:\\Users\\haree\\eclipse-workspace\\Excel\\Excelsheet\\time.xlsx");
		workbook.write(file1);
		 
		
	 }
		
	}

}
