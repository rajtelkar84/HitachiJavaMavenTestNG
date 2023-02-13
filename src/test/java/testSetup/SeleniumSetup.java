package testSetup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import testData.DataProviders;
import utility.Constants;


public class SeleniumSetup extends DataProviders{
	
	public static WebDriver driver = null;

	@BeforeSuite
	public void assemblyintialise()
	{
		// do all operation which require before test actually initialize
		System.out.println("Before Suite");		
	}

	@BeforeMethod
	public void testinitialise()
	{
		// Here just update path of your chrome driver
		System.setProperty("webdriver.chrome.driver", "/Users/rajkumar.t/Downloads/chromedriver");
		
	    driver = new ChromeDriver();
	//driver.manage().window().maximize(); // for windows
	  driver.manage().window().fullscreen(); // for Mac
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(Constants.URL);
	}
	
	@AfterMethod
	public void testcleanup()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void assemblycleanup()
	{
		System.out.println("After Suite");
	}	
}
