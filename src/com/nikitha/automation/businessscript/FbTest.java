package com.nikitha.automation.businessscript;

import org.testng.annotations.Test;

import com.nikitha.automation.base.DriverEngine;

public class FbTest extends DriverEngine
{
	@Test
	public void fbTest()
	{
		getWebDriver().get("https://www.facebook.com");
	}
}
