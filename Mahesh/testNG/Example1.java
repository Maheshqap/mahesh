package testNG;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
public class Example1 {
	
	@BeforeMethod
	public void method1()
	{
		
		System.out.println("WebDriver, URL");
		Reporter.log("WebDriver Opened");
	}
	@AfterClass
	public void method2()
	{
		
		System.out.println("Quit and close Variable");
		Reporter.log("quit");
	}
	@Test
	public void Method()
	{
		//System.out.println(ex);
		System.out.println("Test Done");
		Reporter.log("Test case 1 Done");
	}
	@BeforeMethod
	public static void method3()
	{
		//Example1 ex = new Example1();
		System.out.println("Displayed Elements & Login");
		Reporter.log("Login Done");
	}
	@AfterMethod
	public void method4()
	{
		System.out.println("Logout");
		Reporter.log("Logout Done");
		
	}
}
