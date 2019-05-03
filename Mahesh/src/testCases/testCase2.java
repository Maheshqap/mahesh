package testCases;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testCase2 {
	public static void main(String[] args)throws Exception
	{
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
		//Verify home page displayed or not
		if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
		{
			System.out.println("Home Page Displayed");
		}
		else
		{
			System.out.println("Failed to display home page");
			return;
		}
		//-------------------------------------------------
		//Create webelement for UN,PWD,Login and clear
		WebElement objUN=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
		WebElement objPWD=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
		WebElement objLogin=Driver.findElement(By.name("Submit"));
		WebElement objClear=Driver.findElement(By.name("clear"));
		//------------------------------------------------
		//Verify user name
		if(objUN.isDisplayed())
		{
			System.out.println("User name displayed");
		}
		//Verify password
		if(objPWD.isDisplayed())
		{
			System.out.println("Password displayed");
		}
		//Verify login and clear
		if(objLogin.isDisplayed() && objClear.isDisplayed())
		{
			System.out.println("Login and clear displayed");
		}
		//---------------------------------------------------
			String sUN="qaplanet1";
			String sPWD="lab1";
		//-----------------------------------------------------
		//Clear user name text box and enter user name
		objUN.clear();
		objUN.sendKeys(sUN);
		//Clear password and enter password
		objPWD.clear();
		objPWD.sendKeys(sPWD);
		//Click on login
		objLogin.click();
		//Verify OrangeHRM
		if(wait.until(ExpectedConditions.titleIs("OrangeHRM")))
		{
			System.out.println("OrangeHRM displayed");
		}
		else
		{
			System.out.println("Failed to login");
			return;
		}
		
		//---------------Verify welcome text-------------------------------
		//way 1
		if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//ul[@id='option-menu']/li[1]"), "Welcome "+sUN)))
		{
			System.out.println("Welcome "+sUN+" displayed");
		}
		//Way 2
		String WelText=Driver.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText();
		if(WelText.equals("Welcome "+sUN)) 
		{
			System.out.println("Welcome "+sUN+" displayed");
		}
		//Way 3: Verify only user name
		String[]  Arr=WelText.split(" ");
		if(Arr[1].equals(sUN))
		{
			System.out.println(sUN+" displayed");
		}
		//-------------------------------------------------------
		//Create webelemnt for chnage password and logout
		WebElement objCP=Driver.findElement(By.linkText("Change Password"));
		WebElement objLogout=Driver.findElement(By.linkText("Logout"));
		//Veify Change Password & Logout
		if(objCP.isDisplayed() && objLogout.isDisplayed())
		{
			System.out.println("Change Password & Logout are displayed");
		}
		//------------------------------------------------------
		//Create webelement for PIM
		WebElement objPIM=Driver.findElement(By.id("pim"));
		//Mouse ove ron PIM
		Act.moveToElement(objPIM).perform();
		//Click on add employee
		Driver.findElement(By.linkText("Add Employee")).click();
		//wait 2 sec
		Thread.sleep(2000);
		//switch to frame
		Driver.switchTo().frame("rightMenu");
		//Verify PIM : Add Employee
		if(Driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("PIM : Add Employee"))
		{
			System.out.println("PIM : Add Employee displayed");
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
		String strEmpCode=Driver.findElement(By.name("txtEmployeeId")).getAttribute("value");
		//create webelement for save
		WebElement objSave=Driver.findElement(By.id("btnEdit"));
		//Keep all fields as blank and click on save
		objSave.click();
		//wait for alert
		Alert A=wait.until(ExpectedConditions.alertIsPresent());
		//Verify alert message
		if(A.getText().equals("Last Name Empty!"))
		{
			System.out.println("Last Name Empty! displayed");
			A.accept();
		}
		//Enter last name
		Driver.findElement(By.name("txtEmpLastName")).sendKeys(sLN);
		//Click on save
		objSave.click();
		//wait for alert
		Alert A1=wait.until(ExpectedConditions.alertIsPresent());
		//Verify alert message
		if(A1.getText().equals("First Name Empty!"))
		{
			System.out.println("First Name Empty! displayed");
			A1.accept();
		}	
		//Enter employee first name
		Driver.findElement(By.name("txtEmpFirstName")).sendKeys(sFN);
		//Click on save
		objSave.click();
		//wait for Personal Details text
		if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='mainHeading']/h2"), "Personal Details")))
		{
			System.out.println("Personal Details displayed");
		}
		//switch to parent frame
		Driver.switchTo().parentFrame();
		//-------------------------------------------
		//Mouse ove ron PIM
		Act.moveToElement(objPIM).perform();
		//Click on Employee List
		Driver.findElement(By.linkText("Employee List")).click();
		//wait 2 sec
		Thread.sleep(2000);
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
			//Get emp name from third column
			String sEmpName=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
			if(sEmpID.equals(strEmpCode) && sEmpName.equals(sFN+" "+sLN))
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
		Thread.sleep(2000);
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

