package com.sapient.benchmark.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.benchmark.domain.Training;
import com.sapient.benchmark.service.TrainingService;

import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TrainingController {
	
	@Autowired
	public TrainingService trainingService;
	
	@GetMapping("/training/all")
	public List<Training> getAllTrainings()
	{
		return trainingService.getAllTrainings();
	}
	
	@GetMapping("/training/code/{code}")
	public Training getTrainingbyCode(@PathVariable("code") String trainingCode)
	{
		return trainingService.getTrainingForCode(trainingCode);
	}
	
	@GetMapping("/training/from/{fromdate}/to/{todate}")
	@ApiParam("date format to be used is dd-mm-yyyy")
	public List<Training> getTrainingbyDate(@PathVariable("fromdate") String fromdate,@PathVariable("todate") String todate) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		fromdate+="T00:00:00.000Z";
		todate+="T00:00:00.000Z";
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS\'Z\'");
		dateFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));

		Date startDate,endDate;

		startDate =  Date.from(Instant.parse(fromdate));
		endDate = dateFormatter.parse(todate);
		log.info("From date is  " + startDate +" to " + endDate);
		return trainingService.getTrainingbetween(startDate,endDate);
	}	
	@GetMapping("/training/name/{name}")
	public List<Training> getTrainingbyName(@PathVariable("name") String trainingName)
	{
		return trainingService.getTrainingsforName(trainingName);
	}
	
	/*  List<String> topicStrings = Arrays.asList("first-topic", "second-topic", "third-topic");
    String topics = String.join(",",topicStrings);*/
	@GetMapping("/training/functionaldomain/{fdomains}")
	public List<Training> getTrainingByFunctionalDomain(@PathVariable("fdomains") List<String> domains)
	{
		return trainingService.getTrainingsForFunctionalDomain(domains);
		
	}
	
	@GetMapping("/training/technology/{techs}")
	public List<Training> getTrainingByTechnology(@PathVariable("techs") List<String> techs)
	{
		return trainingService.getTrainingsForTechnicalDomain(techs);
		
	}

	@GetMapping("/training/roles/{roles}")
	public List<Training> getTrainingByroles(@PathVariable("roles") List<String> roles)
	{
		return trainingService.getTrainingsForRoles(roles);
		
	}
	
	@GetMapping("/training/upskills/{upskills}")
	public List<Training> getTrainingByupskills(@PathVariable("upskills") List<String> upskills)
	{
		return trainingService.getTrainingsWhichAreUpSkillFor(upskills);
		
	}
}
