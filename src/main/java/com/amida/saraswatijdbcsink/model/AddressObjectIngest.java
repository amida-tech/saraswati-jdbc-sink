package com.amida.saraswatijdbcsink.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

//@Entity
public class AddressObjectIngest {

	@JsonProperty("firstName")
	private List<String> street;

	@JsonProperty("city")
	private String city;

	@JsonProperty("state")
	private String state;

	@JsonProperty("zipCode")
	private String zipCode;

	@JsonProperty("country")
	private String country;

	public AddressObjectIngest() {
	};

	public AddressObjectIngest(List<String> street, String city, String state, String zipCode, String country) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
	}

	public List<String> getStreet() {
		return street;
	}

	public void setStreet(List<String> street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
