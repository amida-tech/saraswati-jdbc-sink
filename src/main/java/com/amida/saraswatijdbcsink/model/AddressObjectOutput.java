package com.amida.saraswatijdbcsink.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AddressObjectOutput {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "street")
	private List<String> street;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "zipCode")
	private String zipCode;

	@Column(name = "country")
	private String country;

	public AddressObjectOutput() {
	};

	public AddressObjectOutput(Long id, List<String> street, String city, String state, String zipCode, String country) {
		this.id = id;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
	}

	public AddressObjectOutput convertInputToOutput(AddressObjectIngest input) {
		
		AddressObjectOutput addressOutput = new AddressObjectOutput();
		addressOutput.setStreet(input.getStreet());
		addressOutput.setCity(input.getCity());
		addressOutput.setState(input.getState());
		addressOutput.setZipCode(input.getZipCode());
		addressOutput.setCountry(input.getCountry());
		
		return addressOutput;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
