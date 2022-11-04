package webtable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

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



public class Tabledata {
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		String ApplicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		System.setProperty("webdriver.chrome.driver","D://Jar files//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationUrlAddress);
		driver.manage().window().maximize();
	}
	@AfterTest
	public void teardown()
	{
	 driver.close();
	}
	@Test(priority=1)
	public void loginset () 
	{
		driver.findElement(By.id("txtUsername")).sendKeys("Hareesh");
		driver.findElement(By.id("txtPassword")).sendKeys("Hareesh143@");
		driver.findElement(By.id("btnLogin")).click();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.id("menu_pim_viewPimModule")).click();

		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
	}
	@Test(priority=2)
	public void Capturingtabledata() throws IOException, InterruptedException
	{
	
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
			    
			    FileInputStream file=new FileInputStream("C:\\Users\\haree\\eclipse-workspace\\Excel\\Excelsheet\\Hari.xlsx");
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
			FileOutputStream file1=new FileOutputStream("C:\\Users\\haree\\eclipse-workspace\\Excel\\Excelsheet\\Hari.xlsx");
			workbook.write(file1);
		    }
		   Thread.sleep(3000);
	
		   driver.findElement(By.linkText("Next")).click();
	
		}
	}
}
