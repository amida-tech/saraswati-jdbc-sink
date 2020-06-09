package com.amida.saraswatijdbcsink.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DemographicsObject<T> implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String type;
	private T objectBody;
	
	public DemographicsObject() {};
	
	public DemographicsObject(Long id, String type, T objectBody) {
		
		this.id = id;
		this.type = type;
		this.objectBody = objectBody;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public T getObjectBody() {
		return objectBody;
	}

	public void setObjectBody(T objectBody) {
		this.objectBody = objectBody;
	}
	
}
