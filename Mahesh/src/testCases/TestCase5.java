package testCases;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase5 
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

		
		//Creating WebElelment for UN,PWD,Login and Clear
		WebElement ObjUn = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
		WebElement ObPWD = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
		WebElement ObjLogin = d.findElement(By.name("Submit"));
		WebElement ObjClear = d.findElement(By.name("clear"));

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
		//Find elements under Compnay info
		a.moveToElement(objCompInfo).perform();
		Thread.sleep(2000);
		
		//Create WebElelments for Sub titles under Company info
		WebElement objGen = d.findElement(By.xpath("//*[@id=\"admin\"]/ul/li[1]/ul/li[1]/a/span"));
		WebElement objLoc = d.findElement(By.xpath("//*[@id=\"admin\"]/ul/li[1]/ul/li[2]/a/span"));
		WebElement objComStr = d.findElement(By.xpath("//*[@id=\"admin\"]/ul/li[1]/ul/li[3]/a/span"));
		WebElement objComPro = d.findElement(By.xpath("//*[@id=\"admin\"]/ul/li[1]/ul/li[4]/a/span"));
		//Verify all the WebElements above
		if(objGen.isDisplayed() && objLoc.isDisplayed() && objComStr.isDisplayed() && objComPro.isDisplayed())
		{
			System.out.println("Displayed General, Locations, Compnay Structure, Company property");
		}
		//To click on Locations
	    objLoc.click();
	    //Change frame
	    d.switchTo().frame("rightMenu");
	    //Verify Company info: Locations page
	    //Create Elements for all the fields mentioned in the test case
	    WebElement objCIL = d.findElement(By.xpath("/html/body/div/div[2]/form/div[1]/h2"));
	
	    //Create WebElement for all other sub elements as per test case
	    WebElement objSB = d.findElement(By.xpath("/html/body/div/div[2]/form/div[2]/label[1]"));
	    WebElement objSer = d.findElement(By.xpath("/html/body/div/div[2]/form/div[2]/input[2]"));
	    WebElement objRes = d.findElement(By.xpath("/html/body/div/div[2]/form/div[2]/input[3]"));
	    WebElement objAdd = d.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div[1]/input[1]"));
	    WebElement objDel = d.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div[1]/input[2]"));
	    
	    //Verify all the webelements above
	    if(objSB.isDisplayed() && objSer.isDisplayed() && objRes.isDisplayed() && objAdd.isDisplayed() && objDel.isDisplayed())
	    {
	    	System.out.println("Display Search by, Search, Reset, Add, Delete");
	    }
	    //Click on Add
	    objAdd.click();
	    
	   
	    //Verify Company Info: Locations
	    //Create WebElements for all the fields in the current webpage
	    WebElement objCinfoL = d.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/h2"));
	    WebElement objName = d.findElement(By.xpath("//*[@id=\"frmLocation\"]/label[1]"));
	    WebElement objCou = d.findElement(By.xpath("//*[@id=\"frmLocation\"]/label[2]"));
	    WebElement objState = d.findElement(By.xpath("//label[@for='txtState']"));
	    WebElement objCity = d.findElement(By.xpath("//label[@for='cmbDistrict']"));
	    WebElement objAddr = d.findElement(By.xpath("//label[@for='txtAddress']"));
	    WebElement objZip = d.findElement(By.xpath("//label[@for='txtZIP']"));
	    WebElement objPhn = d.findElement(By.xpath("//label[@for='txtPhone']"));
	    WebElement objFax = d.findElement(By.xpath("//label[@for='txtFax']"));
	    WebElement objComm = d.findElement(By.xpath("//label[@for='txtComments']"));
	    WebElement objSave = d.findElement(By.xpath("//*[@id=\"editBtn\"]"));
	    WebElement objReset = d.findElement(By.xpath("//*[@id=\"frmLocation\"]/div[2]/input[2]"));
	    
	    //Verify all the elements above
	    if(objCinfoL.isDisplayed() && objName.isDisplayed() && objCou.isDisplayed() && objState.isDisplayed() && objCity.isDisplayed() && objAddr.isDisplayed() && objZip.isDisplayed() && objPhn.isDisplayed() && objFax.isDisplayed() && objComm.isDisplayed() && objSave.isDisplayed() && objReset.isDisplayed())
	    {
	    	System.out.println("Display Comp Info locations, Name, Country, state, City, Address, Zip, Phone, Fax, Comment, Save, Reset");
	    }
	    //Keep all fields blank and click on save
	    objSave.click();
	    Thread.sleep(3000);
	    //Create object for Alert
	    Alert A=wait.until(ExpectedConditions.alertIsPresent());
	    //Wait for alert
	    //Verify Alert
	    if (A.getText().equals("Please correct the following\n\n\t- Location Name has to be specified\n\t- Country should be selected!\n\t- Address should be specified\n\t- Zip Code should be specified\n")){
	    	System.out.println("Name Alert is displayed");
	    }
	    A.accept();
	    //Enter Name
	    d.findElement(By.name("txtLocDescription")).sendKeys("Mahesh");
	    Thread.sleep(2000);
	    //Click on save
	    objSave.click();
	    Thread.sleep(2000);
	    if (A.getText().equals("Please correct the following\n\n\t- Country should be selected!\n\t- Address should be specified\n\t- Zip Code should be specified\n")){
	    	System.out.println("Country Alert is displayed");
	    }
	    //Accept alert
	    A.accept();
	    Thread.sleep(2000);
	    //Select country from the dropdown
	    //Create WebElelment for Select country
	    WebElement E = d.findElement(By.name("cmbCountry"));
	    Select x = new Select(E);
	    //Selecting country from the dropdown
	    x.selectByVisibleText("India");
	    Thread.sleep(2000);
	    //Click on save
	    objSave.click();
	    Thread.sleep(2000);
	    if (A.getText().equals("Please correct the following\n\n\t- Address should be specified\n\t- Zip Code should be specified\n")){
	    	System.out.println("Address Alert is displayed");
	    }
	    //Verify alert and accept
	    A.accept();
	    Thread.sleep(2000);
	    //Enter address and click on save
	    d.findElement(By.name("txtAddress")).sendKeys("123 temporary road");
	    Thread.sleep(2000);
	    objSave.click();
	    Thread.sleep(2000);
	    if (A.getText().equals("Please correct the following\n\n\t- Zip Code should be specified\n")){
	    	System.out.println("Country Alert is displayed");
	    }
	    //Verify alert and accept it
	    A.accept();
	    //Enter ZIPcode
	    d.findElement(By.name("txtZIP")).sendKeys("123456");
	    Thread.sleep(2000);
	    objSave.click();
	    Thread.sleep(2000);
	    String id = "LOC793";
	    String name = "Mahesh";
	    
	  	WebElement wsel = d.findElement(By.id("loc_code"));
		
		Select sel = new Select(wsel);
		sel.selectByVisibleText("Name");
		d.findElement(By.id("loc_name")).sendKeys(name);
		d.findElement(By.xpath("//input[@class=\"plainbtn\"]")).click();
		
		  //Get row count
		   // int rc=d.findElement(By.xpath("/html/body/div/div[2]/form/table/tbody/tr[39]")).size();
		    int rc=d.findElements(By.xpath("//input[@type=\"checkbox\"][@onclick=\"doHandleAll();\"]")).size();
			int i;
			for(i=1;i<=rc;i++)
			{
		    //Create string for Location ID and Name
			String slid=d.findElement(By.xpath("/html/body/div/div[2]/form/table/tbody/tr[1]/td[2]/a")).getText();
			String slname=d.findElement(By.xpath("/html/body/div/div[2]/form/table/tbody/tr[1]/td[3]/a")).getText();
			//Verify Location ID and Name from the table
			if(slid.equals(id) && slname.equals(name))
			{
				System.out.println(slid+"."+slname+","+"displayed at:"+i);
			}//if
			}//for
		Thread.sleep(2000);
		
		
		
		
		d.close();
		d.quit();
		
	    
	    }//method
	    }//class
	    