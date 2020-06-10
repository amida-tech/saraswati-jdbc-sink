package com.amida.saraswatijdbcsink.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="code")
public class CodeObjectOutput {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "code_system")
	private String codeSystem;
	
	@Column(name = "code_system_value")
	private String someCodeSystem;
	
	@Column(name = "display_name")
	private String displayName;
	
	public CodeObjectOutput() {};
	
	public CodeObjectOutput(String codeSystem, String someCodeSystem, String displayName) {
		this.codeSystem = codeSystem;
		this.someCodeSystem = someCodeSystem;
		this.displayName = displayName;
	}
	
	public List<CodeObjectOutput> convertInputToOutput(List<CodeObjectIngest> input) {
		
		List<CodeObjectOutput> output = new ArrayList<CodeObjectOutput>();
		
		for (CodeObjectIngest entry : input) {
			CodeObjectOutput entryObject = new CodeObjectOutput();
			entryObject.setCodeSystem(entry.getCodeSystem());
			entryObject.setSomeCodeSystem(entry.getSomeCodeSystem());
			entryObject.setDisplayName(entry.getDisplayName());
			output.add(entryObject);
		}
		
		return output;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
