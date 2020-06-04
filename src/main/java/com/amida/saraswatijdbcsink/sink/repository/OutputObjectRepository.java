package com.amida.saraswatijdbcsink.sink.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amida.saraswatijdbcsink.model.OutputObject;

@Repository
public interface OutputObjectRepository extends CrudRepository<OutputObject, Long>{
	
	public OutputObject findByid(Long id);
	
	public OutputObject findByFirstName(String firstName);
}
