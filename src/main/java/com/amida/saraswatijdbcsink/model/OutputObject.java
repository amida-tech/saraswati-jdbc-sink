package com.amida.saraswatijdbcsink.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class OutputObject {	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "first_name")
	@JsonProperty("firstName")
	private String firstName;
	
	@Column(name = "last_name")
	@JsonProperty("lastName")
	private String lastName;
	
	@Column(name = "subscriber_id")
	@JsonProperty("subscriberId")
	private String subscriberId;
	
	@Column(name = "group_id")
	@JsonProperty("groupId")
	private String groupId;
	
	@OneToMany(mappedBy="OutputObject", fetch=FetchType.EAGER)
	@JsonProperty("demographics")
	private List<DemographicsObject> demographics;
	
	@Column(name = "codes")
	@JsonProperty("codes")
	private List<CodeObjectIngest> codes;
	
	public OutputObject() {};

	public OutputObject(Long id, String firstName, String lastName, String subscriberId, String groupId, List<DemographicsObject> demographics, List<CodeObjectIngest> codes) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.subscriberId = subscriberId;
		this.groupId = groupId;
		this.demographics = demographics;
		this.codes = codes;
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

	public String getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public List<DemographicsObject> getDemographics() {
		return demographics;
	}

	public void setDemographics(List<DemographicsObject> demographics) {
		this.demographics = demographics;
	}

	public List<CodeObjectIngest> getCodes() {
		return codes;
	}

	public void setCodes(List<CodeObjectIngest> codes) {
		this.codes = codes;
	}
	
	

}
