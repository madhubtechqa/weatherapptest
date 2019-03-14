package com.weather.app.stepdefs;

import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Logger;

import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    private static final Logger LOG = Logger.getLogger(Hooks.class.getName());
    public static WebDriver driver;

    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openBrowser() throws MalformedURLException {
        LOG.info("Launching Chrome.");
        setChromeDriverEnvironmentProperties();

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }


    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }

        }

        closeBrowser();
    }

    /**
     * Method to Close the browser
     */
    private void closeBrowser() {
        driver.quit();
        LOG.info("Chrome Closed.");
    }

    /**
     * Method to configure chrome driver properties
     */
    private void setChromeDriverEnvironmentProperties() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("chromedriver.exe").getFile());

        System.setProperty("webdriver.chrome.driver", file.getPath());
    }

}