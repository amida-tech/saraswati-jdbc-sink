package com.amida.saraswati.jdbcsink.sink.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amida.saraswati.jdbcsink.model.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long>{
	
	public Patient findByid(Long id);
	
	public Patient findByLastNameLowercase(String lastName);
}
