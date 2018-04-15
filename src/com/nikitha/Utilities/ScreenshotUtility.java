package com.nikitha.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.nikitha.automation.base.DriverEngine;

public interface ScreenshotUtility 
{
	public static void Screenshot() throws IOException {
		TakesScreenshot ts =(TakesScreenshot)DriverEngine.getWebDriver();
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File(System.getProperty("user.dir")+"\\Failurescreenshot\\"+DriverEngine.gettcName()+".jpg"));	
		
	}
}
