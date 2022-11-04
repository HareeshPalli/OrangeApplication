package ohrmtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ExcelOpearation extends Ohrmemployeelist {
	

	@Test(priority=5)
	public void employeeList() throws IOException
	{
	 
        // /html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[50]/td[4]

		//	/html/body/div[1]/div[3]/div[2]/div/form/div[4]
		// /html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[43]/td[8]

		
		for(int i=1;i<=50;i++)
		{	
			FileInputStream file=new FileInputStream("C:\\Users\\haree\\eclipse-workspace\\Excel\\Excelsheet\\Hari.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(file);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			Row row=sheet.createRow(i);
			driver.findElement(By.linkText("Next")).click();

			for(int j=1;j<=4;j++)
			{
				WebElement data=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr["+i+"]/td["+j+"]"));
				String Webtabledata=data.getText();
				Cell cell=row.createCell(j);
				cell.setCellValue(Webtabledata);
				
				System.out.print(Webtabledata +"");
				 
				FileOutputStream file1=new FileOutputStream("C:\\Users\\haree\\eclipse-workspace\\Excel\\Excelsheet\\Hari.xlsx");
				 workbook.write(file1);
					}
		System.out.println();
		
		}
		
	
		
	

	}

}
