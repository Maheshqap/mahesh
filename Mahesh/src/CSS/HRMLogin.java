package CSS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HRMLogin {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "D:\\Mahesh\\chromedriver.exe");
	ChromeDriver cd = new ChromeDriver();
	cd.get("http://apps.qaplanet.in/hrm/login.php");
	
	//WebElement wUN = cd.findElement(By.cssSelector("input[name='txtUserName']"));
	//WebElement wUN = cd.findElement(By.cssSelector("input.loginText"));		
	//WebElement wUN = cd.findElement(By.cssSelector(".loginText"));
	WebElement wUN = cd.findElement(By.cssSelector("input[class=\"loginText\"]"));
	WebElement wPWD = cd.findElement(By.cssSelector("input[type=\"password\"]"));
	wUN.clear();
	wUN.sendKeys("qaplanet1");
	System.out.println("UserName Entered");
	Thread.sleep(1000);
	wPWD.clear();
	wPWD.sendKeys("lab1");
	System.out.println("Password Entered");
	cd.findElement(By.cssSelector("input.button")).click();	
	System.out.println("Login Successfully");
	cd.findElement(By.linkText("Change Password")).click();
	cd.navigate().back();
	Actions act = new Actions(cd);
	WebElement wPIM = cd.findElement(By.linkText("PIM"));
	WebElement wEL = cd.findElement(By.linkText("Employee List"));
	act.moveToElement(wPIM).perform();
	System.out.println("PIM Selected");
	Thread.sleep(2000);
	act.moveToElement(wEL).click().perform();
	System.out.println("Employee List selected");
	
	cd.switchTo().frame("rightMenu");
	WebElement wsel = cd.findElement(By.xpath("//input[@value=\"1710\"]"));
	wsel.click();
	Thread.sleep(2000);
	
	cd.findElement(By.name("/input[@value=\"Delete\"]")).click();
	Thread.sleep(2000);
	cd.findElement(By.linkText("Logout"));
	
	
	
	cd.close();
}

}
