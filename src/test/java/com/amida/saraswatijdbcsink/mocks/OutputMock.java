package com.amida.saraswatijdbcsink.mocks;

import com.amida.saraswatijdbcsink.model.OutputObject;

public class OutputMock {
	public OutputObject outputMock() {
		OutputObject outputMock = new OutputObject();
		
		//TODO: Will need to reflect improved model in the mock.
		
		outputMock.setId((long) 1701);
		outputMock.setFirstName("James");
		outputMock.setLastName("Kirk");
		outputMock.setState("Iowa");

		return outputMock;
	}
}
