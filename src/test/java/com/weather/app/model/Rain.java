package com.weather.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "3h" })
public class Rain {

	@JsonProperty("3h")
	private Double threeH;

	@JsonProperty("3h")
	public Double get3h() {
		return threeH;
	}

	@JsonProperty("3h")
	public void set3h(Double threeH) {
		this.threeH = threeH;
	}
}
