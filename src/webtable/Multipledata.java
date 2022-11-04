package webtable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Multipledata {
	WebDriver driver;
	@Test
	public void loginapplication() throws IOException, InterruptedException
	{
		
		String ApllicationUrlAddress=("http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login");
		System.setProperty("webdriver.chrome.driver", "D:\\Jar files\\chromedriver.exe\\");
		driver=new ChromeDriver();
		driver.get(ApllicationUrlAddress);
		driver.manage().window().maximize();
		
		FileInputStream file=new FileInputStream("C:\\Users\\haree\\eclipse-workspace\\Excel\\Excelsheet\\Multidata.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		Row row=sheet.getRow(0);
		
		WebElement UsernameText=driver.findElement(By.id("txtUsername"));
		Cell cell=row.getCell(0);
		String username=cell.getStringCellValue();
		System.out.println("Print data:"+username);
		UsernameText.sendKeys(username);
		
		WebElement PasswordText=driver.findElement(By.id("txtPassword"));
	    cell=row.getCell(1);
		String password=cell.getStringCellValue();
		System.out.println("text of pass:"+password);
		PasswordText.sendKeys(password);
		
		
		WebElement LoginBtn=driver.findElement(By.id("btnLogin"));
		LoginBtn.click();
		
	    WebElement  PIMBtn=driver.findElement(By.id("menu_pim_viewPimModule"));
		PIMBtn.click();
		    
		WebElement AddEmployeeBtn =driver.findElement(By.id("menu_pim_addEmployee"));
		AddEmployeeBtn.click();
		
		 int Rows=sheet.getLastRowNum();
		 for(int i=1;i<Rows;i++){
		
		  WebElement  EmployeenameTxt=driver.findElement(By.id("firstName"));
		  row=sheet.getRow(i);
		  cell=row.getCell(0);
		  String Firstname= cell.getStringCellValue();
		  System.out.println("Firstname of addaEmployee:" +Firstname);
		  EmployeenameTxt.clear();
	      EmployeenameTxt.sendKeys(Firstname);
	      
	      WebElement MiddlenameTxt =driver.findElement(By.id("middleName"));
	      
		  cell=row.getCell(1);
		  String Middlename= cell.getStringCellValue();
		  System.out.println("Middlename of addaEmployee:" +Middlename);
		  MiddlenameTxt.clear();
		  MiddlenameTxt.sendKeys(Middlename);
	      
	      WebElement   LastnameTxt =driver.findElement(By.id("lastName"));
	      cell=row.getCell(2);
		  String Lastname= cell.getStringCellValue();
		  System.out.println("Lastname of addaEmployee:" +Lastname);
		  LastnameTxt.clear();
		  LastnameTxt.sendKeys(Lastname);
		  
		  WebElement Employeeofid=driver.findElement(By.id("employeeId"));
		  String ExpectedtextofEmployeiid = Employeeofid.getAttribute("value");
		  System.out.println("Value of employeid"+ExpectedtextofEmployeiid);
		  
		  Runtime.getRuntime().exec("./AutoItScripts/Photoimg6.exe");
		  Thread.sleep(3000);
	
	    WebElement  SaveBtn =driver.findElement(By.id("btnSave"));
	     SaveBtn.click();
	     
	    driver.navigate().back();
	    
	      
	      }
		
	driver.close();
		
		
		
		
		
	}

}
