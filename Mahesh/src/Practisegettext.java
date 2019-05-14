import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;

/*import java.io.File;
import java.io.IOException;

import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import jxl.Workbook;*/

public class Practisegettext {

	public static void main(String[] args) throws Exception  {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		ChromeDriver drive=new ChromeDriver();
		Actions A=new Actions(drive);
		drive.get("https://www.flipkart.com/");
		Thread.sleep(2000);
			drive.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
			WebElement drop= 
			
	
	

	}

}
