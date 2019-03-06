package com.sapient.benchmark.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.benchmark.domain.Training;
import com.sapient.benchmark.repository.TrainingRepositoryCustomQueries;
import com.sapient.benchmark.repository.TrainingRepositoryDAO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Getter
@Setter
@ToString
public class TrainingServiceImpl implements TrainingService{
	
	@Autowired
	private TrainingRepositoryDAO dao;
	
	@Autowired
	private TrainingRepositoryCustomQueries customdao;
	
	@Override
	public Training getTrainingForCode(String code) {
		return dao.findBycode(code);
	}
	
	public List<Training> getAllTrainings()
	{
		return dao.findAll();
	}

	
	public List<Training> getTrainingsforName(String name) {
		if (name == null || name.trim().length()==0) return null;
		return customdao.getTrainingsbyName(name);
	}

	@Override
	public List<Training> getTrainingsForFunctionalDomain(List<String> functionaldomains) {
		if (functionaldomains == null || functionaldomains.isEmpty()) return null;
		return customdao.getTrainingsForFunctionalDomain(functionaldomains);
	}

	@Override
	public List<Training> getTrainingsForTechnicalDomain(List<String> techdomain) {
		if (techdomain == null || techdomain.isEmpty()) return null;
		return customdao.getTrainingsForTechnology(techdomain) ;
	}

	@Override
	public List<Training> getTrainingsForRoles(List<String> roles) {
		if (roles == null || roles.isEmpty()) return null;
		return customdao.getTrainingsForRoles(roles);
	}

	@Override
	public List<Training> getTrainingsWhichAreUpSkillFor(List<String> skills) {
		if (skills == null || skills.isEmpty()) return null;
		return customdao.getTrainingsByUpskill(skills);
	}


	@Override
	public  List<Training> getTrainingbetween(Date from, Date to) {
		return customdao.getTrainingBetween(from, to);
	}

}
