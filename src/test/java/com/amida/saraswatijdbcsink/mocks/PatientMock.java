package com.amida.saraswatijdbcsink.mocks;

import java.util.ArrayList;
import java.util.Arrays;

import com.amida.saraswati.jdbcsink.model.AddressOutput;
import com.amida.saraswati.jdbcsink.model.Patient;

public class PatientMock {
	public Patient outputMock() {
		//instantiate mock
		Patient outputMock = new Patient();
		
		//List Mocks
		String[] firstNameList =  new String[] {"James", "Tiberius"};
		String[] subscriberIdList = new String[] {"2"};
		String[] groupIdList = new String[] {"247"};
		
		outputMock.setFirstName(firstNameList);
		outputMock.setSubscriberId(subscriberIdList);
		outputMock.setGroupId(groupIdList);
		
		//Address mock
		AddressOutput addressMock = new AddressOutput();
		String[] streetList = new String[] {"1776 Constitution Avenue"};
	
		addressMock.setStreet(streetList);
		addressMock.setCity("Riverside");
		addressMock.setZipCode("52327-1701");
		addressMock.setState("IA");
		addressMock.setCountry("United Earth Federation");
		outputMock.setAddress(new ArrayList<AddressOutput>(Arrays.asList(addressMock)));
		
		//Assemble mock
		outputMock.setId((long) 1701);
		outputMock.setLastName("Kirk");
		outputMock.setLanguage("en");
		outputMock.setRace("2106-3");
		outputMock.setGender("M");
		outputMock.setMaritalStatus("S");
		outputMock.setA1c(false);
		outputMock.setCholesterol(false);
		outputMock.setPsa(false);
		outputMock.setLeadScreening(false);
		outputMock.setFileIndicator("ncc1701kirk.xml");
		
		return outputMock;
	}
}
