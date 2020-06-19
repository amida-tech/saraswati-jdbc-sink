package com.amida.saraswati.jdbcsink.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InputIngest {	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@JsonProperty("firstName")
	private List<String> firstName;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("dateOfBirth")
	private String dateOfBirth;
	
	@JsonProperty("subscriberId")
	private List<String> subscriberId;
	
	@JsonProperty("groupId")
	private List<String> groupId;
	
	@JsonProperty("language")
	private String language;
	
	@JsonProperty("address")
	private AddressIngest address;
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("maritalStatus")
	private String maritalStatus;
	
	@JsonProperty("race")
	private String race;
	
	@JsonProperty("alc")
	private boolean alc;
	
	@JsonProperty("cholesterol")
	private boolean cholesterol;
	
	@JsonProperty("psa")
	private boolean psa;
	
	@JsonProperty("leadScreening")
	private boolean leadScreening;
	
	@JsonProperty("fileIndicator")
	private String fileIndicator;
	
	
	public InputIngest() {};

	public InputIngest(Long id, String lastName, List<String> firstName, String dateOfBirth, List<String> subscriberId, List<String> groupId, String language, String race, String gender, String maritalStatus, AddressIngest address, Boolean alc, Boolean cholesterol, Boolean psa, Boolean leadScreening, String fileIndicator) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.subscriberId = subscriberId;
		this.groupId = groupId;
		this.language = language;
		this.race = race;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.address = address;
		this.alc = alc;
		this.cholesterol = cholesterol;
		this.psa = psa;
		this.leadScreening = leadScreening;
		this.fileIndicator = fileIndicator;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getFirstName() {
		return firstName;
	}

	public void setFirstName(List<String> firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<String> getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(List<String> subscriberId) {
		this.subscriberId = subscriberId;
	}

	public List<String> getGroupId() {
		return groupId;
	}

	public void setGroupId(List<String> groupId) {
		this.groupId = groupId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public AddressIngest getAddress() {
		return address;
	}

	public void setAddress(AddressIngest address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public boolean isAlc() {
		return alc;
	}

	public void setAlc(boolean alc) {
		this.alc = alc;
	}

	public boolean isCholesterol() {
		return cholesterol;
	}

	public void setCholesterol(boolean cholesterol) {
		this.cholesterol = cholesterol;
	}

	public boolean isPsa() {
		return psa;
	}

	public void setPsa(boolean psa) {
		this.psa = psa;
	}

	public boolean isLeadScreening() {
		return leadScreening;
	}

	public void setLeadScreening(boolean leadScreening) {
		this.leadScreening = leadScreening;
	}

	public String getFileIndicator() {
		return fileIndicator;
	}

	public void setFileIndicator(String fileIndicator) {
		this.fileIndicator = fileIndicator;
	}

	
}
