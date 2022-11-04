package webtable;




import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CapturingtableData {
	WebDriver driver;
	
	@BeforeTest
	public void applicationLaunch() 
	{
		String ApplicationUrlAddress="https://www.timeanddate.com/worldclock/";
		System.setProperty("webdriver.chrome.driver","//D://Jar files//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationUrlAddress);
		driver.manage().window().maximize();
	}
	@AfterTest
	public void applicationclose()
	{
		driver.close();
	}
	
	
	@Test
	public void CapturingFirstrowandlastcell() throws IOException
	{
		//firstrow firstCell
		///html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]/a
		//Lastrow lastcell
		///html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[8]
		String xpathpart1="/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[";
		String xpathpart2="]/td[";
		String xpathpart3="]";
		for(int i=1;i<=36;i++)
		{
			FileInputStream file=new FileInputStream("C:\\Users\\haree\\eclipse-workspace\\Excel\\Excelsheet\\time.xlsx");
		    XSSFWorkbook workbook=new XSSFWorkbook(file);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			Row row=sheet.createRow(i-1);
			
			for(int j=1;j<=8;j++)
			{
			
			//WebElement	webtableElement=driver.findElement(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+i+"]/td["+j+"]"));
			WebElement	webtableElement=driver.findElement(By.xpath(xpathpart1+i+xpathpart2+j+xpathpart3));

			String webTableData=webtableElement.getText();
			Cell cell=row.createCell(j-1);
			cell.setCellValue(webTableData);
			
			FileOutputStream file1=new FileOutputStream("C:\\Users\\haree\\eclipse-workspace\\Excel\\Excelsheet\\time.xlsx");
			workbook.write(file1);
			
			System.out.print(webTableData  +"");
			}
			System.out.println();
		}
		
		
	}

}
