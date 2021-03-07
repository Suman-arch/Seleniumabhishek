package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base {
	
	public static WebDriver driver;
	public  Properties props;
	
	public static ExtentSparkReporter reporter;
	public static ExtentReports ext;
	
	
	public void generateReport()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web Automation Results");
		
		ExtentReports ext=new ExtentReports();
		ext.attachReporter(reporter);
		ext.setSystemInfo("Tester","Abhishek");
		
	}
//	
    public  static void getScreenshot(String s) throws IOException
    {
    	TakesScreenshot ts=(TakesScreenshot)driver;
    File scrFile=ts.getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(scrFile,new File(System.getProperty("user.dir")+"\\src\\main\\java\\reports\\"+s+".png"));

    }
	public WebDriver Capabilities() throws IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Global.properties");
		props=new Properties();
		props.load(fis);
		String browsername=props.getProperty("browser");
		//String browsername=System.getProperty("browser");
		if(browsername.equalsIgnoreCase("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\a5150\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		return driver;
		
	}
	
}
