package Files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Ex1 {
	public static void main(String[] args) throws Exception {
		
	
	//FileInputStream fin = new FileInputStream("D://Mahesh.xlsx");
	FileInputStream fin = new FileInputStream("D://Mahesh1.xlsx");
	XSSFWorkbook xss = new XSSFWorkbook(fin);
	XSSFSheet sh = xss.getSheetAt(0);
	System.out.println(sh.getRow(0).getCell(0).getStringCellValue());
	
	
	
	xss.close();
	fin.close();
	
	}
	
	
}
