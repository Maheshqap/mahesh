package MultipleBrowsers;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BackandFrwd {

	//@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://apps.qaplanet.in/webapp/");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Alert")).click();
		Thread.sleep(2000);
		Set<String> IDS=driver.getWindowHandles();
		for(String ID : IDS)
		{
			System.out.println(ID);
		}
		
		Iterator<String> It = IDS.iterator();
		String First_Window = It.next();
		String Second_Window = It.next();		
			
		driver.switchTo().window(Second_Window);
		driver.findElement(By.xpath("//input[1]")).click();
		WebDriverWait wait= new WebDriverWait(driver,30);
		Alert A=wait.until(ExpectedConditions.alertIsPresent());
		if(A.getText().equals("Welcome to QAPlanet!")){
			System.out.println("Alert is preSENT");
			A.accept();
		}
		
		driver.switchTo().window(First_Window);
		Thread.sleep(2000);
		driver.findElement(By.linkText("AgeProb")).click();	
	
		Set<String> IDS1=driver.getWindowHandles();
		for(String ID2 : IDS1)
		{
			System.out.println(ID2);
		}
		
		Iterator<String> It1 = IDS1.iterator();
		String First_Window1 = It1.next();
		String Second_Window2 = It1.next();	
		String Third_Window3 = It1.next();
				
		driver.switchTo().window(Third_Window3);
		driver.findElement(By.id("idSubGo")).click();
		Alert A2=wait.until(ExpectedConditions.alertIsPresent());
		if(A2.getText().equals("Infant"))
		{
			System.out.println("Alert is displayed");
			A2.accept();
		}
		driver.close();
		driver.switchTo().window(Second_Window2);
		driver.close();
		driver.switchTo().window(First_Window);		
		
		driver.close();
		driver.quit();
	
		
		
	}
}
