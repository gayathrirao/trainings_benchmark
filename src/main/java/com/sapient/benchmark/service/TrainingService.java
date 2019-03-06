package com.sapient.benchmark.service;

import java.util.Date;
import java.util.List;

import com.sapient.benchmark.domain.Training;

public interface TrainingService {
	
	public Training getTrainingForCode(String code);
	public List<Training> getTrainingsforName(String name);
	public List<Training> getTrainingsForFunctionalDomain(List<String> functionaldomains);
	public List<Training> getTrainingsForTechnicalDomain(List<String> techdomain );
	public List<Training> getTrainingsForRoles(List<String> roles);
	public List<Training> getTrainingsWhichAreUpSkillFor(List<String> skills);
	public List<Training> getTrainingbetween(Date from, Date to);
	public List<Training> getAllTrainings();
}
