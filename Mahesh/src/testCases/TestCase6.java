package testCases;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase6 
{
	
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\QAP18\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver d=new ChromeDriver();
		//to create an object for wait
		WebDriverWait wait=new WebDriverWait(d,60);

		//To maximize the browser
		d.manage().window().maximize();

		//To open a application
		d.get("http://apps.qaplanet.in/hrm/login.php");
		
		//Create string for User name and password
		String sUN="qaplanet1";
		String sPWD="lab1";

		d.findElement(By.name("txtUserName")).sendKeys(sUN);
		Thread.sleep(2000);

		//To enter Password
		d.findElement(By.name("txtPassword")).sendKeys(sPWD);;
		Thread.sleep(2000);

		//To Click on Login
		d.findElement(By.name("Submit")).click();
		Actions a=new Actions(d);
		//Create WebElement for Admin
		WebElement objAdmin = d.findElement(By.className("drop"));
		WebElement objCompInfo = d.findElement(By.className("companyinfo"));
		WebElement objLoc = d.findElement(By.xpath("//*[@id=\"admin\"]/ul/li[1]/ul/li[2]/a/span"));
		//To focus on admin
		a.moveToElement(objAdmin).perform();
		// To focus on Companay Info
		a.moveToElement(objCompInfo).perform();
		//To click on Location
		a.moveToElement(objLoc).click().perform();
		Thread.sleep(2000);
		//Switch to frame
		d.switchTo().frame("rightMenu");
		WebElement E = d.findElement(By.id("loc_code"));
		Select e = new Select(E);
		e.selectByVisibleText("Name");
		//Enter name
		String name = "Mahesh";
		d.findElement(By.name("loc_name")).sendKeys(name);
		//Select Country	
		WebElement wSearch = d.findElement(By.className("plainbtn"));
		a.moveToElement(wSearch).click().perform();
		//Click on Name/ID to get details
		d.findElement(By.xpath("/html/body/div/div[2]/form/table/tbody/tr[1]/td[2]/a")).click();
		//Click on Edit
		d.findElement(By.id("editBtn")).click();
		//Change name, Address, Pincode.
		WebElement wName = d.findElement(By.id("txtLocDescription"));
		WebElement wAdd = d.findElement(By.id("txtAddress"));
		WebElement wZip = d.findElement(By.id("txtZIP"));
		Thread.sleep(1000);
		wName.clear();
		wName.sendKeys("Polisetty Mahesh");
		Thread.sleep(1000);
		wAdd.clear();
		wAdd.sendKeys("QAP, Ameerpet, Hyd");
		Thread.sleep(1000);
		wZip.clear();
		wZip.sendKeys("530450");
		Thread.sleep(2000);
		//Click on Save
		d.findElement(By.id("editBtn")).click();
		Thread.sleep(2000);
		//Enter Address
		d.findElement(By.id("txtAddress")).sendKeys("Amrpt, Hyd");
		//Enter Zipcode
		d.findElement(By.id("txtAddress")).sendKeys("500085");
	
		//Click on Save
		d.findElement(By.id("editBtn")).click();
		Thread.sleep(2000);
		
		WebElement wsel = d.findElement(By.id("loc_code"));
		
		Select sel = new Select(wsel);
		sel.selectByVisibleText("Name");
		d.findElement(By.id("loc_name")).sendKeys(name);
		d.findElement(By.xpath("//input[@class=\"plainbtn\"]")).click();
		
		//Edit Name
		d.findElement(By.name("txtLocDescription")).sendKeys(" "+"Laxman");
		//Edit Address
		d.findElement(By.name("txtAddress")).sendKeys(" "+"Amrpt, HYD");

		//Click on save
		d.findElement(By.xpath("//*[@id='editBtn']")).click();
		
		d.switchTo().parentFrame();
		d.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		
		d.close();
		d.quit();

}
}