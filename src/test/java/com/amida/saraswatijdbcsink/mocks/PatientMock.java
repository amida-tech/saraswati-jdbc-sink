package com.amida.saraswatijdbcsink.mocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.amida.saraswati.jdbcsink.model.Patient;
import com.amida.saraswati.jdbcsink.model.PatientAddress;
import com.amida.saraswati.jdbcsink.model.ProviderAddress;

public class PatientMock {
	public Patient outputMock() {
		//instantiate mock
		Patient outputMock = new Patient();
		
		//List Mocks
		List<String> firstNameList = new ArrayList<String>();
		firstNameList.add("James");
		firstNameList.add("Tiberius");
		Set<String> subscriberIdList = new HashSet<String>();
		subscriberIdList.add("2");
		Set<String> groupIdList = new HashSet<String>();
		groupIdList.add("247");
		
		outputMock.setFirstName(firstNameList);
		outputMock.setSubscriberId(subscriberIdList);
		outputMock.setGroupId(groupIdList);
		
		//Address mock
		PatientAddress addressMock = new PatientAddress();
		Set<String> streetList = new HashSet<String>();
		subscriberIdList.add("1776 Constitution Avenue");
	
		addressMock.setStreet(streetList);
		addressMock.setCity("Riverside");
		addressMock.setZipCode("52327-1701");
		addressMock.setState("IA");
		addressMock.setCountry("United Earth Federation");
		outputMock.setPatientAddress(new ArrayList<PatientAddress>(Arrays.asList(addressMock)));
		
		// Provider Mock
		ProviderAddress providerAddresMock = new ProviderAddress();
		Set<String> streetList2 = new HashSet<String>();
		streetList2.add("1701 Medical St.");
		
		List<String> providerFirstNameList = new ArrayList<String>();
		providerFirstNameList.add("Leonard");
		providerFirstNameList.add("Horatio");
		Set<String> providerIdList = new HashSet<String>();
		providerIdList.add("ABC123456789");
		
		providerAddresMock.setStreet(streetList2);
		providerAddresMock.setCity("New York 2");
		providerAddresMock.setZipCode("52327-1701");
		providerAddresMock.setState("NY");
		providerAddresMock.setCountry("United Earth Federation");
		outputMock.setProviderAddress(new ArrayList<ProviderAddress>(Arrays.asList(providerAddresMock)));
		outputMock.setProviderLastName("McCoy");
		outputMock.setProviderFirstName(providerFirstNameList);
		outputMock.setProviderId(providerIdList);
		
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
