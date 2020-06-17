package com.amida.saraswatijdbcsink.mocks;

import java.util.ArrayList;
import java.util.Arrays;

import com.amida.saraswati.jdbcsink.model.AddressOutput;
import com.amida.saraswati.jdbcsink.model.CodeOutput;
import com.amida.saraswati.jdbcsink.model.Output;

public class OutputMock {
	public Output outputMock() {
		//instantiate mock
		Output outputMock = new Output();
		
		//List Mocks
		String[] firstNameList =  new String[] {"James", "Tiberius"};
		String[] subscriberIdList = new String[] {"2"};
		String[] groupIdList = new String[] {"247"};
		
		outputMock.setFirstName(firstNameList);
		outputMock.setSubscriberId(subscriberIdList);
		outputMock.setGroupId(groupIdList);
		
		//Codes Assembly
		CodeOutput raceMock = new CodeOutput("Universal Race Standard","0","Unknown");
		CodeOutput maritalStatusMock = new CodeOutput("Universal Marriage Standard","0","Unmarried");
		ArrayList<CodeOutput> codesMock = new ArrayList<CodeOutput>(Arrays.asList(raceMock,maritalStatusMock));
		
		outputMock.setCodes(codesMock);
		
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
		outputMock.setAlc(false);
		outputMock.setCholesterol(false);
		outputMock.setPsa(false);
		outputMock.setLeadScreening(false);
		outputMock.setFileIndicator("ncc1701kirk.xml");
		
		return outputMock;
	}
}
