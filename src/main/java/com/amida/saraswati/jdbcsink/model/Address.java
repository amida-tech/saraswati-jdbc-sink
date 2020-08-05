package com.amida.saraswati.jdbcsink.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.amida.saraswati.jdbcsink.utils.Utils;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ElementCollection
	@CollectionTable(name = "address_street", joinColumns = @JoinColumn(name = "address_id"))
	@Column(name = "street")
	private Set<String> street;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "zip_code")
	private String zipCode;

	@Column(name = "country")
	private String country;
	
	@Column(name = "patient_address_flag")
	private boolean patientAddressFlag;

	public Address() {
	};

	public Address(Long id, Set<String> street, String city, String state, String zipCode, String country, boolean patientAddressFlag) {
		this.id = id;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
		this.patientAddressFlag = patientAddressFlag;
	}
	
	public List<Address> convertInputToOutputPatient(AddressIngest input) {

		Address outputObject = new Address();

		Set<String> streets = Utils.convertListToSet(input.getStreet());

		outputObject.setStreet(streets);
		outputObject.setCity(input.getCity());
		outputObject.setState(input.getState());
		outputObject.setZipCode(input.getZipCode());
		outputObject.setCountry(input.getCountry());
		outputObject.setPatientAddressFlag(true);
		
		List<Address> output = new ArrayList<Address>(Arrays.asList(outputObject));

		return output;
	}
	
	public List<Address> convertInputToOutputProvider(AddressIngest input) {

		Address outputObject = new Address();

		Set<String> streets = Utils.convertListToSet(input.getStreet());

		outputObject.setStreet(streets);
		outputObject.setCity(input.getCity());
		outputObject.setState(input.getState());
		outputObject.setZipCode(input.getZipCode());
		outputObject.setCountry(input.getCountry());
		
		List<Address> output = new ArrayList<Address>(Arrays.asList(outputObject));

		return output;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<String> getStreet() {
		return street;
	}

	public void setStreet(Set<String> street) {
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

	public boolean isPatientAddressFlag() {
		return patientAddressFlag;
	}

	public void setPatientAddressFlag(boolean patientAddressFlag) {
		this.patientAddressFlag = patientAddressFlag;
	}
	
	

}
