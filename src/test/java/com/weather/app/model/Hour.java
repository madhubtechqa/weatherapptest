package com.weather.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "dt", "main", "weather", "clouds", "wind", "rain", "sys", "dt_txt" })
public class Hour {

	@JsonProperty("dt")
	private Integer dt;
	@JsonProperty("main")
	private Main main;
	@JsonProperty("weather")
	private java.util.List<Weather> weather = null;
	@JsonProperty("clouds")
	private Clouds clouds;
	@JsonProperty("wind")
	private Wind wind;
	@JsonProperty("rain")
	private Rain rain;
	@JsonProperty("sys")
	private PodSys sys;
	@JsonProperty("dt_txt")
	private String dtTxt;

	@JsonProperty("dt")
	public Integer getDt() {
		return dt;
	}

	@JsonProperty("dt")
	public void setDt(Integer dt) {
		this.dt = dt;
	}

	@JsonProperty("main")
	public Main getMain() {
		return main;
	}

	@JsonProperty("main")
	public void setMain(Main main) {
		this.main = main;
	}

	@JsonProperty("weather")
	public java.util.List<Weather> getWeather() {
		return weather;
	}

	@JsonProperty("weather")
	public void setWeather(java.util.List<Weather> weather) {
		this.weather = weather;
	}

	@JsonProperty("clouds")
	public Clouds getClouds() {
		return clouds;
	}

	@JsonProperty("clouds")
	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	@JsonProperty("wind")
	public Wind getWind() {
		return wind;
	}

	@JsonProperty("wind")
	public void setWind(Wind wind) {
		this.wind = wind;
	}

	@JsonProperty("rain")
	public Rain getRain() {
		return rain;
	}

	@JsonProperty("rain")
	public void setRain(Rain rain) {
		this.rain = rain;
	}

	@JsonProperty("sys")
	public PodSys getSys() {
		return sys;
	}

	@JsonProperty("sys")
	public void setSys(PodSys sys) {
		this.sys = sys;
	}

	@JsonProperty("dt_txt")
	public String getDtTxt() {
		return dtTxt;
	}

	@JsonProperty("dt_txt")
	public void setDtTxt(String dtTxt) {
		this.dtTxt = dtTxt;
	}}
