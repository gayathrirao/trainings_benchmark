package com.sapient.benchmark.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sapient.benchmark.repository.TrainingRepositoryCustomQueries;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTrainingCustomQueries {

	@Mock
	private TrainingService trainingService;

	@Spy
	@Autowired
	private TrainingRepositoryCustomQueries customquery;
	
	
	@Test
	public void testgetTrainingByName() throws Exception{
		
		/*List<Training> playtrainings = new ArrayList<Training>();
		playtrainings.add(new Training());
		when(customquery.getTrainingsbyName("Tech123")).thenReturn(playtrainings);
		assertNotNull(customquery.getTrainingsbyName("Tech123"));
		assertEquals(0, customquery.getTrainingsbyName(null).size());
		assertEquals(1, customquery.getTrainingsbyName("Tech123").size());*/
	}
	
	@Test
	public void testgetByFunctionalDomain() throws Exception {
		List<String> functionalDomain = new ArrayList<String>();
		functionalDomain.add("Ecommerce");
		System.out.println(customquery.getTrainingsForFunctionalDomain(functionalDomain));
	}
	
	@Test
	public void testgetByTechnology() throws Exception {
		List<String> tech = new ArrayList<String>();
		tech.add("JAVA");
		System.out.println(customquery.getTrainingsForTechnology(tech));
	}
	
	@Test
	public void testgetByRoles() throws Exception {
		List<String> roles = new ArrayList<String>();
		roles.add("ASSOCIATE");
		System.out.println(customquery.getTrainingsForRoles(roles));
	}
	
	@Test
	public void testgetByupskill() throws Exception {
		List<String> upskill = new ArrayList<String>();
		upskill.add("SCALA");
		System.out.println(customquery.getTrainingsByUpskill(upskill));
	}

}

