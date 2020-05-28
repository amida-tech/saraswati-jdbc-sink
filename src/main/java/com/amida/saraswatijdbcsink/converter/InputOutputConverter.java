package com.amida.saraswatijdbcsink.converter;

import com.amida.sink.model.InputObject;
import com.amida.sink.model.OutputObject;

public class InputOutputConverter {
	
	public static OutputObject convert(InputObject input){
		
		OutputObject output = new OutputObject();
		
		output.setFirstName(input.getFirstName());
		output.setLastName(input.getLastName());
		output.setState(input.getState());

		return output;
	}

}
