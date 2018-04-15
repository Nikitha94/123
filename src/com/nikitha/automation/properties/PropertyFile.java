package com.nikitha.automation.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile 
{
	public static void main(String[] args) throws IOException
	{
		Properties properties = new Properties();
		FileInputStream fip = new FileInputStream("F:\\selenium\\Automation\\config.properties");
		properties.load(fip);
		properties.setProperty("name","nikitha");
		FileOutputStream fop = new FileOutputStream("F:\\selenium\\Automation\\config.properties");
		properties.store(fop, null);
		
		 String gmailpwd = properties.getProperty("gmail_pwd");
		 System.out.println(gmailpwd);
		 
		 String name = properties.getProperty("name");
		 System.out.println(name);
		 
		 /*FileInputStream fip1 = new FileInputStream("F:\\selenium\\Automation\\config.properties");
		 properties.load(fip1);
		 properties.remove(name);
		 FileOutputStream fop1 = new FileOutputStream("F:\\selenium\\Automation\\config.properties");
			properties.store(fop1, null);*/
			
			/*FileInputStream fip2 = new FileInputStream("F:\\selenium\\Automation\\OR.properties");
			properties.load(fip2);
			properties.setProperty(gmailpwd,"123456");
			FileOutputStream fop2 = new FileOutputStream("F:\\selenium\\Automation\\OR.properties");;
			properties.store(fop2, null);*/
	}

}

