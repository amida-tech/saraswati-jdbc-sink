package com.amida.saraswati.jdbcsink.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.amida.saraswati.jdbcsink.utils.Utils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.array.StringArrayType;

@TypeDefs({ @TypeDef(name = "string-array", typeClass = StringArrayType.class) })
@Entity
@Table(name ="patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Type(type = "string-array")
	@Column(name = "firstName", columnDefinition = "text[]")
	private String[] firstName;

	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "lastNameLowercase")
	@JsonIgnore
	private String lastNameLowercase;

	@Column(name = "dateOfBirth")
	private String dateOfBirth;

	@Type(type = "string-array")
	@Column(name = "subscriberId", columnDefinition = "text[]")
	private String[] subscriberId;

	@Type(type = "string-array")
	@Column(name = "groupId", columnDefinition = "text[]")
	private String[] groupId;

	@Column(name = "language")
	private String language;
	
	@Column(name = "race")
	private String race;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "maritalStatus")
	private String maritalStatus;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "address", referencedColumnName = "id")
	private List<AddressOutput> address;

	@Column(name = "a1c")
	private Boolean a1c;

	@Column(name = "cholesterol")
	private Boolean cholesterol;

	@Column(name = "psa")
	private Boolean psa;

	@Column(name = "leadScreening")
	private Boolean leadScreening;

	@Column(name = "fileIndicator")
	private String fileIndicator;

	public Patient() {
	};

	public Patient(Long id, String[] firstName, String lastName, String dateOfBirth, String[] subscriberId,
			String[] groupId, String language, String race, String gender, String maritalStatus, List<AddressOutput> address, Boolean a1c,
			Boolean cholesterol, Boolean psa, Boolean leadScreening, String fileIndicator) {
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
		this.gender = gender.toUpperCase();
		this.maritalStatus = maritalStatus;
		this.address = address;
		this.a1c = a1c;
		this.cholesterol = cholesterol;
		this.psa = psa;
		this.leadScreening = leadScreening;
		this.fileIndicator = fileIndicator;
	}

	public Patient convertInputToPatient(InputIngest input) {
		Patient output = new Patient();

		String[] firstNames = Utils.convertListToArray(input.getFirstName());
		String[] groupIds = Utils.convertListToArray(input.getGroupId());
		String[] subscriberIds = Utils.convertListToArray(input.getSubscriberId());
		
		output.setFirstName(firstNames);
		output.setLastName(input.getLastName());
		output.setDateOfBirth(input.getDateOfBirth());
		output.setGroupId(groupIds);
		output.setSubscriberId(subscriberIds);
		output.setRace(input.getRace());
		output.setGender(input.getGender());
		output.setMaritalStatus(input.getMaritalStatus());
		output.setFileIndicator(input.getFileIndicator());

		// Run address converter
		AddressOutput addressConverter = new AddressOutput();
		List<AddressOutput> addressOutput = new ArrayList<AddressOutput>();
		addressOutput = addressConverter.convertInputToOutput(input.getAddress());
		output.setAddress(addressOutput);

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

	public String[] getFirstName() {
		return firstName;
	}

	public void setFirstName(String[] firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		this.lastNameLowercase = lastName.toLowerCase();
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String[] getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(String[] subscriberId) {
		this.subscriberId = subscriberId;
	}

	public String[] getGroupId() {
		return groupId;
	}

	public void setGroupId(String[] groupId) {
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
		this.gender = gender.toUpperCase();
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public List<AddressOutput> getAddress() {
		return address;
	}

	public void setAddress(List<AddressOutput> address) {
		this.address = address;
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

	public String getFileIndicator() {
		return fileIndicator;
	}

	public void setFileIndicator(String fileIndicator) {
		this.fileIndicator = fileIndicator;
	}

	public String getLastNameLowercase() {
		return lastNameLowercase;
	}

	public void setLastNameLowercase(String lastNameLowercase) {
		this.lastNameLowercase = lastNameLowercase;
	}
	
}