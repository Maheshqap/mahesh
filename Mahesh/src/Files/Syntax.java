package Files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class Syntax {
public static void main(String[] args) throws Exception {

	Properties obj = new Properties();
	FileInputStream fin = new FileInputStream("C:\\Users\\QAP18\\git\\mahesh\\Mahesh\\src\\Files\\paziz.properties");
	FileOutputStream fout = new FileOutputStream("E:\\Softwares\\mxl.xlsx");
	obj.load(fin);
	
	String strURl = obj.getProperty("URL");
	String strUN = obj.getProperty("UserName");
	String strPWD = obj.getProperty("Password");
	
	System.out.println(strURl+ " "+strUN+ " "+strPWD);
	
	System.setProperty("webdriver.chrome.driver", "E:\\Selenium Softwares\\chromedriver.exe");
	ChromeDriver cd = new ChromeDriver();
	cd.get(strURl);
	
	cd.findElement(By.name("txtUserName")).sendKeys(strUN);
	cd.findElement(By.name("txtPassword")).sendKeys(strPWD);
	
	cd.findElement(By.name("Submit")).click();
	cd.findElement(By.linkText("Logout")).click();
	
	cd.close();
	cd.quit();
	
	
	
}
}
