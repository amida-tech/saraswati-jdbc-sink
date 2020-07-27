package com.amida.saraswatijdbcsink.mocks;

public class PayloadMock {
	//TODO: set a default case that is read from a file.
	private String payload = "";
	
	public PayloadMock() {}
	
	public PayloadMock(String payload) {
		this.payload = payload;
	};

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getPayload() {
		return payload;
	}	
}
