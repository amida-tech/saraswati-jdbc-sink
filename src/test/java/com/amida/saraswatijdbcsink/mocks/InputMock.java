package com.amida.saraswatijdbcsink.mocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.amida.saraswati.jdbcsink.model.AddressIngest;
import com.amida.saraswati.jdbcsink.model.InputIngest;

public class InputMock {
	public InputIngest inputMock() {
		//instantiate mock
		InputIngest inputMock = new InputIngest();
		
		//List Mocks
		//firstName, subscriberId, groupId
		List<String> firstNameList = new ArrayList<String>(Arrays.asList("James", "Tiberius"));
		List<String> subscriberIdList = new ArrayList<String>(Arrays.asList("2"));
		List<String> groupIdList = new ArrayList<String>(Arrays.asList("247"));
		
		inputMock.setFirstName(firstNameList);
		inputMock.setSubscriberId(subscriberIdList);
		inputMock.setGroupId(groupIdList);
		
		//Address mock
		AddressIngest addressMock = new AddressIngest();
		List<String> streetList = new ArrayList<String>(Arrays.asList("1776 Constitution Avenue"));
		
		addressMock.setStreet(streetList);
		addressMock.setCity("Riverside");
		addressMock.setZipCode("52327-1701");
		addressMock.setState("IA");
		addressMock.setCountry("United Earth Federation");
		inputMock.setPatientAddress(addressMock);
		
		AddressIngest providerAddressMock = new AddressIngest();
		List<String> providerStreetList = new ArrayList<String>(Arrays.asList("1701 Medical St."));
		
		providerAddressMock.setStreet(providerStreetList);
		providerAddressMock.setCity("New York 2");
		providerAddressMock.setZipCode("52327-1701");
		providerAddressMock.setState("NY");
		providerAddressMock.setCountry("United Earth Federation");
		inputMock.setProviderAddress(providerAddressMock);
		
		//Assemble mock
		inputMock.setId((long) 1701);
		inputMock.setLastName("Kirk");
		inputMock.setLanguage("en");
		inputMock.setRace("2106-3");
		inputMock.setGender("M");
		inputMock.setMaritalStatus("S");
		inputMock.setA1c(false);
		inputMock.setCholesterol(false);
		inputMock.setPsa(false);
		inputMock.setLeadScreening(false);
		inputMock.setFileIndicator("ncc1701kirk.xml");

		
		return inputMock;
	}
}
