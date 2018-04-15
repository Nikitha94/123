package com.nikitha.automation.businessscript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.nikitha.automation.base.DriverEngine;

public class gmail extends DriverEngine
{
	@Test
	public void gmailTest()
	{
		getWebDriver().get("https://www.gmail.com");
		getWebDriver().findElement(By.id("abgc")).sendKeys("oiy");
	}
}
