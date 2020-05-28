package com.amida.sink.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class InputObject {	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@JsonProperty("firstName")
	private String firstName;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("state")
	private String state;
	
	public InputObject() {};

	public InputObject(Long id, String firstName, String lastName, String state) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
}
