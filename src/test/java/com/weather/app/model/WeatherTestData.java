package com.weather.app.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "city", "cod", "message", "cnt", "list" })
public class WeatherTestData {

	@JsonProperty("city")
	private City city;
	@JsonProperty("cod")
	private String cod;
	@JsonProperty("message")
	private Double message;
	@JsonProperty("cnt")
	private Integer cnt;
	@JsonProperty("list")
	private List<Hour> hoursList = null;

	@JsonProperty("city")
	public City getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(City city) {
		this.city = city;
	}

	@JsonProperty("cod")
	public String getCod() {
		return cod;
	}

	@JsonProperty("cod")
	public void setCod(String cod) {
		this.cod = cod;
	}

	@JsonProperty("message")
	public Double getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(Double message) {
		this.message = message;
	}

	@JsonProperty("cnt")
	public Integer getCnt() {
		return cnt;
	}

	@JsonProperty("cnt")
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	@JsonProperty("list")
	public List<Hour> getHours() {
		return hoursList;
	}

	@JsonProperty("list")
	public void setHoursList(List<Hour> daysList) {
		this.hoursList = daysList;
	}

}
