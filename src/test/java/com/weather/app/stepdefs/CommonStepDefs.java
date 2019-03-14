package com.weather.app.stepdefs;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;

public class CommonStepDefs {
    private final String weatherAppUrl = "https://weather-acceptance.herokuapp.com/";

    public WebDriver driver;

    public CommonStepDefs() {
        driver = Hooks.driver;
    }

    @Given("^the user has opened the Weather App$")
    public void iOpenWeatherApp() throws Throwable {
        driver.get(weatherAppUrl);
    }

}