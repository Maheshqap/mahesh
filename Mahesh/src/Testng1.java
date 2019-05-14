import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testng1 {

	@Test(priority=2)
	public void Mehod1()
	{
		System.out.println("Method1");
	}
		@Test(priority=1)
		public void Method2()
		{
			System.out.println("Method2");
		}
		@BeforeClass
		public void Methoid()
		{
			System.out.println("Hi");
		}
		@AfterClass
		public void Meth()
		{
			System.out.println("Hello");
		}
		@BeforeMethod
		public void me()
		{
			System.out.println("I execute before every method");
		}
		@AfterMethod
		public void praveena()
		{
			System.out.println("I execute after every method");
		}
		
	}

