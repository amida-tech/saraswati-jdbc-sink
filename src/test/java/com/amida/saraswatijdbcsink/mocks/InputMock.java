package com.amida.saraswatijdbcsink.mocks;

import com.amida.saraswatijdbcsink.model.InputObject;

public class InputMock {
	public InputObject inputMock() {
		InputObject inputMock = new InputObject();
		
		inputMock.setId((long) 1701);
		inputMock.setFirstName("James");
		inputMock.setLastName("Kirk");
		inputMock.setState("Iowa");
		
		return inputMock;
	}
}
