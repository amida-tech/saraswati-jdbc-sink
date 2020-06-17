package com.amida.saraswatijdbcsink.mocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.amida.saraswati.jdbcsink.model.AddressIngest;
import com.amida.saraswati.jdbcsink.model.CodeIngest;
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
		
		//Race Mock
		CodeIngest raceMock = new CodeIngest("Universal Race Standard","0","Unknown");
		inputMock.setRace(raceMock);
		
		//Marital Status Mock
		CodeIngest maritalStatusMock = new CodeIngest("Universal Marriage Standard","0","Unmarried");
		inputMock.setMaritalStatus(maritalStatusMock);
		
		//Address mock
		AddressIngest addressMock = new AddressIngest();
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
