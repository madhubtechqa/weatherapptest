package com.weather.app.stepdefs;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;

public class BrowserStepDefs{
	private final String weatherAppUrl = "https://weather-acceptance.herokuapp.com/";

	public WebDriver driver;
    
    public BrowserStepDefs()
    {
    	driver = Hooks.driver;
    }
    
    @Given("^the user has opened the Weather App$")
    public void iOpenWeatherApp() throws Throwable {
    	driver.get(weatherAppUrl);
    }
    
}