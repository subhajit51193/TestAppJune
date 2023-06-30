package com.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Crypto {

	@JsonProperty("time")
	private Time time;
	@JsonProperty("disclaime")
	private String disclaimer;
	@JsonProperty("chartName")
	private String chartName;
	@JsonProperty("bpi")
	private BPI bpi;
}
