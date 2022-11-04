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
import org.openqa.selenium.support.ui.Select;

public class DropdownLanguages {

	public static void main(String[] args) throws IOException {
	
		
		System.setProperty("webdriver.chrome.driver", "D:\\Jar files\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.osmania.ac.in/");
		driver.manage().window().maximize();
		WebElement selectLanguageTxt=driver.findElement(By.id("gtranslate_selector"));
		List<WebElement> DropdownLanguages=selectLanguageTxt.findElements(By.tagName("option"));
		
		int DropdownLanguageslist=DropdownLanguages.size();
		System.out.println(+DropdownLanguageslist);
		
		FileInputStream file=new FileInputStream("C:\\Users\\haree\\eclipse-workspace\\Excel\\Excelsheet\\Hari.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		for(int i=0;i<DropdownLanguageslist;i++) {
		String	DropdownLanguagesList=DropdownLanguages.get(i).getText();
			System.out.println(i+""+DropdownLanguagesList);
			Select selection=new Select(selectLanguageTxt);
			//selection.selectByIndex(i);
			//selection.selectByValue("en|ur");
			selection.selectByValue(DropdownLanguages.get(i).getAttribute("value"));
			
			//selection.selectByVisibleText(DropdownLanguages.get(i).getText());
	        Row row=sheet.createRow(i);
			Cell cell=row.createCell(0);
			cell.setCellValue(DropdownLanguagesList);
			FileOutputStream file1=new FileOutputStream("C:\\Users\\haree\\eclipse-workspace\\Excel\\Excelsheet\\Hari.xlsx");
			workbook.write(file1);
		
		}
	
	}

}
