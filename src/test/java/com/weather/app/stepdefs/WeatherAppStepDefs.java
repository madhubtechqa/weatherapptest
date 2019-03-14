package com.weather.app.stepdefs;

import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.weather.app.helpers.DataHelper;
import com.weather.app.model.Hour;
import com.weather.app.model.WeatherTestData;
import com.weather.app.pageobject.WeatherAppPage;

import static org.testng.AssertJUnit.assertTrue;
import static org.awaitility.Awaitility.await;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static org.testng.AssertJUnit.assertEquals;

@RunWith(Cucumber.class)
public class WeatherAppStepDefs {
    private WebDriver driver;
    private WeatherTestData data;

    public WeatherAppStepDefs() {
        driver = Hooks.driver;
        PageFactory.initElements(driver, WeatherAppPage.class);
    }

    @When("^the user selects the city of \"([^\"]*)\"$")
    public void selectTheCity(String city) throws Throwable {
        WeatherAppPage.city.clear();
        WeatherAppPage.city.sendKeys(city);
        WeatherAppPage.city.sendKeys(Keys.RETURN);

        data = (new DataHelper(city)).getTestData();
    }

    @When("^the user clicks (?:again |)on day (.+)$")
    public void clickAgainOnDay(int day) throws Throwable {
        WeatherAppPage.dayForecasts.get(day - 1).click();
    }

    @When("^a 5 day forecast is displayed$")
    public void a5DayForecastIsDisplayed() throws Throwable {
        for (int dayCounter = 0; dayCounter < 5; dayCounter++) {
            assertTrue("Day " + dayCounter + " is displayed.",
                    WeatherAppPage.dayForecasts.get(dayCounter).isDisplayed());
        }
    }

    @Then("^a 3 hourly forecast is displayed$")
    public void a3HourlyForecastIsDisplayed() throws Throwable {
        assertTrue("Hourly forcasts are displayed.",
                !getDisplayedWebElements(WeatherAppPage.hourForecasts).isEmpty());
    }

    @Then("^a 3 hourly forecast is not shown$")
    public void a3HourlyForecastIsNotShown() throws Throwable {
        // sync issue with open/close click requires await utility to
        await("Hourly forcasts are not displayed.").atMost(2, SECONDS).until(hourForecastNotShown());
    }

    @Then("^the daily forecast shows the current Weather condition$")
    public void theDailyForecastShowsTheCurrentWeatherCondition() throws Throwable {
        assertEquals("Daily forecast shows the current Weather condition",
                getDisplayedWebElements(WeatherAppPage.headerDescription).get(0).getAttribute("aria-label"),
                getDisplayedWebElements(WeatherAppPage.detailsDescription).get(0).getAttribute("aria-label"));
    }

    @Then("^the daily forecast shows the current wind speed$")
    public void theDailyForecastShowsTheCurrentWindSpeedAndDirection() throws Throwable {
        assertEquals("Daily forecast shows the current wind speed",
                getDisplayedWebElements(WeatherAppPage.headerSpeed).get(0).getText(),
                getDisplayedWebElements(WeatherAppPage.detailsSpeed).get(0).getText());
    }

    @Then("^the daily forecast shows the current wind direction$")
    public void theDailyForecastShowsTheCurrentWindDirection() throws Throwable {
        assertEquals("Daily forecast shows the current wind speed",
                getDisplayedWebElements(WeatherAppPage.headerDirection).get(0).getAttribute("style"),
                getDisplayedWebElements(WeatherAppPage.detailsDirection).get(0).getAttribute("style"));
    }

    @Then("^the daily forecast shows the aggregate rainfall$")
    public void theDailyForecastShowsTheAggregateRainfall() throws Throwable {
        assertEquals("Daily forecast shows the aggregate rainfall",
                getDisplayedWebElements(WeatherAppPage.headerRainfall).get(0).getText().replaceAll("mm", ""),
                String.valueOf(collectAggregateRainfall()));
    }

    @Then("^the daily forecast shows the minimum temperature for the day$")
    public void theDailyForecastShowsTheMinimumTemperatures() throws Throwable {
        assertEquals("Daily forecast shows the minimum temperature for the day",
                getTemperature(WeatherAppPage.headerMinimum.get(0).getText()), getMinimum());
    }

    @Then("^the daily forecast shows the maximum temperature for the day$")
    public void theDailyForecastShowsTheMaximumTemperatures() throws Throwable {
        assertEquals("Daily forecast shows the maximum temperature for the day",
                getTemperature(WeatherAppPage.headerMaximum.get(0).getText()), getMaximum());
    }

    @Then("^values displayed are rounded down$")
    public void valuesRoundedDown() throws Throwable {
        List<Hour> dataHours = data.getHours();

        List<WebElement> maximiOnPage = getDisplayedWebElements(WeatherAppPage.detailsMaximum);
        List<WebElement> minimiOnPage = getDisplayedWebElements(WeatherAppPage.detailsMinimum);

        for (int hoursCounter = 0; hoursCounter < maximiOnPage.size(); hoursCounter++) {
            Double dataMaxTemp = dataHours.get(hoursCounter).getMain().getTempMax();
            Double dataMinTemp = dataHours.get(hoursCounter).getMain().getTempMin();

            int maxTempOnPage = getTemperature(maximiOnPage.get(hoursCounter).getText());
            int minTempOnPage = getTemperature(minimiOnPage.get(hoursCounter).getText());

            assertEquals("Maximum Temperature from Data: " + dataMaxTemp,
                    ((Double) Math.floor(dataMaxTemp)).intValue(),
                    maxTempOnPage);

            assertEquals("Minimum Temperature from Data: " + dataMinTemp,
                    ((Double) Math.floor(dataMinTemp)).intValue(),
                    minTempOnPage);
        }
    }

    private List<WebElement> getDisplayedWebElements(List<WebElement> elements) {
        List<WebElement> displayedElements = new ArrayList<WebElement>();

        for (WebElement element : elements) {
            if (element.isDisplayed()) {
                displayedElements.add(element);
            }
        }

        return displayedElements;
    }

    private int collectAggregateRainfall() {
        int aggreagateRainfall = 0;

        for (WebElement rainfall : getDisplayedWebElements(WeatherAppPage.detailsRainfall)) {
            aggreagateRainfall += Integer.valueOf(rainfall.getText().replaceAll("mm", ""));
        }

        return aggreagateRainfall;
    }

    private int getMinimum() {
        int foundMinimum = 99;

        for (WebElement minimum : getDisplayedWebElements(WeatherAppPage.detailsMinimum)) {
            int thisMinimum = getTemperature(minimum.getText());

            if (foundMinimum > thisMinimum) {
                foundMinimum = thisMinimum;
            }
        }

        return foundMinimum;
    }

    private int getMaximum() {
        int foundMaximus = -99;

        for (WebElement maximus : getDisplayedWebElements(WeatherAppPage.detailsMaximum)) {
            int thisMax = getTemperature(maximus.getText());

            if (foundMaximus < thisMax) {
                foundMaximus = thisMax;
            }
        }

        return foundMaximus;
    }

    private int getTemperature(String text) {
        return Integer.valueOf(text.replaceAll("[^-?0-9]+", ""));
    }

    private Callable<Boolean> hourForecastNotShown() {
        return new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return Boolean.valueOf(getDisplayedWebElements(WeatherAppPage.hourForecasts).isEmpty());
            }
        };
    }

}