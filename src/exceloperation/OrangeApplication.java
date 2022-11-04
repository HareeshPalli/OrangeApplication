package exceloperation;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
	WebDriver driver;
	String ApllicationUrlAddress=("http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login");
	System.setProperty("webdriver.chrome.driver", "D:\\Jar files\\chromedriver.exe\\");
	driver=new ChromeDriver();
	driver.get(ApllicationUrlAddress);
	driver.manage().window().maximize();
	
	String actual_TitleforOrangeHRMapplication=driver.getTitle();
	String expected_TitleforOrangeHRMapplication="OrangeHRM";
	if(actual_TitleforOrangeHRMapplication.contains(expected_TitleforOrangeHRMapplication))
	{
		System.out.println("Title is Matching result is Pass");
	}
	else
	{
		System.out.println("Title is not Match -Fail");
	}
	FileInputStream file=new FileInputStream("C:\\Users\\haree\\eclipse-workspace\\Excel\\Excelsheet\\New Microsoft Excel Worksheet.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(file);
	XSSFSheet sheet=workbook.getSheet("Sheet1");
	
	Row row=sheet.getRow(1);
	Cell cell=row.getCell(0);
	String Expectedloginpanel=cell.getStringCellValue();
	
	System.out.println("Expectedloginpanel:"+Expectedloginpanel);
	
	
	WebElement LoginpannelElement=driver.findElement(By.id("logInPanelHeading"));
	String actualLoginpannelText=LoginpannelElement.getText();
	System.out.println("The Text of LoginPannel:"+actualLoginpannelText);
	
	cell=row.createCell(1);
	cell.setCellValue(actualLoginpannelText);
	System.out.println("Actualloginpanel is:"+actualLoginpannelText);
	
	cell=row.createCell(2);
	
	if(actualLoginpannelText.equals(Expectedloginpanel))
	{
		System.out.println("loginpannel name is mached-Pass");
		cell.setCellValue("pass");
	}
	else
	{
		System.out.println("loginpannel name is notmached-Fail");
		cell.setCellValue("fail");
	}
	
	
	
	
	WebElement UsernameText=driver.findElement(By.id("txtUsername"));
	UsernameText.sendKeys("Hareesh");
	cell=row.createCell(3);
	cell.setCellValue("Hareesh");
	WebElement PasswordText=driver.findElement(By.id("txtPassword"));
	PasswordText.sendKeys("Hareesh143@");
	cell=row.createCell(4);
	cell.setCellValue("Hareesh143@");
	WebElement LoginBtn=driver.findElement(By.id("btnLogin"));
	LoginBtn.click();
	
	WebElement HomepageElement=driver.findElement(By.id("menu_admin_viewAdminModule"));
	String actualHompageText=HomepageElement.getText();
	System.out.println("actual text of homepage:"+actualHompageText);
	cell=row.getCell(5);
	String	expectedTextofHomepage=cell.getStringCellValue();
	System.out.println("Expected homepage is:"+expectedTextofHomepage);
    cell =row.createCell(6);

	cell.setCellValue(actualHompageText);
    cell =row.createCell(7);
    if(actualHompageText.equals(expectedTextofHomepage))
    {
    	System.out.println("Homepage name is matched -Pass");
        cell.setCellValue("Pass");
    }
    else
    {
    	System.out.println("Homepage name is not matched-Fail");
    	 cell.setCellValue("Fail");
    }
 
    WebElement  PIMBtn=driver.findElement(By.id("menu_pim_viewPimModule"));
    PIMBtn.click();
    
    WebElement AddEmployeeBtn =driver.findElement(By.id("menu_pim_addEmployee"));
    AddEmployeeBtn.click();
    
    WebElement  AddEmployeeTxt=driver.findElement(By.xpath("//*[text()='Add Employee']"));
        String  actual_AddEmployeeTxt  =  AddEmployeeTxt.getText();
        System.out.println("Text in addemployee is:"+actual_AddEmployeeTxt);
        cell=row.getCell(8);
        String expectedTxtofAddEmployee=cell.getStringCellValue();
       System.out.println("Expected AddEmployee is:"+expectedTxtofAddEmployee);
       cell =row.createCell(9);
       cell.setCellValue(actual_AddEmployeeTxt);
       cell =row.createCell(10);
   	

        if(actual_AddEmployeeTxt.equals(expectedTxtofAddEmployee))
        {
        	System.out.println("Add employee name is matched-Pass");
        	cell.setCellValue("Pass");
        }
        else
        {
        	System.out.println("Add employee name is notmatched-fail");
        	cell.setCellValue("fail");
        }
        
     WebElement  EmployeenameTxt=driver.findElement(By.id("firstName"));
      EmployeenameTxt.sendKeys("Hareesh");
      System.out.println("First name of employee:"+EmployeenameTxt);
      
      cell=row.createCell(11);
      cell.setCellValue("Hareesh");
      
      WebElement    MiddlenameTxt =driver.findElement(By.id("middleName"));
      MiddlenameTxt.sendKeys("Kumar");
      cell=row.createCell(12);
      cell.setCellValue("Kumar");
      
      WebElement    LastnameTxt =driver.findElement(By.id("lastName"));
      LastnameTxt.sendKeys("Palli");
      cell=row.createCell(13);
      cell.setCellValue("Palli");
      
      WebElement Employeeofid=driver.findElement(By.id("employeeId"));
      String ExpectedtextofEmployeiid = Employeeofid.getAttribute("value");
      System.out.println("Value of employeid"+ExpectedtextofEmployeiid);
      cell=row.createCell(14);
      cell.setCellValue(ExpectedtextofEmployeiid);
      
      
     WebElement  SaveBtn =driver.findElement(By.id("btnSave"));
     SaveBtn.click();
     
     WebElement personaldetailsTxt = driver.findElement(By.xpath("//*[text()='Personal Details']"));
     String actual_personaldetailsTxt=personaldetailsTxt.getText();
     System.out.println("Actualtext of personaldetailspage:"+actual_personaldetailsTxt);
     cell=row.getCell(15);
     String ExpectedTxtofpersonaldetailspage=cell.getStringCellValue();
     cell=row.createCell(16);
     cell.setCellValue(actual_personaldetailsTxt);
     cell=row.createCell(17);
     
     if(actual_personaldetailsTxt.equals(ExpectedTxtofpersonaldetailspage))
     {
    	 System.out.println("actual text is matching testcase is-Pass");
         cell.setCellValue("Pass");
     }
     else
     {
    	 System.out.println("actual text is notmatching testcase is-Fail");
    	 cell.setCellValue("Fail");
     }
     
   WebElement firstnameTxt= driver.findElement(By.id("personal_txtEmpFirstName"));
   String actual_firstnameofTxt=firstnameTxt.getAttribute("value");
   String Expected_firstname="Hareesh";
   
   System.out.println("name of actualtxt1:"+actual_firstnameofTxt);
   cell=row.createCell(18);
   cell.setCellValue(actual_firstnameofTxt);
   
    if(actual_firstnameofTxt.equals(Expected_firstname))
   {
	   System.out.println("actual text is matching testcase is-Pass");
	  // cell.setCellValue("Pass");
   }
   else
   {
	   System.out.println("actual text isnot matching testcase is-Fail");
	  // cell.setCellValue("Fail");
	   
   }
   
   WebElement MiddlenameofTxt =driver.findElement(By.id("personal_txtEmpMiddleName"));
   String actual_textofmiddlename=MiddlenameofTxt.getAttribute("value");
   System.out.println("name of middlenametxt:"+actual_textofmiddlename);
   String Expectednameofmiddlename="Kumar";
   cell=row.createCell(19);
   cell.setCellValue(Expectednameofmiddlename);
   if(actual_textofmiddlename.equals(Expectednameofmiddlename))
   {
	   System.out.println("actualname is matching testcase is Pass");
   }
   else
   {
	   System.out.println("actualname is notmatching testcase is Fail");
   }
   
   
   WebElement LastnameofTxt =driver.findElement(By.id("personal_txtEmpLastName"));
   String actual_textofLastname=LastnameofTxt.getAttribute("value");
   System.out.println("name of Lastnametxt:"+actual_textofLastname);
   String ExpectednameofLastname="Palli";
  cell= row.createCell(20);
  cell.setCellValue(ExpectednameofLastname);
   if(actual_textofLastname.equals(ExpectednameofLastname))
   {
	   System.out.println("actualname is matching testcase is Pass");
   }
   else
   {
	   System.out.println("actualname is notmatching testcase is Fail");
   }
   
   WebElement txtEmployeeofid=driver.findElement(By.id("personal_txtEmployeeId"));
   String actualtextofEmployeeid=txtEmployeeofid.getAttribute("value");
   System.out.println("Value of employeid:"+ExpectedtextofEmployeiid);
   System.out.println("value of actual id:"+actualtextofEmployeeid);
   cell=row.createCell(21);
   cell.setCellValue(actualtextofEmployeeid);
   cell=row.createCell(22);
  
   if(actualtextofEmployeeid.equals(ExpectedtextofEmployeiid))
   {
	   System.out.println("actual id is matching testcase is Pass");
	   cell.setCellValue("Pass");
   }
   else
   {
	   System.out.println("actual id notmatching testcaseis Fail");
	   cell.setCellValue("Fail");

   }
   
  driver.findElement(By.id("welcome")).click();
   Thread.sleep(2000);
  driver.findElement(By.linkText("Logout")).click();
     
    
   
    FileOutputStream file1=new FileOutputStream("C:\\Users\\haree\\eclipse-workspace\\Excel\\Excelsheet\\New Microsoft Excel Worksheet.xlsx");
	workbook.write(file1);


	driver.close();
	}

}
