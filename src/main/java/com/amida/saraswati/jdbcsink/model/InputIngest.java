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

	@JsonProperty("patientFirstName")
	private List<String> firstName;

	@JsonProperty("patientLastName")
	private String lastName;

	@JsonProperty("dateOfBirth")
	private String dateOfBirth;

	@JsonProperty("subscriberId")
	private List<String> subscriberId;

	@JsonProperty("groupId")
	private List<String> groupId;

	@JsonProperty("language")
	private String language;

	@JsonProperty("patientAddress")
	private AddressIngest patientAddress;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("maritalStatus")
	private String maritalStatus;

	@JsonProperty("race")
	private String race;

	@JsonProperty("providerFirstName")
	private List<String> providerFirstName;

	@JsonProperty("providerLastName")
	private String providerLastName;

	@JsonProperty("providerId")
	private String providerId;

	@JsonProperty("providerAddress")
	private AddressIngest providerAddress;

	@JsonProperty("a1c")
	private boolean a1c;

	@JsonProperty("cholesterol")
	private boolean cholesterol;

	@JsonProperty("psa")
	private boolean psa;

	@JsonProperty("leadScreening")
	private boolean leadScreening;

	@JsonProperty("diabetes")
	private boolean diabetes;

	@JsonProperty("fileIndicator")
	private String fileIndicator;

	public InputIngest() {
	};

	public InputIngest(Long id, String lastName, List<String> firstName, String dateOfBirth, List<String> subscriberId,
			List<String> groupId, String language, String race, String gender, String maritalStatus,
			AddressIngest address, List<String> providerFirstName, String providerLastName, String providerId,
			AddressIngest providerAddress, Boolean a1c, Boolean cholesterol, Boolean psa, Boolean leadScreening,
			Boolean diabetes, String fileIndicator) {
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
		this.patientAddress = address;
		this.providerFirstName = providerFirstName;
		this.providerLastName = providerLastName;
		this.providerId = providerId;
		this.providerAddress = providerAddress;
		this.a1c = a1c;
		this.cholesterol = cholesterol;
		this.psa = psa;
		this.leadScreening = leadScreening;
		this.diabetes = diabetes;
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

	public AddressIngest getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(AddressIngest patientAddress) {
		this.patientAddress = patientAddress;
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

	public List<String> getProviderFirstName() {
		return providerFirstName;
	}

	public void setProviderFirstName(List<String> providerFirstName) {
		this.providerFirstName = providerFirstName;
	}

	public String getProviderLastName() {
		return providerLastName;
	}

	public void setProviderLastName(String providerLastName) {
		this.providerLastName = providerLastName;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public AddressIngest getProviderAddress() {
		return providerAddress;
	}

	public void setProviderAddress(AddressIngest providerAddress) {
		this.providerAddress = providerAddress;
	}

	public boolean isA1c() {
		return a1c;
	}

	public void setA1c(boolean a1c) {
		this.a1c = a1c;
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

	public boolean isDiabetes() {
		return diabetes;
	}

	public void setDiabetes(boolean diabetes) {
		this.diabetes = diabetes;
	}

	public String getFileIndicator() {
		return fileIndicator;
	}

	public void setFileIndicator(String fileIndicator) {
		this.fileIndicator = fileIndicator;
	}
}
