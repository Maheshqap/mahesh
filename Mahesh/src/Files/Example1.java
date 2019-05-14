package Files;

import java.io.File;
import java.io.IOException;
public class Example1 {
public static void main(String[] args) throws IOException {
	File xl= new File("E:\\Softwares\\mxl1.xls");
	File np = new File("E:\\Softwares\\mwp1.txt");
	
	if(!(xl.exists() && (np.exists())))
	{
	xl.createNewFile();	
	np.createNewFile();
	}
	System.out.println("Files Created");
	if(xl.exists() && np.exists())
	{
		System.out.println("Excel and Notepad are Created");
	}
	else
	{
		System.out.println("Files not found");
	}
	System.out.println(xl.getAbsolutePath());
	System.out.println(np.getAbsolutePath());
	// Delete files
//	xl.delete();
//	np.delete();
}
}
