package com.jobnormalizer.jobs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TwoWordTitleTest {
	
	private TwoWordTitle twoWordTitle;
	
	public TwoWordTitle setupTitle(String firstWord, String secondWord) {
		return new TwoWordTitle(firstWord, secondWord);
	}
	
	@Test
	public void calculateScoreNullInput() {
		twoWordTitle = setupTitle("Quantity", "Surveyor");
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			twoWordTitle.calculateScore(null);
		});
		
		String expectedMessage = "Invalid job title";
		
		assertEquals(expectedMessage, exception.getMessage());
	}
	
	@Test
	public void calculateScoreEmptyInput() {
		twoWordTitle = setupTitle("Quantity", "Surveyor");
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			twoWordTitle.calculateScore(" ");
		});
		
		String expectedMessage = "Invalid job title";
		
		assertEquals(expectedMessage, exception.getMessage());
	}
	
	@Test
	public void calculateScoreCompleteMatch() {
		twoWordTitle = setupTitle("Quantity", "Surveyor");
		
		float score = twoWordTitle.calculateScore("Quantity Surveyor");
		
		float expected = 1f;
		float delta = 0;
		
		assertEquals(expected, score, delta);
	}
	
	@Test
	public void calculateScoreHalfMatch() {
		twoWordTitle = setupTitle("Quantity", "Surveyor");
		
		float score = twoWordTitle.calculateScore("Quantity");
		
		float expected = 0.5f;
		float delta = 0;
		
		assertEquals(expected, score, delta);
	}
	
	@Test
	public void calculateScoreNoMatch() {
		twoWordTitle = setupTitle("Quantity", "Surveyor");
		
		float score = twoWordTitle.calculateScore("nomatch");
		
		float expected = 0f;
		float delta = 0;
		
		assertEquals(expected, score, delta);
	}
	
	@Test
	public void toStringAssert() {
		twoWordTitle = setupTitle("Quantity", "Surveyor");
		
		String toString = twoWordTitle.toString();
		
		String expected = "Quantity Surveyor";
		
		assertEquals(expected, toString);
	}

}
