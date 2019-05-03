package testCases;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class TestCase9 
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

	//Verify if the homepage is displayed with UN,PWD,Login an Clear

	if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
	{
	System.out.println("Home page displayed");
	}
	else
	{
		System.out.println("Failed to display homepage");
		return;
	}

	//Creating WebElelment for UN,PWD,Login and Clear
	WebElement ObjUn = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
	WebElement ObPWD = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
	WebElement ObjLogin = d.findElement(By.name("Submit"));
	WebElement ObjClear = d.findElement(By.name("clear"));

	//Verify User Name field
	if(ObjUn.isDisplayed()&&ObPWD.isDisplayed())
	{
		System.out.println("User Name & Password fields Displayed");
	}
	else
		System.out.println("Failed to display User Name & Password");


	//Verify Login Button
	if(ObjLogin.isDisplayed()&&ObjClear.isDisplayed())
	{
		System.out.println("Login & Clear Button are displayed");
	}
	else
	{
		System.out.println("Failed to display Login & Clear Button");
	}
	//To enter User ID
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

	//Verify OrangeHRM page
	if(wait.until(ExpectedConditions.titleIs("OrangeHRM")))
	{
	System.out.println("Home page Diaplayed");
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
	}
	//Create WebElement for Change Password and Logout
	WebElement objCP=d.findElement(By.linkText("Change Password"));
	WebElement objLG=d.findElement(By.xpath("//*[@id='option-menu']/li[3]/a"));
	//Verify Change password and logout
	if(objCP.isDisplayed() && objLG.isDisplayed())
	{
		System.out.println("Change password and logout is displayed");	
}
	//Object for Action class
	Actions a=new Actions(d);
	//Create WebElement for Admin
	WebElement objAd = d.findElement(By.className("drop"));
	//To focus on admin
	a.moveToElement(objAd).perform();
	//Creating WebElements for sub options under Admin
	WebElement objCompInfo = d.findElement(By.className("companyinfo"));
	WebElement objJobs = d.findElement(By.className("job"));
	WebElement objQual = d.findElement(By.className("qualifications"));
	WebElement objSkills = d.findElement(By.className("skills"));
	WebElement objmem = d.findElement(By.className("memberships"));
	WebElement objNatnRace = d.findElement(By.className("natandrace"));
	WebElement objUsers = d.findElement(By.className("users"));
	WebElement objEmail = d.findElement(By.className("email"));
	WebElement objProInfo = d.findElement(By.className("project"));
	WebElement objImpExp = d.findElement(By.className("importexport"));
	WebElement objCusFields = d.findElement(By.xpath("//*[@id=\"admin\"]/ul/li[11]/a"));
	//Display all the Webelements
	if(objCompInfo.isDisplayed() && objJobs.isDisplayed() && objQual.isDisplayed() && objSkills.isDisplayed() &&objmem.isDisplayed() && objNatnRace.isDisplayed() && objUsers.isDisplayed() && objEmail.isDisplayed() && objProInfo.isDisplayed() && objImpExp.isDisplayed() && objCusFields.isDisplayed())
	{
		System.out.println("Display Company info, Job, Qualifications, Skills, Membership, Nationality and Race, Users, Email, Project, Import and Export, Customfields");
	}
	else
	{
		System.out.println("Failed to Dispaly Company info, Job, Qualifications, Skills, Membership, Nationality and Race, Users, Email, Project, Import and Export, Customfields");
				
	}
	
	//Hover over job
	a.moveToElement(objJobs).perform();
	
	//Create WebElement for all the sub fields under job
	WebElement JT = d.findElement(By.xpath("//*[@id='admin']/ul/li[2]/ul/li[1]/a"));
	WebElement JS = d.findElement(By.xpath("//*[@id='admin']/ul/li[2]/ul/li[2]/a"));
	WebElement PG = d.findElement(By.xpath("//*[@id='admin']/ul/li[2]/ul/li[3]/a"));
	WebElement ES = d.findElement(By.xpath("//*[@id='admin']/ul/li[2]/ul/li[4]/a"));
	WebElement EEOJC = d.findElement(By.xpath("//*[@id='admin']/ul/li[2]/ul/li[5]/a"));
	
	//Verify all the elements above
	
	if(JT.isDisplayed() && JS.isDisplayed() && PG.isDisplayed() && ES.isDisplayed() && EEOJC.isDisplayed())
	{
		System.out.println("Displayed Job Title, Job specification, Pay grade, Employment status, EEO job catagory");
	}
	
	//Click on Job title
	//a.moveToElement(JT).perform();
	a.click(JT).perform();
	Thread.sleep(2000);
	
	//Change frame
    d.switchTo().frame("rightMenu");
	//Verify all the fields are displayed under Job title
	
	//Create WebElement for all the fields 
	WebElement JobT = d.findElement(By.xpath("/html/body/div/div[2]/form/div[1]/h2"));
	WebElement objSB = d.findElement(By.xpath("/html/body/div/div[2]/form/div[2]/label[1]"));
    WebElement objSer = d.findElement(By.xpath("/html/body/div/div[2]/form/div[2]/input[2]"));
    WebElement objRes = d.findElement(By.xpath("/html/body/div/div[2]/form/div[2]/input[3]"));
    WebElement objAdd = d.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div[1]/input[1]"));
    WebElement objDel = d.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div[1]/input[2]"));
	
    if(JobT.isDisplayed() && objSB.isDisplayed() && objSer.isDisplayed() && objRes.isDisplayed() && objAdd.isDisplayed() && objDel.isDisplayed())
    {
    	System.out.println("Job : Job Title, Search by, Search, Reset, Add, Delete");
    }
    Thread.sleep(2000);
    //Click on add and Verify all fields
    //Click on Add
    d.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div[1]/input[1]")).click();
    //Verify all the fields under Add Job title
    //Create Elements for all the fields
    WebElement bk= d.findElement(By.xpath("/html/body/div[2]/div[1]/input"));
    WebElement jtn= d.findElement(By.xpath("//*[@id='frmJobTitle']/label[1]"));
    WebElement jd= d.findElement(By.xpath("//*[@id='frmJobTitle']/label[2]"));
    WebElement jtc= d.findElement(By.xpath("//*[@id='frmJobTitle']/label[3]"));
    WebElement js= d.findElement(By.xpath("//*[@id='frmJobTitle']/label[4]"));
    WebElement pg= d.findElement(By.xpath("//*[@id='frmJobTitle']/label[5]"));
    WebElement apg= d.findElement(By.xpath("//*[@id='frmJobTitle']/div[1]/input[1]"));
    WebElement epg= d.findElement(By.xpath("//*[@id='frmJobTitle']/div[1]/input[2]"));
    WebElement save = d.findElement(By.xpath("//*[@id='frmJobTitle']/div[2]/input[1]"));
    WebElement reset = d.findElement(By.xpath("//*[@id='frmJobTitle']/div[2]/input[2]"));
    
    //Verify all the above fields
    if(bk.isDisplayed() && jtn.isDisplayed() && jd.isDisplayed() && jtc.isDisplayed() && js.isDisplayed() && pg.isDisplayed() && apg.isDisplayed() && epg.isDisplayed() && save.isDisplayed() && reset.isDisplayed())
    	
    {
    	System.out.println("Display Back, Job Title Name, Job Description, Job Title Comments, Job Specification, Pay Grade, Add Pay grade, Edit pay grade, Save, Reset");
    }
    //Keep all fields empty and click on save
    save.click();
    
    //Wait for alert
    //Create an object for alert
    Alert Al=wait.until(ExpectedConditions.alertIsPresent());
    //Verify Alert message
    if(Al.getText().equals("Job Title Name should be specified"))
    {
    	System.out.println("Job Title Name should be specified is displayed");
    }
    Thread.sleep(2000);
    Al.accept();
    Thread.sleep(2000);
    //Enter Job Title
    d.findElement(By.name("txtJobTitleName")).sendKeys("Automation Tester");
    //Click on save
    save.click();
    Thread.sleep(2000);
    //Verify and click Ok on Alert message
    Alert A2=wait.until(ExpectedConditions.alertIsPresent());
    //Verify Alert message
    if(A2.getText().equals("Job Description should be specified"))
    {
    	System.out.println("Job Description should be specified is displayed");
    }
    A2.accept();
    
    //Enter Job Description
    Thread.sleep(2000);
    WebElement JD=d.findElement(By.name("txtJobTitleDesc"));
    JD.sendKeys("Working on Test cases");
    Thread.sleep(1000);
    JD.sendKeys(Keys.ENTER);
    JD.sendKeys("Execute test cases");
    Thread.sleep(1000);
    JD.sendKeys(Keys.ENTER);
    JD.sendKeys("Automating Testing");
    Thread.sleep(1000);
    //Click on save
    save.click();
    
    WebElement ES1=d.findElement(By.xpath("//*[@id='frmJobTitle']/label[7]"));
    
    //Verify Employment Status is displayed
    if(ES1.isDisplayed())
    {
    	System.out.println("Employment status is displayed");
    	
    }
    //Edit empl status and other information
    //Click on Edit
    d.findElement(By.id("editBtn")).click();
    Thread.sleep(1000);
    //To Change emplyment status
    a.moveToElement(d.findElement(By.xpath("//*[@id='cmbAssEmploymentStatus']/option"))).click().perform();
    Thread.sleep(2000);
    //Click on remove
    d.findElement(By.name("butUnAssEmploymentStatus")).click();
    Thread.sleep(2000);
    //Select Fulltime Contract from the list
    a.moveToElement(d.findElement(By.xpath("//*[@id='cmbUnAssEmploymentStatus']/option[2]"))).click().perform();
    Thread.sleep(2000);
    //Click on Add
    d.findElement(By.xpath("//*[@id='frmJobTitle']/div[1]/input[1]")).click();
    Thread.sleep(2000);
    //Edit other information
    d.findElement(By.name("txtJobTitleComments")).sendKeys("In QA Planet till 05:30");
    Thread.sleep(2000);
    //Click on save
    d.findElement(By.id("editBtn")).click();
    
    d.switchTo().defaultContent();
    d.findElement(By.linkText("Logout"));
    
    Thread.sleep(2000);
    
    d.close();    d.quit();
    
   		
}
}