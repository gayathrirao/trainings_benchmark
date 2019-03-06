package com.sapient.benchmark.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sapient.benchmark.domain.Training;

@Repository
public interface TrainingRepositoryDAO extends MongoRepository<Training,String>
{
	
	public Training findBycode(String Code);
	
	
	
}
