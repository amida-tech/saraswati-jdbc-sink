package com.amida.saraswatijdbcsink.model;

//@Entity
public class CodeObjectIngest{

	private String codeSystem;
	private String someCodeSystem;
	private String displayName;
	
	public CodeObjectIngest() {};
	
	public CodeObjectIngest(String codeSystem, String someCodeSystem, String displayName) {
		this.codeSystem = codeSystem;
		this.someCodeSystem = someCodeSystem;
		this.displayName = displayName;
	}

	public String getCodeSystem() {
		return codeSystem;
	}

	public void setCodeSystem(String codeSystem) {
		this.codeSystem = codeSystem;
	}

	public String getSomeCodeSystem() {
		return someCodeSystem;
	}

	public void setSomeCodeSystem(String someCodeSystem) {
		this.someCodeSystem = someCodeSystem;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
