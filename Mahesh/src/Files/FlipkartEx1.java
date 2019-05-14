package Files;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class FlipkartEx1 {
public static void main(String[] args) throws Exception {
		
	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	WebDriver d = new ChromeDriver();
	d.manage().window().maximize();
	d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	Thread.sleep(2000);
	//-------------------------------Flipakart URL----------------------------------
	d.get("http://www.flipkart.com");	
	//-------------------------------Alert Closing----------------------------------
	d.findElement(By.xpath("//button[@class=\"_2AkmmA _29YdH8\"]")).click();
	//------------------------------Electronics-------------------------------------
	d.findElement(By.xpath("//span[@class='_1QZ6fC _3Lgyp8']")).click();
	//------------------------------Samsung-----------------------------------------
	d.findElement(By.linkText("Samsung")).click();
	//d.findElement(By.xpath("//*[@id='container']/div/div[3]/div/ul/li[1]/ul/li/ul/li[1]/ul/li[4]/a")).click();
	Thread.sleep(2000);
	//-------------------------------View All---------------------------------------
	d.findElement(By.xpath("//*[@id='container']/div/div[3]/div[3]/div[1]/div/div[1]/div[2]/a")).click();
	//-------------------------------Sort-------------------------------------------
	d.findElement(By.xpath("//*[@id='container']/div/div[3]/div[2]/div/div[2]/div[1]/div/div/div[2]/div[3]")).click();
	Thread.sleep(2000);
	//-------------------------------Get the Mobile Details-------------------------
	//WebElement wNext =d.findElement(By.xpath("//a[@class='_3fVaIS']")); 
	
	
	//List<WebElement> lst=d.findElements(By.xpath("//div[@class='_3wU53n']"));
	//System.out.println(lst.size());
	/*for(WebElement m:lst)
	{
		System.out.println(m.getText());
	}
	List<WebElement> lst1=d.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
	for(WebElement p:lst1)
	{
	System.out.println(p.getText().substring(1));
	}*/
	
	WebElement wNext1 = d.findElement(By.xpath("//a[@class='_3fVaIS']"));
	WebElement wNext2 = d.findElement(By.xpath("//a[@class='_3fVaIS'][2]"));
		for(int j = 1; j<=24; j++)
		{	
		//WebDriverWait wait = new WebDriverWait(d, 60);
		File fnew = new File("E:\\Softwares\\Flipkart.xls");
		WritableWorkbook wwb = Workbook.createWorkbook(fnew);
		WritableSheet ws = wwb.createSheet("Flipkart", 0);
		Label c0r0 = new Label(0, 0, "Name of Mobile");
		Label c1r0 = new Label(1, 0, "Price");
		ws.addCell(c0r0);
		ws.addCell(c1r0);
		List<WebElement> lst=d.findElements(By.xpath("//div[@class='_3wU53n']"));
		Iterator<WebElement> it = lst.iterator();
		Thread.sleep(1000);
		while(it.hasNext())
		{
		WebElement m = it.next();
		Thread.sleep(2000);
		System.out.println(m.getText());
		Label cr1 = new Label(0,j, m.getText());
		ws.addCell(cr1);
		wwb.write();
		Thread.sleep(2000);
		wNext1.click();
		}		
			/*if(j<=1)
			Thread.sleep(2000);
			if(j<=18)
			wNext2.click();*/
		}
		
		
	
	//wwb.close();
	
	/*d.close();
	d.quit();*/
	
}
}
