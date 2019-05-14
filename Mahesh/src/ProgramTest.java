import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import static org.testng.Assert.*;

public class ProgramTest {
	
	public static ChromeDriver drive;
	
	/*@BeforeMethod
	public void getUrl()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		ChromeDriver drive=new ChromeDriver();
		drive.get("http://apps.qaplanet.in/hrm/login.php");
		WebElement user=drive.findElement(By.name("txtUserName"));
		WebElement pass=drive.findElement(By.name("txtPassword"));
		user.clear();
		user.sendKeys("qaplanet1");
		pass.clear();
		pass.sendKeys("lab1");
		drive.findElement(By.name("Submit")).click();
		String ad=drive.getTitle();
		assertEquals("ad", "OrangeHRM");
		System.out.println("Logged in");
		System.out.println("Praveena");
	}
	*/
	@Test
	@Parameters("strun")
	static void method1(String strun)
	{
		System.out.println("parametirzed value is"+strun);
	}
}
	/*@Test
	static void method()
	{
		System.out.println("method2");
	}
	@AfterMethod
	static void close()
	{
		drive.close();
		drive.quit();
		System.out.println("Closed");
	}
	

}
*/