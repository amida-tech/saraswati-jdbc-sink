package com.amida.saraswatijdbcsink.converter;

import com.amida.saraswatijdbcsink.model.InputObject;
import com.amida.saraswatijdbcsink.model.OutputObject;

public class InputOutputConverter {
	
	public static OutputObject convert(InputObject input){
		
		OutputObject output = new OutputObject();
		
		output.setFirstName(input.getFirstName());
		output.setLastName(input.getLastName());
		output.setState(input.getState());

		return output;
	}

}
