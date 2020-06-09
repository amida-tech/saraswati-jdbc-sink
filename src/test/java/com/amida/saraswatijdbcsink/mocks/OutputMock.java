package com.amida.saraswatijdbcsink.mocks;

import java.util.ArrayList;

import com.amida.saraswatijdbcsink.model.AddressObjectIngest;
import com.amida.saraswatijdbcsink.model.CodeObjectIngest;
import com.amida.saraswatijdbcsink.model.DemographicsObject;
import com.amida.saraswatijdbcsink.model.OutputObject;

public class OutputMock {
	public OutputObject outputMock() {
		//instantiate mock
		OutputObject outputMock = new OutputObject();
		
		//Demographics mock
		ArrayList<DemographicsObject> demographicListMock = new ArrayList();
		DemographicsObject demographicMock = new DemographicsObject();
		AddressObjectIngest addressMock = new AddressObjectIngest();
		addressMock.setStreet("1776 Constitution Avenue");
		addressMock.setCity("Riverside");
		addressMock.setPostalCode("52327-1701");
		addressMock.setState("IA");
		addressMock.setCountry("United Earth Federation");
		demographicMock.setType("address");
		demographicMock.setObjectBody(addressMock);
		demographicListMock.add(demographicMock);
		
		
		//Codes Mock
		ArrayList<CodeObjectIngest> codeListMock = new ArrayList<CodeObjectIngest>();
		CodeObjectIngest code1 = new CodeObjectIngest("loinc","1313");
		CodeObjectIngest code2 = new CodeObjectIngest("cpt","abcdefg");
		codeListMock.add(code1);
		codeListMock.add(code2);
		
		//Assemble mock
		outputMock.setId((long) 1701);
		outputMock.setFirstName("James");
		outputMock.setLastName("Kirk");
		outputMock.setSubscriberId("2");
		outputMock.setGroupId("247");
		outputMock.setDemographics(demographicListMock);
		outputMock.setCodes(codeListMock);
		
		return outputMock;
	}
}
