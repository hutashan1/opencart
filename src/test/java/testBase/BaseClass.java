package testBase;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass 
{
	public ResourceBundle rb;
	public Logger logger;
	public static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	@Parameters("browser")
	public void setup(String brow)
	{
		rb=ResourceBundle.getBundle("config");
		 // to load config files
		logger=LogManager.getLogger(this.getClass()); // for logging the logs for each test case
		
		if(brow.equals("chrome"))
		{
		
		driver=new ChromeDriver();
		}
		
		else if(brow.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		
		
	//	driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//driver.get(rb.getString("appURL")); appURL for registration
		driver.get(rb.getString("appURL2"));
		driver.manage().window().maximize();
	}
	public String capureScreen(String tname)
	{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyymmddhhmmss");
			Date dt=new Date();
			String timestamp=sdf.format(dt);
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timestamp + ".png";

			try {
				FileUtils.copyFile(source, new File(destination));
			} catch (Exception e) {
				e.getMessage();
			}
			return destination;
			
	}
	
	@AfterClass
	 void tearDown()
	{
		driver.quit();
	}

}
