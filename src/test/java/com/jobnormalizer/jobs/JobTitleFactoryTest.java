package com.jobnormalizer.jobs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JobTitleFactoryTest {
	
	private JobTitleFactory jobTitleFactory;
	
	@BeforeEach
	public void init() {
		jobTitleFactory = new JobTitleFactory();
	}
	
	@Test
	public void getJobTitleNullInput() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			jobTitleFactory.getJobTitle(null);
		});
		
		String expectedMessage = "Invalid stored title data";
		
		assertEquals(expectedMessage, exception.getMessage());
	}
	
	@Test
	public void getJobTitleEmptyInput() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			jobTitleFactory.getJobTitle(" ");
		});
		
		String expectedMessage = "Invalid stored title data";
		
		assertEquals(expectedMessage, exception.getMessage());
	}
	
	@Test
	public void getJobTitleOneWordInput() {
		String title = "Accountant";
		
		JobTitle normalisedJob = jobTitleFactory.getJobTitle(title);
		
		assertEquals(title, normalisedJob.toString());
	}
	
	@Test
	public void getJobTitleTwoWordInput() {
		String title = "Software engineer";
		
		JobTitle normalisedJob = jobTitleFactory.getJobTitle(title);
		
		assertEquals(title, normalisedJob.toString());
	}
	
	@Test
	public void getJobTitleThreeWordInput() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			jobTitleFactory.getJobTitle("Senior Python Engineer");
		});
		
		String expectedMessage = "Invalid title length";
		
		assertEquals(expectedMessage, exception.getMessage());
	}

}
