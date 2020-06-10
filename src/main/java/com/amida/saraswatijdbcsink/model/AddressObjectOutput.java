package com.amida.saraswatijdbcsink.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.array.StringArrayType;

@Entity
@Table(name="address")
@TypeDefs({
    @TypeDef(
        name = "string-array",
        typeClass = StringArrayType.class
    )
})
public class AddressObjectOutput {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Type(type = "string-array")
	@Column(name = "street", columnDefinition = "text[]")
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

	public List<AddressObjectOutput> convertInputToOutput(AddressObjectIngest input) {
		
		AddressObjectOutput outputObject = new AddressObjectOutput();
		outputObject.setStreet(input.getStreet());
		outputObject.setCity(input.getCity());
		outputObject.setState(input.getState());
		outputObject.setZipCode(input.getZipCode());
		outputObject.setCountry(input.getCountry());
		List<AddressObjectOutput> output = new ArrayList<AddressObjectOutput>(Arrays.asList(outputObject));
		
		return output;
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
