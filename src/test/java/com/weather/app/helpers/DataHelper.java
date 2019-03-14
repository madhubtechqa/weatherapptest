package com.weather.app.helpers;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.app.model.WeatherTestData;

public class DataHelper {
	private WeatherTestData testData;
	private static final ObjectMapper mapper = new ObjectMapper();
	
	public WeatherTestData getTestData() {
		return testData;
	}

	public void setTestData(WeatherTestData testData) {
		this.testData = testData;
	}

	public DataHelper(String city)
	{
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("data/" + city.toLowerCase() + ".json").getFile());
			
			testData = (WeatherTestData) mapper.readValue(file, WeatherTestData.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	      
	}
}
