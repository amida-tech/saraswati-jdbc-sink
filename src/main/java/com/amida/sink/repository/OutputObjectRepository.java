package com.amida.sink.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amida.sink.model.OutputObject;

@Repository
public interface OutputObjectRepository extends CrudRepository<OutputObject, Long>{
	
}
