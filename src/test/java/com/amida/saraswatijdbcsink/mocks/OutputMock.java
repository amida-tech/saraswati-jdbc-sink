package com.amida.saraswatijdbcsink.mocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.amida.saraswatijdbcsink.model.AddressObjectOutput;
import com.amida.saraswatijdbcsink.model.CodeObjectOutput;
import com.amida.saraswatijdbcsink.model.OutputObject;

public class OutputMock {
	public OutputObject outputMock() {
		//instantiate mock
		OutputObject outputMock = new OutputObject();
		
		//List Mocks
		List<String> firstNameList = new ArrayList<String>(Arrays.asList("James", "Tiberius"));
		List<String> subscriberIdList = new ArrayList<String>(Arrays.asList("2"));
		List<String> groupIdList = new ArrayList<String>(Arrays.asList("247"));
		
		outputMock.setFirstName(firstNameList);
		outputMock.setSubscriberId(subscriberIdList);
		outputMock.setGroupId(groupIdList);
		
		//Codes Assembly
		CodeObjectOutput raceMock = new CodeObjectOutput("Universal Race Standard","0","Unknown");
		CodeObjectOutput maritalStatusMock = new CodeObjectOutput("Universal Marriage Standard","0","Unmarried");
		ArrayList<CodeObjectOutput> codesMock = new ArrayList<CodeObjectOutput>(Arrays.asList(raceMock,maritalStatusMock));
		
		outputMock.setCodes(codesMock);
		
		//Address mock
		AddressObjectOutput addressMock = new AddressObjectOutput();
		List<String> streetList = new ArrayList<String>(Arrays.asList("1776 Constitution Avenue"));
		
		addressMock.setStreet(streetList);
		addressMock.setCity("Riverside");
		addressMock.setZipCode("52327-1701");
		addressMock.setState("IA");
		addressMock.setCountry("United Earth Federation");
		outputMock.setAddress(new ArrayList<AddressObjectOutput>(Arrays.asList(addressMock)));
		
		//Assemble mock
		outputMock.setId((long) 1701);
		outputMock.setLastName("Kirk");
		outputMock.setLanguage("en");
		outputMock.setAlc(false);
		outputMock.setCholesterol(false);
		outputMock.setPsa(false);
		outputMock.setLeadScreening(false);
		outputMock.setFileIndicator("ncc1701kirk.xml");
		
		return outputMock;
	}
}
