package com.amida.saraswatijdbcsink.converter;

import com.amida.saraswatijdbcsink.model.InputObjectIngest;
import com.amida.saraswatijdbcsink.model.OutputObject;

public class InputOutputConverter {
	
	public static OutputObject convert(InputObjectIngest input){
		
		OutputObject output = new OutputObject();
		
		output.setFirstName(input.getFirstName());
		output.setLastName(input.getLastName());
		output.setGroupId(input.getSubscriberId());
		output.setSubscriberId(input.getSubscriberId());
		output.setDemographics(input.getDemographics());
		output.setCodes(input.getCodes());

		return output;
	}

}
