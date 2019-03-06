package com.sapient.benchmark.domain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Document(collection="trainings")
public class Training {
	
	@Field(value = "Name")
	private String name;
	@Field(value = "Code")
	private String code;
	@Field(value = "Description")
	private String description;
	@Field(value = "Prerequisites")
	private Prerequisites prerequisites ;
	@Field(value = "From")
	private Date from;
	@Field(value = "To")
	private Date to;
	@Field(value = "typeOfTraining")
	private TrainingType typeOfTraining;
	
}
