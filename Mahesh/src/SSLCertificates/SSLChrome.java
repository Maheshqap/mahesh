package SSLCertificates;


import java.io.File;

import org.openqa.selenium.Alert;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SSLChrome 
{	
	public static void main(String[] args) throws InterruptedException
	{
		File file = new File("D:\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath()); 
		
		ChromeOptions capability = new ChromeOptions();
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		WebDriver  driver = new ChromeDriver(capability);
		WebDriverWait wait=new WebDriverWait(driver,60);
		driver.get("https://axisbank.com/");
		Thread.sleep(2000);
		
		Alert A=wait.until(ExpectedConditions.alertIsPresent());
		A.accept();
		
	}
}