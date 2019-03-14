package com.weather.app.pageobject;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

public class WeatherAppPage extends BasePage {

    private static final Logger LOG = Logger.getLogger(WeatherAppPage.class.getName());

    public WeatherAppPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "city")
    public static WebElement city;

    @FindBys({
            @FindBy(how = How.CSS, using = "[data-test^=day-]")
    })
    public static List<WebElement> dayForecasts;

    @FindBys({
            @FindBy(how = How.CSS, using = "[data-test^=hour-]")
    })
    public static List<WebElement> hourForecasts;

    @FindBys({
            @FindBy(how = How.CSS, using = ".summary [data-test^=description-]")
    })
    public static List<WebElement> headerDescription;

    @FindBys({
            @FindBy(how = How.CSS, using = ".details [data-test^=description-]")
    })
    public static List<WebElement> detailsDescription;

    @FindBys({
            @FindBy(how = How.CSS, using = ".summary [data-test^=maximum-]")
    })
    public static List<WebElement> headerMaximum;

    @FindBys({
            @FindBy(how = How.CSS, using = ".details [data-test^=maximum-]")
    })
    public static List<WebElement> detailsMaximum;

    @FindBys({
            @FindBy(how = How.CSS, using = ".summary [data-test^=minimum-]")
    })
    public static List<WebElement> headerMinimum;

    @FindBys({
            @FindBy(how = How.CSS, using = ".details [data-test^=minimum-]")
    })
    public static List<WebElement> detailsMinimum;

    @FindBys({
            @FindBy(how = How.CSS, using = ".summary [data-test^=speed-]")
    })
    public static List<WebElement> headerSpeed;

    @FindBys({
            @FindBy(how = How.CSS, using = ".details [data-test^=speed-]")
    })
    public static List<WebElement> detailsSpeed;

    @FindBys({
            @FindBy(how = How.CSS, using = ".summary [data-test^=direction-] svg")
    })
    public static List<WebElement> headerDirection;

    @FindBys({
            @FindBy(how = How.CSS, using = ".details [data-test^=direction-] svg")
    })
    public static List<WebElement> detailsDirection;

    @FindBys({
            @FindBy(how = How.CSS, using = ".summary [data-test^=rainfall-]")
    })
    public static List<WebElement> headerRainfall;

    @FindBys({
            @FindBy(how = How.CSS, using = ".details [data-test^=rainfall-]")
    })
    public static List<WebElement> detailsRainfall;


}