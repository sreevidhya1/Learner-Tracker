package ictak.learnertracker.test;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class SetUpTest {
	WebDriver driver;
	
	public static Properties prop= null;
	@BeforeMethod
	public void set() throws IOException {
		prop= new Properties();
		FileInputStream inputfile = new FileInputStream("D:\\eclipse\\workspace\\digitalresume\\LeanerTracker\\src\\test\\resources\\Folder\\config.properties");
	     prop.load(inputfile);
           driver =new ChromeDriver();

		driver.get(prop.getProperty("url"));

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
	}
	@AfterMethod
	public void afterTest() throws InterruptedException
	{
	Thread.sleep(5000);
	driver.quit();
	}

}
