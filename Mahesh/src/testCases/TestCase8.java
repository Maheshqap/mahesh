
package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase8 {
	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\QAP18\\Downloads\\chromedriver_win32\\chromedriver.exe");
	ChromeDriver d = new ChromeDriver();
	//to create an object for wait1
	WebDriverWait wait = new WebDriverWait(d, 60);
	
	//To maximize the browser
	d.manage().window().maximize();

	//To open a application
	d.get("http://apps.qaplanet.in/hrm/login.php");
			
	//Create string for User name and password
	String sUN="qaplanet1";
	String sPWD="lab1";

	d.findElement(By.name("txtUserName")).sendKeys(sUN);
	Thread.sleep(2000);

	//To enter Password
	d.findElement(By.name("txtPassword")).sendKeys(sPWD);;
	Thread.sleep(2000);

	//To Click on Login
	d.findElement(By.name("Submit")).click();
	
	Actions a=new Actions(d);
	//Create WebElement for Admin
	WebElement objAdmin = d.findElement(By.className("drop"));
	WebElement objCompInfo = d.findElement(By.className("companyinfo"));
	WebElement objLoc = d.findElement(By.xpath("//*[@id=\"admin\"]/ul/li[1]/ul/li[2]/a/span"));
	//To focus on admin
	a.moveToElement(objAdmin).perform();
	// To focus on Companay Info
	a.moveToElement(objCompInfo).perform();
	//To click on Location
	a.moveToElement(objLoc).click().perform();
	Thread.sleep(2000);
	//Switch to frame
	d.switchTo().frame("rightMenu");
	
	d.findElement(By.xpath("//input[@class=\"checkbox\"][@value=\"LOC794\"]")).click();
	d.findElement(By.xpath("//input[@class=\"checkbox\"][@value=\"LOC795\"]")).click();
	d.findElement(By.xpath("//input[@class=\"checkbox\"][@value=\"LOC796\"]")).click();
	d.findElement(By.xpath("//input[@class=\"checkbox\"][@value=\"LOC797\"]")).click();
	d.findElement(By.xpath("//input[@class=\"checkbox\"][@value=\"LOC798\"]")).click();
	Thread.sleep(2000);
	//Click on delete
	d.findElement(By.xpath("//input[@class='plainbtn'][@value='Delete']")).click();
	
	Thread.sleep(2000);
	//Wait for alert
	//Create object for Alert
	Alert a1=wait.until(ExpectedConditions.alertIsPresent());
	//Verify alert
	if(a1.getText().equals("Deletion might affect Company Hierarchy. If the Location has associations deletion may fail. Do you want to delete ?"))
	{
		System.out.println("Display Alert message");
	}
	Thread.sleep(1000);
	//Accept alert message
	a1.accept();
	
	d.findElement(By.linkText("Logout")).click();
	
	d.close(); 	d.quit();
	
	
}

}
