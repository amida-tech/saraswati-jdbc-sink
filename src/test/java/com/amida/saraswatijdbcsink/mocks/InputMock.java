package com.amida.saraswatijdbcsink.mocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.amida.saraswatijdbcsink.model.AddressObjectIngest;
import com.amida.saraswatijdbcsink.model.CodeObjectIngest;
import com.amida.saraswatijdbcsink.model.InputObjectIngest;

public class InputMock {
	public InputObjectIngest inputMock() {
		//instantiate mock
		InputObjectIngest inputMock = new InputObjectIngest();
		
		//List Mocks
		//firstName, subscriberId, groupId
		List<String> firstNameList = new ArrayList<String>(Arrays.asList("James", "Tiberius"));
		List<String> subscriberIdList = new ArrayList<String>(Arrays.asList("2"));
		List<String> groupIdList = new ArrayList<String>(Arrays.asList("247"));
		
		inputMock.setFirstName(firstNameList);
		inputMock.setSubscriberId(subscriberIdList);
		inputMock.setGroupId(groupIdList);
		
		//Race Mock
		CodeObjectIngest raceMock = new CodeObjectIngest("Universal Race Standard","0","Unknown");
		inputMock.setRace(raceMock);
		
		//Marital Status Mock
		CodeObjectIngest maritalStatusMock = new CodeObjectIngest("Universal Marriage Standard","0","Unmarried");
		inputMock.setMaritalStatus(maritalStatusMock);
		
		//Address mock
		AddressObjectIngest addressMock = new AddressObjectIngest();
		List<String> streetList = new ArrayList<String>(Arrays.asList("1776 Constitution Avenue"));
		
		addressMock.setStreet(streetList);
		addressMock.setCity("Riverside");
		addressMock.setZipCode("52327-1701");
		addressMock.setState("IA");
		addressMock.setCountry("United Earth Federation");
		inputMock.setAddress(addressMock);
		
		//Assemble mock
		inputMock.setId((long) 1701);
		inputMock.setLastName("Kirk");
		inputMock.setLanguage("en");
		inputMock.setAlc(false);
		inputMock.setCholesterol(false);
		inputMock.setPsa(false);
		inputMock.setLeadScreening(false);
		inputMock.setFileIndicator("ncc1701kirk.xml");

		
		return inputMock;
	}
}
