package com.sapient.benchmark.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sapient.benchmark.domain.Training;
import com.sapient.benchmark.repository.TrainingRepositoryCustomQueries;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTrainingService {

	@Mock
	private TrainingService trainingService;

	@Spy
	@Autowired
	private TrainingRepositoryCustomQueries customquery;
	
	@Test
	public void testgetTrainingByCode() throws Exception{
		assertNull(trainingService.getTrainingForCode(null));
		when(trainingService.getTrainingForCode("Tech123")).thenReturn(new Training());
		assertNotNull(trainingService.getTrainingForCode("Tech123"));
	}
	
	
}

