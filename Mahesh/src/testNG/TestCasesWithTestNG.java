package testNG;
import java.util.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



public class TestCasesWithTestNG{
		static ChromeDriver d;
		static WebDriverWait wait;
		static WebElement ObjUn;
		static WebElement ObPWD;
		static WebElement ObjClear;
		static WebElement ObjLogin;
		static WebElement ObjLG;
		static String sUN;
		static String sPWD;
		static Actions Act;
		static WebElement objPIM;
		static String sEmpID;
		static String sEmpName;
	@BeforeClass
	//@Parameters("URL")
	public void urlOpen(){
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Softwares\\chromedriver.exe");
		d = new ChromeDriver();
		wait=new WebDriverWait(d,60);
		d.manage().window().maximize();
		System.out.println("HRM TestNG Started");
		d.get("http://apps.qaplanet.in/hrm/login.php");
		//d.get(URL);
	}

	@BeforeMethod
	//@Parameters({"sUN","sPWD"})
	public static void Login() throws InterruptedException{
		
		sUN = "qaplanet1";
		sPWD = "lab1";
		ObjUn = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
		ObPWD = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
		ObjLogin = d.findElement(By.name("Submit"));
		ObjClear = d.findElement(By.name("clear"));
		
		if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
		{
		System.out.println("Home page displayed");
		}
		else
		{
		System.out.println("Failed to display homepage");
		return;
		}
			d.findElement(By.name("txtUserName")).sendKeys(sUN);
			System.out.println("UserName Entered");
			Thread.sleep(2000);
			d.findElement(By.name("txtPassword")).sendKeys(sPWD);;
			System.out.println("Password Entered");
			Thread.sleep(2000);
			d.findElement(By.name("Submit")).click();
			System.out.println("Login to OrangeHRM");
		}
	
	@Test(priority=1)
	public static void addEmployee() throws InterruptedException
	{
		Act=new Actions(d);
		objPIM=d.findElement(By.id("pim"));
		Act.moveToElement(objPIM).perform();
		Reporter.log("Action to PIM");
		d.findElement(By.linkText("Add Employee")).click();
		Reporter.log("Add Employee Clicked using Mouse Actions");
		Thread.sleep(2000);
		d.switchTo().frame("rightMenu");
		if(d.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("PIM : Add Employee"))
		{
			System.out.println("PIM : Add Employee displayed");
			Reporter.log("PIM : Add Employee displayed");
		}
		else
		{
			System.out.println("Failed to display PIM : Add Employee");
		}
		//----------------------------------------------------
		String sFN="Mahesh";
		String sLN="P";
		//----------------------------------------------------
		//Get employee code
		String strEmpCode=d.findElement(By.name("txtEmployeeId")).getAttribute("value");
		//create webelement for save
		WebElement objSave=d.findElement(By.id("btnEdit"));
		//Keep all fields as blank and click on save
		objSave.click();
		//wait for alert
		Alert A=wait.until(ExpectedConditions.alertIsPresent());
		//Verify alert message
		if(A.getText().equals("Last Name Empty!"))
		{
			System.out.println("Last Name Empty! displayed");
			Reporter.log("Last Name Empty! displayed");
			A.accept();
		}
		//Enter last name
		d.findElement(By.name("txtEmpLastName")).sendKeys(sLN);
		//Click on save
		objSave.click();
		//wait for alert
		Alert A1=wait.until(ExpectedConditions.alertIsPresent());
		//Verify alert message
		if(A1.getText().equals("First Name Empty!"))
		{
			System.out.println("First Name Empty! displayed");
			Reporter.log("First Name Empty! displayed");
			A1.accept();
		}	
		//Enter employee first name
		d.findElement(By.name("txtEmpFirstName")).sendKeys(sFN);
		//Click on save
		objSave.click();
		//wait for Personal Details text
		if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='mainHeading']/h2"), "Personal Details")))
		{
			System.out.println("Personal Details displayed");
		    Reporter.log("Personal Details displayed");
		}
		//switch to parent frame
		d.switchTo().parentFrame();
		//-------------------------------------------
		//Mouse ove ron PIM
		Act.moveToElement(objPIM).perform();
		//Click on Employee List
		d.findElement(By.linkText("Employee List")).click();
		//wait 2 sec
		Thread.sleep(2000);
		//switch to frame
		d.switchTo().frame("rightMenu");
		//Verify Employee Information
		if(d.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Employee Information"))
		{
			System.out.println("Employee Information displayed");
			Reporter.log("Employee Information displayed");
		}
		else
		{
			System.out.println("Failed to display Employee Information");
		}	
		//-------------------------------------------
		//Get row count
		int rc=d.findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
		int i;
		for(i=1;i<=rc;i++)
		{
			//Get emp id from second column
			sEmpID=d.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
			//Get emp name from third column
			sEmpName=d.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
			if(sEmpID.equals(strEmpCode) && sEmpName.equals(sFN+" "+sLN))
			{
				System.out.println(sEmpName+", "+sEmpID+", "+"displayed at: "+i);
				Reporter.log(sEmpName+", "+sEmpID+", "+"displayed at: "+i);
				break;
			}
		}
		//switch to default page
		d.switchTo().defaultContent();
	}
	@Test(priority=2)
	public void editEmployee() throws Exception{
		Act=new Actions(d);
		objPIM=d.findElement(By.id("pim"));
		System.out.println("Actioned on PIM");
		Act.moveToElement(objPIM).perform();
		Reporter.log("Action to PIM");
		d.findElement(By.linkText("Employee List")).click();
		System.out.println("Employee List Selected");
		Reporter.log("Employee List selected");
		d.switchTo().frame("rightMenu");
		d.findElement(By.xpath("//*[@id=\"standardView\"]/table/tbody/tr[44]/td[3]/a")).click();
		d.findElement(By.name("EditMain")).click();
		Thread.sleep(1000);
		WebElement eFN=d.findElement(By.name("txtEmpFirstName"));
		WebElement eLN=d.findElement(By.name("txtEmpLastName"));
		WebElement eMN=d.findElement(By.name("txtEmpMiddleName"));
		eFN.clear();
		Thread.sleep(1000);
		eLN.sendKeys(Keys.CONTROL,"a");
		Thread.sleep(1000);
		eLN.sendKeys(Keys.DELETE);
		Thread.sleep(1000);
		eFN.sendKeys("Polisetty ");
		Thread.sleep(1000);
		eLN.sendKeys("MAHESH");
		Thread.sleep(1000);
		eFN.sendKeys(Keys.TAB);
		eMN.sendKeys("Laxman");
		Thread.sleep(1000);
		d.findElement(By.id("DOB")).clear();
		d.findElement(By.id("DOB")).sendKeys("1994-06-05");
		d.findElement(By.name("EditMain")).click();
		
		Thread.sleep(1000);
		//E.sendKeys(Keys.TAB);
		//E.sendKeys(Keys.TAB);
		
		String strEmpCode=d.findElement(By.name("txtEmployeeId")).getAttribute("value");
		System.out.println("Employee Code/ID = "+strEmpCode);
		//Move to Parent Frame
		d.switchTo().parentFrame();
		//-------------------------------------------
		//Mouse over to PIM
		Act.moveToElement(objPIM).perform();
		//Click on Employee List
		d.findElement(By.linkText("Employee List")).click();
		//wait 2 sec
		Thread.sleep(1000);
		//switch to frame
		d.switchTo().frame("rightMenu");
		//Verify Employee Information
		if(d.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Employee Information"))
		{
			System.out.println("Employee Information displayed");
		}
		else
		{
			System.out.println("Failed to display Employee Information");
		}	
		//-------------------------------------------
		//Get row count
		int rc=d.findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
		System.out.println("Size of Row count : "+rc);
		int i;
		for(i=1;i<=rc;i++)
		{
			//Get emp id from second column
			String sEmpID=d.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(sEmpID);
			//Get emp name from third column
			String sEmpName=d.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
			System.out.println(sEmpName);
			if(sEmpID.equals(strEmpCode) && sEmpName.equals(eFN+" "+eMN+" "+eLN))
			{
				System.out.println(sEmpName+", "+sEmpID+", "+"displayed at: "+i);
				break;
			}
		}
		//switch to default page
		d.switchTo().defaultContent();
	}
	@Test(priority = 3)
	public void delete()
	{
		d.switchTo().frame("rightMenu");
		d.findElement(By.xpath("//input[@value='1810']")).click();
		d.findElement(By.xpath("//input[@value='Delete']")).click();
		d.switchTo().defaultContent();
	}
	@AfterMethod
	public void logout() throws Exception
	{
		d.switchTo().defaultContent();
		ObjLG = d.findElement(By.linkText("Logout"));
		ObjLG.click();
		Thread.sleep(2000);
	}
	@AfterClass
	public void quitClose()
	{
		d.close();
		System.out.println("Window Closed");
		d.quit();
	}
		
}
