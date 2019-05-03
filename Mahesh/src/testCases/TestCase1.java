package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase1 {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\QAP18\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver d=new ChromeDriver();
		//to create an object for wait
		WebDriverWait wait=new WebDriverWait(d,60);

		//To maximize the browser
		d.manage().window().maximize();

		//To open a application
		d.get("http://apps.qaplanet.in/hrm/login.php");

		//Verify if the homepage is displayed with UN,PWD,Login an Clear

		if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
		{
		System.out.println("Home page displayed");
		}
			

		else
		{
			System.out.println("Failed to display homepage");
			return;
			
		}

		//Creating WebElelment for UN,PWD,Login and Clear
		WebElement ObjUn = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
		WebElement ObPWD = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
		WebElement ObjLogin = d.findElement(By.name("Submit"));
		WebElement ObjClear = d.findElement(By.name("clear"));

		//Verify User Name field
		if(ObjUn.isDisplayed())
		{
			System.out.println("User Name field Displayed");
		}
		else
			System.out.println("Failed to display User Name");


		//Verify Password field
		if(ObPWD.isDisplayed())
		{
			System.out.println("Password Field displayed");
		}
		else
		{
			System.out.println("Failed to display Password field");
		}
		//Verify Login Button
		if(ObjLogin.isDisplayed())
		{
			System.out.println("Login Button is displayed");
		}
		else
		{
			System.out.println("Failed to display Login Button");
		}
		//Verify Clear Button
		if(ObjClear.isDisplayed())
		{
			System.out.println("Clear button is displayed");
		}
		else
		{
			System.out.println("Failed to display Clear Button");
		}
		//To enter User ID
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

		//Verify OrangeHRM page
		if(wait.until(ExpectedConditions.titleIs("OrangeHRM")))
		{
		System.out.println("Home page Diaplayed");
		}
		else
		{
			System.out.println("Failed to Display homepage");
		}
		//Verify Welcome UN, Change Password and Logout
		//Create WebElement for Welcome, Change Password and Logout
		if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='option-menu']/li[1]"),"Welcome " + sUN)))
		{
		System.out.println("Welcome "+sUN+" displayed");	
		}
		//Create WebElement for Change Password and Logout
		WebElement objCP=d.findElement(By.linkText("Change Password"));
		WebElement objLG=d.findElement(By.xpath("//*[@id='option-menu']/li[3]/a"));
		//Verify Change password and logout
		if(objCP.isDisplayed() && objLG.isDisplayed())
		{
			System.out.println("Change password and logout is displayed");	
		}
		
		objLG.click();
		Thread.sleep(2000);
		
		d.close();
		d.quit();
		
	}
}
