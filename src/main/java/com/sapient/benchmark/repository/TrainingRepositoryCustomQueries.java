package com.sapient.benchmark.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.sapient.benchmark.domain.Training;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TrainingRepositoryCustomQueries {
	
	TrainingRepositoryDAO dao;
	MongoOperations mongoOps = new MongoTemplate(new MongoClient(), "BenchMark");
	
	public List<Training> getTrainingsForFunctionalDomain(List<String> functionalDomains)
	{
		//db.trainings.find({"Prerequisites.FunctionalDomain": { $all:["Ecommerce"]}});
		Query queryByFunctionalDomain = new Query();
		functionalDomains.add("ANY");
		queryByFunctionalDomain.addCriteria(where("Prerequisites.FunctionalDomain").in(functionalDomains));
		log.info(queryByFunctionalDomain.toString());
		return mongoOps.find(queryByFunctionalDomain, Training.class)  ;
	}
	
	public List<Training> getTrainingsbyName(String name)
	{
		Query queryByName = new Query(where("Name").regex("/*"+name,"i"));
		log.info(queryByName.toString());
		return( mongoOps.find(queryByName,Training.class));
		
	}
	
	public List<Training> getTrainingsForTechnology(List<String> Technology)
	{
		Query queryByTechnology = new Query();
		Technology.add("ANY");
		queryByTechnology.addCriteria(where("Prerequisites.Technology").in(Technology));
		log.info(queryByTechnology.toString());
		return mongoOps.find(queryByTechnology, Training.class)  ;
	}
	
	public List<Training> getTrainingsForRoles(List<String> roles)
	{
		Query queryByroles = new Query();
		roles.add("ANY");
		queryByroles.addCriteria(where("Prerequisites.Roles").in(roles));
		log.info(queryByroles.toString());
		return mongoOps.find(queryByroles, Training.class)  ;
	}
	
	public List<Training> getTrainingsByUpskill(List<String> upSkill)
	{
		Query queryByupSkill = new Query();
		queryByupSkill.addCriteria(where("Prerequisites.Roles").in(upSkill));
		log.info(queryByupSkill.toString());
		return mongoOps.find(queryByupSkill, Training.class)  ;
	}
//	db.users.find({createdAt:{"$gte":ISODate("2017-04-27T00:00:00Z"),"$lt":ISODate("2017-04-28T00:00:00Z") }}).count()

	public List<Training> getTrainingBetween(Date from,Date To)
	{
		Query queryByDate = new Query();
		queryByDate.addCriteria(where("From").gte(from)
				.andOperator(where("From").lte(To)));
		log.info(queryByDate.toString());
		return mongoOps.find(queryByDate, Training.class)  ;
	}

}
