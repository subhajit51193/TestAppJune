package com.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BPI {

	@JsonProperty("USD")
	private USD USD;
	@JsonProperty("GBP")
	private GBP GBP;
	@JsonProperty("EUR")
	private EUR EUR;
}
