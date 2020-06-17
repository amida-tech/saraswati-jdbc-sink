package com.amida.saraswati.jdbcsink.sink.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amida.saraswati.jdbcsink.model.Output;

@Repository
public interface OutputObjectRepository extends CrudRepository<Output, Long>{
	
	public Output findByid(Long id);
	
	public Output findByLastName(String lastName);
}
