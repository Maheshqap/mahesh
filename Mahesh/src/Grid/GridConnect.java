package Grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.sun.org.apache.xerces.internal.impl.io.MalformedByteSequenceException;

public class GridConnect {
	
	WebDriver driver;
	
	@Test(priority=1)
	void setUp() throws MalformedByteSequenceException
	{
		String node = "http://192.168.0.105.49006";
		DesiredCapabilities des = DesiredCapabilities.chrome();
		des.setPlatform(platform);
	}
}
