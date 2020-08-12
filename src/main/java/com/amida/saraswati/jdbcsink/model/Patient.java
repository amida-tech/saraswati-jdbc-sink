package com.amida.saraswati.jdbcsink.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.amida.saraswati.jdbcsink.utils.Utils;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ElementCollection
	@CollectionTable(name = "patient_first_name", joinColumns = @JoinColumn(name = "patient_id"))
	@Column(name = "patient_first_name")
	private List<String> firstName = new ArrayList<>();

	@Column(name = "patient_last_name")
	private String lastName;

	@Column(name = "patient_last_name_lowercase")
	@JsonIgnore
	private String lastNameLowercase;

	@Column(name = "date_of_birth")
	private String dateOfBirth;

	@ElementCollection
	@CollectionTable(name = "patient_subscriber_id", joinColumns = @JoinColumn(name = "patient_id"))
	@Column(name = "subscriber_id")
	private Set<String> subscriberId;

	@ElementCollection
	@CollectionTable(name = "patient_group_id", joinColumns = @JoinColumn(name = "patient_id"))
	@Column(name = "group_id")
	private Set<String> groupId;

	@Column(name = "language")
	private String language;

	@Column(name = "race")
	private String race;

	@Column(name = "gender")
	private String gender;

	@Column(name = "marital_status")
	private String maritalStatus;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "address", referencedColumnName = "id")
	private List<Address> patientAddress;

	@ElementCollection
	@CollectionTable(name = "provider_first_name", joinColumns = @JoinColumn(name = "patient_id"))
	@Column(name = "provider_first_name")
	private List<String> providerFirstName;

	@Column(name = "provider_last_name")
	private String providerLastName;

	@Column(name = "provider_last_name_lowercase")
	@JsonIgnore
	private String providerLastNameLowercase;

	@ElementCollection
	@CollectionTable(name = "provider_id", joinColumns = @JoinColumn(name = "patient_id"))
	@Column(name = "provider_id")
	private Set<String> providerId;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "address", referencedColumnName = "id")
	private List<Address> providerAddress;

	@Column(name = "a1c")
	private Boolean a1c;

	@Column(name = "cholesterol")
	private Boolean cholesterol;

	@Column(name = "psa")
	private Boolean psa;

	@Column(name = "lead_screening")
	private Boolean leadScreening;

	@Column(name = "diabetes")
	private Boolean diabetes;

	@Column(name = "file_indicator")
	private String fileIndicator;

	public Patient() {
	};

	public Patient(Long id, List<String> firstName, String lastName, String dateOfBirth, Set<String> subscriberId,
			Set<String> groupId, String language, String race, String gender, String maritalStatus,
			List<Address> patientAddress, List<String> providerFirstName, String providerLastName,
			Set<String> providerId, List<Address> providerAddress, Boolean a1c, Boolean cholesterol, Boolean psa,
			Boolean leadScreening, Boolean diabetes, String fileIndicator) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastNameLowercase = lastName.toLowerCase();
		this.dateOfBirth = dateOfBirth;
		this.subscriberId = subscriberId;
		this.groupId = groupId;
		this.language = language;
		this.race = race;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.patientAddress = patientAddress;
		this.providerFirstName = providerFirstName;
		this.providerLastName = providerLastName;
		this.providerLastNameLowercase = providerLastName.toLowerCase();
		this.providerId = providerId;
		this.providerAddress = providerAddress;
		this.a1c = a1c;
		this.cholesterol = cholesterol;
		this.psa = psa;
		this.leadScreening = leadScreening;
		this.diabetes = diabetes;
		this.fileIndicator = fileIndicator;
	}

	public Patient convertInputToPatient(InputIngest input) {
		Patient output = new Patient();

		Set<String> groupIds = Utils.convertListToSet(input.getGroupId());
		Set<String> subscriberIds = Utils.convertListToSet(input.getSubscriberId());

		output.setFirstName(input.getFirstName());
		output.setLastName(input.getLastName());
		output.setDateOfBirth(input.getDateOfBirth());
		output.setGroupId(groupIds);
		output.setSubscriberId(subscriberIds);
		output.setRace(input.getRace());
		output.setGender(input.getGender());
		output.setMaritalStatus(input.getMaritalStatus());
		output.setFileIndicator(input.getFileIndicator());
		
		//Provider mapping
		Set<String> providerIds = new HashSet<String>();
		providerIds.add(input.getProviderId());
		
		output.setProviderAddress(providerAddress);
		output.setProviderFirstName(input.getProviderFirstName());
		output.setProviderId(providerIds);
		output.setProviderLastName(input.getProviderLastName());

		// Run address converter
		Address patientAddressConverter = new Address();
		List<Address> patientAddressOutput = new ArrayList<Address>();
		patientAddressOutput = patientAddressConverter.convertInputToOutputPatient(input.getPatientAddress());
		output.setPatientAddress(patientAddressOutput);

		Address providerAddressConverter = new Address();
		List<Address> providerAddressOutput = new ArrayList<Address>();
		providerAddressOutput = providerAddressConverter.convertInputToOutputProvider(input.getProviderAddress());
		output.setProviderAddress(providerAddressOutput);

		// Booleans
		output.setA1c(input.isA1c());
		output.setCholesterol(input.isCholesterol());
		output.setPsa(input.isPsa());
		output.setLeadScreening(input.isLeadScreening());

		return output;
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
		this.lastNameLowercase = lastName.toLowerCase();
	}

	public String getLastNameLowercase() {
		return lastNameLowercase;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Set<String> getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(Set<String> subscriberId) {
		this.subscriberId = subscriberId;
	}

	public Set<String> getGroupId() {
		return groupId;
	}

	public void setGroupId(Set<String> groupId) {
		this.groupId = groupId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
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

	public List<Address> getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(List<Address> patientAddress) {
		this.patientAddress = patientAddress;
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
		this.providerLastNameLowercase = providerLastName.toLowerCase();
	}

	public String getProviderLastNameLowercase() {
		return providerLastNameLowercase;
	}

	public Set<String> getProviderId() {
		return providerId;
	}

	public void setProviderId(Set<String> providerId) {
		this.providerId = providerId;
	}

	public List<Address> getProviderAddress() {
		return providerAddress;
	}

	public void setProviderAddress(List<Address> providerAddress) {
		this.providerAddress = providerAddress;
	}

	public Boolean getA1c() {
		return a1c;
	}

	public void setA1c(Boolean a1c) {
		this.a1c = a1c;
	}

	public Boolean getCholesterol() {
		return cholesterol;
	}

	public void setCholesterol(Boolean cholesterol) {
		this.cholesterol = cholesterol;
	}

	public Boolean getPsa() {
		return psa;
	}

	public void setPsa(Boolean psa) {
		this.psa = psa;
	}

	public Boolean getLeadScreening() {
		return leadScreening;
	}

	public void setLeadScreening(Boolean leadScreening) {
		this.leadScreening = leadScreening;
	}

	public Boolean getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(Boolean diabetes) {
		this.diabetes = diabetes;
	}

	public String getFileIndicator() {
		return fileIndicator;
	}

	public void setFileIndicator(String fileIndicator) {
		this.fileIndicator = fileIndicator;
	}

}
