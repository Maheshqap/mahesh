import java.io.File;
//import java.io.IOException;

public class PractiseExcel {

	public static void main(String[] args) throws Exception {
		File f1=new File("E:\\Softwares\\my.xls");
		if(!(f1.exists()))
		{
			f1.createNewFile();
			System.out.println("File created");
		}
		if(f1.exists())
		{
			System.out.println("File created successully"
					+ "");
		}
		System.out.println(f1.getAbsolutePath());

	}

}
