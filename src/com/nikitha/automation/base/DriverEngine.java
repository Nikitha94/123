package com.nikitha.automation.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.nikitha.Utilities.DriverUtilities;
import com.nikitha.Utilities.ScreenshotUtility;

public class DriverEngine 
{	
	private static WebDriver driver;
	private static String tcName;
	@Parameters("browser")
	@BeforeSuite
	public void openBrowser(String browser) 
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty(DriverUtilities.ChromeKey,DriverUtilities.ChromeValue);
			driver = new ChromeDriver();
			init();	
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			init();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			driver = new InternetExplorerDriver();
			init();
		}
		else
		{
			System.out.println("pass proper parameters");
		}		
	}
	@AfterSuite
	public void closeBrowser()
	{
		if(driver!=null)
		driver.close();
		else
			System.out.println("pointing to null...");
	}
	public void init()
	{
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	
	}
	static public WebDriver getWebDriver()
	{
		return driver;
	}
	@BeforeMethod
	public  void beforeTcExecution(Method method)
	{
		String tcName = method.getName();
		System.out.println("current executing testcase :"+tcName);	
	}
	@AfterMethod
	public void afterExecution(ITestResult result) throws IOException
	{
	    String tcName = result.getName();
	    if(result.getStatus()==ITestResult.FAILURE)
	    {
	    	System.out.println(tcName +" test case is failed");
	    	ScreenshotUtility.Screenshot();
		/*TakesScreenshot ts =(TakesScreenshot)getWebDriver();
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File(System.getProperty("user.dir")+"\\Failurescreenshot\\"+tcName+".jpg"));*/
	    }
	    else if(result.getStatus()==ITestResult.SUCCESS)
	    	System.out.println(tcName+" test case is success");
	    else if(result.getStatus()==ITestResult.SKIP)
	    {
	    	System.out.println(tcName);
			TakesScreenshot ts =(TakesScreenshot)getWebDriver();
			File file = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file,new File(System.getProperty("user.dir")+"\\Failurescreenshot\\"+tcName+".jpg"));	
	    }
	}
	  public static String gettcName() 
	   {
		   return tcName;	
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	

