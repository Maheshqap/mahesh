package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Testcase3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\QAP18\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		//TO maximize browser
		Driver.manage().window().maximize();
		//-------------------------------------
		//wait object
		WebDriverWait wait=new WebDriverWait(Driver, 60);
		//Actions class object
		Actions Act=new Actions(Driver);
		//----------------------------------------------
		//Open application
		Driver.get("http://apps.qaplanet.in/hrm/login.php");
		
		//Create webelement for UN,PWD,Login and clear
		WebElement objUN=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
		WebElement objPWD=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
		WebElement objLogin=Driver.findElement(By.name("Submit"));
		WebElement objClear=Driver.findElement(By.name("clear"));
		//------------------------------------------------
		
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
		
		//Select Employee
		//Driver.switchTo().frame("rightMenu");
		//Create webelement for PIM
		//Create webelement for PIM
		WebElement objPIM=Driver.findElement(By.id("pim"));
		//Mouse over on PIM
		Act.moveToElement(objPIM).perform();
		//Click on add employee
		Driver.findElement(By.linkText("Add Employee")).click();
		//wait 2 sec
		Thread.sleep(1000);
		//switch to frame
		Driver.switchTo().defaultContent();
		Driver.switchTo().frame("rightMenu");
		String strEmpCode=Driver.findElement(By.name("txtEmployeeId")).getAttribute("value");
		//create webelement for save
		
		//----------------------------------------------------
		String sFN="Mahesh";
		String sLN="P";
		//----------------------------------------------------
		//Enter last name
		Driver.findElement(By.name("txtEmpLastName")).sendKeys(sLN);
		Driver.findElement(By.name("txtEmpFirstName")).sendKeys(sFN);
		//Click on save
		Driver.findElement(By.id("btnEdit")).click();
		Thread.sleep(1000);
		
		
		//wait for Personal Details text
		if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='mainHeading']/h2"), "Personal Details")))
		{
			System.out.println("Personal Details displayed");
		}
		//Edit Entered Details
		Driver.findElement(By.name("EditMain")).click();
		Thread.sleep(1000);
		WebElement eFN=Driver.findElement(By.name("txtEmpFirstName"));
		WebElement eLN=Driver.findElement(By.name("txtEmpLastName"));
		WebElement eMN=Driver.findElement(By.name("txtEmpMiddleName"));
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
		Driver.findElement(By.id("DOB")).sendKeys("1994-06-05");
		Driver.findElement(By.name("EditMain")).click();
		
		Thread.sleep(1000);
		//E.sendKeys(Keys.TAB);
		//E.sendKeys(Keys.TAB);
		
	
		//Move to Parent Frame
		Driver.switchTo().parentFrame();
		//-------------------------------------------
		//Mouse over to PIM
		Act.moveToElement(objPIM).perform();
		//Click on Employee List
		Driver.findElement(By.linkText("Employee List")).click();
		//wait 2 sec
		Thread.sleep(1000);
		//switch to frame
		Driver.switchTo().frame("rightMenu");
		//Verify Employee Information
		if(Driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Employee Information"))
		{
			System.out.println("Employee Information displayed");
		}
		else
		{
			System.out.println("Failed to display Employee Information");
		}	
		//-------------------------------------------
		//Get row count
		int rc=Driver.findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
		int i;
		for(i=1;i<=rc;i++)
		{
			//Get emp id from second column
			String sEmpID=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(sEmpID);
			//Get emp name from third column
			String sEmpName=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
			System.out.println(sEmpName);
			if(sEmpID.equals(strEmpCode) && sEmpName.equals(eFN+" "+eMN+" "+eLN))
			{
				System.out.println(sEmpName+", "+sEmpID+", "+"displayed at: "+i);
				break;
			}
		}
		//switch to default page
		Driver.switchTo().defaultContent();
		//--------------------------------------------
		//Click on Logout
		Driver.findElement(By.linkText("Logout")).click();
		//wait 2 sec
		Thread.sleep(1000);
		//Verify home page displayed or not
		if(Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
		{
			System.out.println("Signoff sucessfull & Home Page Displayed");
		}
		else
		{
			System.out.println("Failed to Signoff");
			return;
		}		
		//----------------------------------------------
		//Close browser
		Driver.close();
		//Quit object
		Driver.quit();		
	
		
	
	}

}
