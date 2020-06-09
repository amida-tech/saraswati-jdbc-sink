package com.amida.saraswatijdbcsink.converter;

import java.util.ArrayList;
import java.util.List;

import com.amida.saraswatijdbcsink.model.AddressObjectOutput;
import com.amida.saraswatijdbcsink.model.CodeObjectIngest;
import com.amida.saraswatijdbcsink.model.InputObjectIngest;
import com.amida.saraswatijdbcsink.model.OutputObject;

public class InputOutputConverter {
	
	public static OutputObject convert(InputObjectIngest input){
		
		OutputObject output = new OutputObject();
		
		output.setFirstName(input.getFirstName());
		output.setLastName(input.getLastName());
		output.setDateOfBirth(input.getDateOfBirth());
		output.setGroupId(input.getSubscriberId());
		output.setSubscriberId(input.getSubscriberId());
		output.setFileIndicator(input.getFileIndicator());
		
		//Create codelist
		List <CodeObjectIngest> codeList = new ArrayList<CodeObjectIngest>();
		
		codeList.add(input.getRace());
		codeList.add(input.getMaritalStatus());
		output.setCodes(codeList);
		
		//Run address converter
		AddressObjectOutput addressOutput = new AddressObjectOutput();
		addressOutput = addressOutput.convertInputToOutput(input.getAddress());
		output.setAddress(addressOutput);
		
		//Booleans
		output.setAlc(input.isAlc());
		output.setCholesterol(input.isCholesterol());
		output.setPsa(input.isPsa());
		output.setLeadScreening(input.isLeadScreening());

		return output;
	}

}
