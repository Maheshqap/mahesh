package testNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
public class classEXEC {
	static ChromeDriver d;
	static WebDriverWait wait;
	static WebElement ObjUn;
	static WebElement ObPWD;
	static WebElement ObjClear;
	static WebElement ObjLogin;
	static String sUN;
	static String sPWD;

@BeforeClass
public void urlOpen(){
	System.setProperty("webdriver.chrome.driver", "E:\\Selenium Softwares\\chromedriver.exe");
	d = new ChromeDriver();
	wait=new WebDriverWait(d,60);
	d.manage().window().maximize();
	System.out.println("HRM TestNG Started");
	Reporter.log("HRM TestNG Started");
	d.get("http://apps.qaplanet.in/hrm/login.php");
}

@BeforeMethod
public static void WeburlCheck(){
	
	ObjUn = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
	ObPWD = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
	ObjLogin = d.findElement(By.name("Submit"));
	ObjClear = d.findElement(By.name("clear"));
	
		if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
	{
	System.out.println("Home page displayed");
	Reporter.log("Home page displayed");
	
	}
	else
	{
	System.out.println("Failed to display homepage");
	Reporter.log("Failed to display homepage");
	return;
	}

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
}
@Test
public static void login() throws InterruptedException
{
	sUN="qaplanet1";
	sPWD="lab1";
	d.findElement(By.name("txtUserName")).sendKeys(sUN);
	System.out.println("UserName Entered");
	Reporter.log("UserName Entered");
	Thread.sleep(2000);
	d.findElement(By.name("txtPassword")).sendKeys(sPWD);;
	System.out.println("Password Entered");
	Reporter.log("Password Entered");
	Thread.sleep(2000);
	d.findElement(By.name("Submit")).click();
	System.out.println("Login to OrangeHRM");
	Reporter.log("Login to OrangeHRM");
}
@AfterMethod
public void logout() throws InterruptedException
{
	if(wait.until(ExpectedConditions.titleIs("OrangeHRM")))
	{
	System.out.println("Home page Diaplayed");
	Reporter.log("Home page Diaplayed");
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
	Reporter.log("Welcome "+sUN+" displayed");
	}
	//Create WebElement for Change Password and Logout
	WebElement objCP=d.findElement(By.linkText("Change Password"));
	WebElement objLG=d.findElement(By.xpath("//*[@id='option-menu']/li[3]/a"));
	//Verify Change password and logout
	if(objCP.isDisplayed() && objLG.isDisplayed())
	{
		System.out.println("Change password and logout is displayed");	
		Reporter.log("Change password and logout is displayed");
	}
	
	objLG.click();
	Thread.sleep(2000);
}
@AfterClass
public void quitClose()
{
	d.close();
	System.out.println("Window Closed");
	Reporter.log("Object Closed");	
	d.quit();
}
	
}

