package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase4 {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\QAP18\\Downloads\\chromedriver_win32\\chromedriver.exe");
	ChromeDriver Driver=new ChromeDriver();
	
	//TO maximize browser
			Driver.manage().window().maximize();
			//-------------------------------------
			//wait object
			WebDriverWait wait=new WebDriverWait(Driver, 60);
			
			//Open application
			Driver.get("http://apps.qaplanet.in/hrm/login.php");
			
			//Create webelement for UN,PWD,Login and clear
			WebElement objUN=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
			WebElement objPWD=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
			WebElement objLogin=Driver.findElement(By.name("Submit"));
		
			
				String sUN="qaplanet1";
				String sPWD="lab1";
			//-----------------------------------------------------
			//Clear & enter user name
			objUN.clear();	
			objUN.sendKeys(sUN);
			//Clear password and enter password
			objPWD.clear();
			objPWD.sendKeys(sPWD);
			//Click on login
			objLogin.click();
			
			Driver.switchTo().frame("rightMenu");
			
			Driver.findElement(By.xpath("//input[@value='1745']")).click();
			Thread.sleep(2000);
			Driver.findElement(By.xpath("//input[@value='1746']")).click();
			Thread.sleep(2000);
			
			Driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();
			
			Driver.switchTo().defaultContent();
			//--------------------------------------------
			//Click on Logout
			Driver.findElement(By.linkText("Logout")).click();
			//wait 2 sec
			Thread.sleep(1000);
			
			Driver.quit();
			Driver.close();
			
}
}