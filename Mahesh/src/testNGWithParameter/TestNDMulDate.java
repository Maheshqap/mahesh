package testNGWithParameter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNDMulDate {
private static WebDriver driver;

@Test
@Parameters({"strURL","sUN", "sPWD"})
public void test(String strURL, String sUN, String sPWD)
{
	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(strURL);
	driver.findElement(By.name("txtUsername")).sendKeys(sUN);;
	driver.findElement(By.name("txtPassword")).sendKeys(sPWD);
	driver.findElement(By.name("Submit")).click();
	driver.findElement(By.linkText("Logout")).click();
	driver.close();
	driver.quit();
}
}