package com.amida.saraswatijdbcsink.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.array.StringArrayType;

@TypeDefs({
    @TypeDef(
        name = "string-array",
        typeClass = StringArrayType.class
    )
})
@Entity
public class OutputObject {	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Type(type = "string-array")
	@Column(name = "first_name", columnDefinition = "text[]")
	private List<String> firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "date_of_birth")
	private String dateOfBirth;
	
	@Type(type = "string-array")
	@Column(name = "subscriber_id", columnDefinition = "text[]")
	private List<String> subscriberId;
	
	@Type(type = "string-array")
	@Column(name = "group_id", columnDefinition = "text[]")
	private List<String> groupId;
	
	@Column(name = "language")
	private String language;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="codes", referencedColumnName="id")
	private List<CodeObjectOutput> codes;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="address", referencedColumnName="id")
	private List<AddressObjectOutput> address;
	
	@Column(name = "alc")
	private Boolean alc;
	
	@Column(name = "cholesterol")
	private Boolean cholesterol;
	
	@Column(name = "psa")
	private Boolean psa;
	
	@Column(name = "leadScreening")
	private Boolean leadScreening;
	
	@Column(name = "fileIndicator")
	private String fileIndicator;
	
	public OutputObject() {};

	public OutputObject(Long id, List<String> firstName, String lastName, String dateOfBirth, List<String> subscriberId, List<String> groupId, String language, List<CodeObjectOutput> codes, List<AddressObjectOutput> address, Boolean alc, Boolean cholesterol, Boolean psa, Boolean leadScreening, String fileIndicator) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.subscriberId = subscriberId;
		this.groupId = groupId;
		this.language = language;
		this.codes = codes;
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

	public List<CodeObjectOutput> getCodes() {
		return codes;
	}

	public void setCodes(List<CodeObjectOutput> codeList) {
		this.codes = codeList;
	}

	public List<AddressObjectOutput> getAddress() {
		return address;
	}

	public void setAddress(List<AddressObjectOutput> address) {
		this.address = address;
	}

	public Boolean getAlc() {
		return alc;
	}

	public void setAlc(Boolean alc) {
		this.alc = alc;
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

}
