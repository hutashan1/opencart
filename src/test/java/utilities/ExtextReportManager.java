package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testBase.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtextReportManager implements ITestListener
{
	ExtentSparkReporter sparkReporter;
	ExtentReports extent;
	ExtentTest test;
	String repname;
	public void onStart(ITestContext context)
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		repname="Test-report- "+timeStamp+ ".html";
		
		
		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repname);//specify location of report
		
		sparkReporter.config().setDocumentTitle("Opencart automation report");
		sparkReporter.config().setReportName("opencart fuctional testing");
		sparkReporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("computer name", "LocalHost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester name", "hutashan");
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Browser name", "chrome,firefox,edge");
		
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.PASS, "This test is passed"+result.getName());
	}		
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "This test is failed "+result.getName());
		test.log(Status.FAIL, "This test is failed because "+result.getThrowable());
		
		try
		{
				String  imgpath=new BaseClass().capureScreen(result.getName());
				test.addScreenCaptureFromPath(imgpath);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "This test is SKIPed "+result.getName());
		test.log(Status.SKIP, "This test is  SKIPed "+result.getThrowable());
	}	
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
}
