package testNGWithParameter;
import org.testng.annotations.*;


public class TestNGDataEx {
@Test
@Parameters("strUN")
public void ParameterTest(String strUN)
{
	System.out.println("Paramaterized value is :"+strUN);
}
}