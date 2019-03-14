package com.weather.app.pageobject;

import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public abstract class BasePage {
    private static final Logger LOG = Logger.getLogger(BasePage.class.getName());

    public static WebDriver driver;
    public static boolean bResult;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        BasePage.bResult = true;
    }

}
