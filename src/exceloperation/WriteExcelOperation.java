package exceloperation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelOperation {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream file=new FileInputStream("C:\\Users\\haree\\eclipse-workspace\\Excel\\Excelsheet\\Hari.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		Row row=sheet.createRow(2);
		Cell cell=row.createCell(3);
		cell.setCellValue("Livetech");
		FileOutputStream file1=new FileOutputStream("C:\\Users\\haree\\eclipse-workspace\\Excel\\Excelsheet\\Hari.xlsx");
		workbook.write(file1);
	}

}
