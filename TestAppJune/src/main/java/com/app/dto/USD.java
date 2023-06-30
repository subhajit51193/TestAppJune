package com.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class USD {

	@JsonProperty("code")
	private String code;
	@JsonProperty("symbol")
	private String symbol;
	@JsonProperty("rate")
	private String rate;
	@JsonProperty("description")
	private String description;
	@JsonProperty("rate_float")
	private Float rate_float;
}
