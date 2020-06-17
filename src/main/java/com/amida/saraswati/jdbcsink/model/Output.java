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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.array.StringArrayType;

@TypeDefs({ @TypeDef(name = "string-array", typeClass = StringArrayType.class) })
@Entity
public class Output {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Type(type = "string-array")
	@Column(name = "first_name", columnDefinition = "text[]")
	private String[] firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "date_of_birth")
	private String dateOfBirth;

	@Type(type = "string-array")
	@Column(name = "subscriber_id", columnDefinition = "text[]")
	private String[] subscriberId;
	
	@Type(type = "string-array")
	@Column(name = "group_id", columnDefinition = "text[]")
	private String[] groupId;

	@Column(name = "language")
	private String language;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "codes", referencedColumnName = "id")
	private List<CodeOutput> codes;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="address", referencedColumnName="id")
	private List<AddressOutput> address;

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

	public Output() {
	};

	public Output(Long id, String[] firstName, String lastName, String dateOfBirth, String[] subscriberId,
			String[] groupId, String language, List<CodeOutput> codes, List<AddressOutput> address, Boolean alc,
			Boolean cholesterol, Boolean psa, Boolean leadScreening, String fileIndicator) {
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

	public Output convertInputToOutput(InputIngest input) {
		Output output = new Output();
		
		String[] firstNames = (String[]) input.getFirstName().toArray();
		String[] groupIds = (String[]) input.getSubscriberId().toArray();
		String[] subscriberIds = (String[]) input.getSubscriberId().toArray();
		output.setFirstName(firstNames);
		output.setLastName(input.getLastName());
		output.setDateOfBirth(input.getDateOfBirth());
		output.setGroupId(groupIds);
		output.setSubscriberId(subscriberIds);
		output.setFileIndicator(input.getFileIndicator());

		// Create codelist
		List<CodeIngest> inputCodes = new ArrayList<CodeIngest>();
		CodeOutput codeConverter = new CodeOutput();

		inputCodes.add(input.getRace());
		inputCodes.add(input.getMaritalStatus());
		List<CodeOutput> codeList = new ArrayList<CodeOutput>(codeConverter.convertInputToOutput(inputCodes));
		output.setCodes(codeList);

		// Run address converter
		AddressOutput addressConverter = new AddressOutput();
		List<AddressOutput> addressOutput = new ArrayList<AddressOutput>();
		addressOutput = addressConverter.convertInputToOutput(input.getAddress());
		output.setAddress(addressOutput);

		// Booleans
		output.setAlc(input.isAlc());
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

	public List<CodeOutput> getCodes() {
		return codes;
	}

	public void setCodes(List<CodeOutput> codeList) {
		this.codes = codeList;
	}

	public List<AddressOutput> getAddress() {
		return address;
	}

	public void setAddress(List<AddressOutput> address) {
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
