package Files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachiPOIEx {
public static void main(String[] args) throws Exception {
	
	//--------------------WRITE DATA INTO FILE--------------------------------//
	FileOutputStream fout = new FileOutputStream("D:/M.xls");
	XSSFWorkbook wb = new XSSFWorkbook();
	XSSFSheet sheet = wb.createSheet("QaPlanet");
	int row = 0;
	int column = 0;
	XSSFRow r1 = sheet.createRow(row);
	r1.createCell(column).setCellValue("Mobile");
	column++;
	r1.createCell(column).setCellValue("Price");
	row++;
	column--;
	XSSFRow r2 = sheet.createRow(row);
	r2.createCell(column).setCellValue("Samsung");
	column++;
	r2.createCell(column).setCellValue("1000000");
	wb.write(fout);
	System.out.println("File Data Entered");
	System.out.println("---------------------------------------------------");
	fout.close();
	wb.close();
	InputStream fin = new FileInputStream("D:/M.xls");
	XSSFWorkbook xwb = new XSSFWorkbook(fin);
	XSSFSheet xsh = xwb.getSheetAt(0);
	XSSFRow Row;
	XSSFCell cell;
	//---------------------------------------//
	Iterator<Row> itR =xsh.rowIterator();
	while(itR.hasNext())
	{
		Row = (XSSFRow)itR.next();
		Iterator<Cell> itC = Row.cellIterator();
		while(itC.hasNext())
		{
			cell = (XSSFCell)itC.next();
			System.out.println(cell.getStringCellValue()+ "");
			System.out.println();
		}
	}
	xwb.close();
	fin.close();
	}
}
