package com.jobnormalizer.jobs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OneWordTitleTest {
	
	private OneWordTitle oneWordTitle;
	
	@BeforeEach
	public void init() {
		oneWordTitle = new OneWordTitle("Accountant");
	}
	
	@Test
	public void calculateScoreNullInput() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			oneWordTitle.calculateScore(null);
		});
		
		String expectedMessage = "Invalid job title";
		
		assertEquals(expectedMessage, exception.getMessage());
	}
	
	@Test
	public void calculateScoreEmptyInput() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			oneWordTitle.calculateScore(" ");
		});
		
		String expectedMessage = "Invalid job title";
		
		assertEquals(expectedMessage, exception.getMessage());
	}
	
	@Test
	public void calculateScoreMatch() {
		float score = oneWordTitle.calculateScore("Accountant");
		
		float expected = 1f;
		float delta = 0;
		
		assertEquals(expected, score, delta);
	}
	
	@Test
	public void calculateScoreNoMatch() {
		float score = oneWordTitle.calculateScore("nomatch");
		
		float expected = 0f;
		float delta = 0;
		
		assertEquals(expected, score, delta);
	}
	
	@Test
	public void toStringAssert() {
		String toString = oneWordTitle.toString();
		
		String expected = "Accountant";
		
		assertEquals(expected, toString);
	}

}
