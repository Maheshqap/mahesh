package Files;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ReadDataFromExcel {
public static void main(String[] args) throws Exception {
	File f1 = new File("E:\\Softwares\\mxl.xls");
	WritableWorkbook wwb=Workbook.createWorkbook(f1);
	WritableSheet ws=wwb.createSheet("HRM", 0);
	WritableSheet ws1=wwb.createSheet("RES", 1);
	
	//Writing in Excel
	Label l=new Label(0,0,"Username");
	Label r1=new Label(0,1,"qaplanet1");
	Label l1=new Label(1,0,"password");	
	Label r2=new Label(1,1,"user1");
	Label l2 = new Label(2,0, "Browser");
	Label r3 = new Label(2,1,  "Chrome");
	Label lw = new Label(3,0, "URL");
	Label le= new Label(3, 1, "http://apps.qaplanet.in/hrm/login.php");
	
	ws.addCell(l);
	ws.addCell(l1);
	ws.addCell(r1);
	ws.addCell(r2);
	ws.addCell(l2);
	ws.addCell(r3);
	ws.addCell(lw);
	ws.addCell(le);
	wwb.write();
	wwb.close();
	//--------------------------------------------------
	
	//Read data from Excel
	Workbook wb = Workbook.getWorkbook(f1);
	Sheet s1 = wb.getSheet(0);
	System.out.println("Through Readable");
	System.out.println(s1.getCell(3, 0).getContents());
	System.out.println(s1.getCell(3, 1).getContents());
	System.out.println("Through Readable");
	System.out.println("------------------------------------------------------------");	
	//Reading Data from Excel
	System.out.print(ws.getCell(0, 0).getContents()+"  |  ");
	System.out.println(ws.getCell(0, 1).getContents());
	System.out.print(ws.getCell(1, 0).getContents()+"  |  ");
	System.out.println(ws.getCell(1, 1).getContents());
	System.out.print(ws.getCell(2, 0).getContents()+"   |  ");
	System.out.println(ws.getCell(2, 1).getContents());
}
}
