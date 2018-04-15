package com.nikitha.Utilities;

public interface DriverUtilities 
{
	String ChromeKey="webdriver.chrome.driver";
	String ChromeValue=System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
	

	String FirefoxKey="webdriver.gecko.driver";
	String FirefoxValue=System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe";

}
