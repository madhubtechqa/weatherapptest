package com.weather.app.pageobject;

import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public abstract class BaseClass {
	private static final Logger LOG = Logger.getLogger(BaseClass.class.getName());

	public static WebDriver driver;
	public static boolean bResult;

	public BaseClass(WebDriver driver){
		BaseClass.driver = driver;
		BaseClass.bResult = true;
	}

}
