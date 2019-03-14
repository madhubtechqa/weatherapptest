package com.weather.app.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", 
				plugin = { "pretty", "html:target/cucumber-html-report" }, 
				tags = {"@weatherApp"},
				glue = "com.weather.app.stepdefs")
public class TestRunner {
}