package com.jobnormalizer.normalizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NormalizerTest {
	
	private Normalizer normalizer;
	
	@BeforeEach
	public void init() {
		normalizer = new Normalizer();
	}

	@Test
	public void normalizeNullInput() {
		String message = normalizer.normalize(null);
		
		assertEquals("No job title was provided", message);
	}
	
	@Test
	public void normalizeEmptyInput() {
		String message = normalizer.normalize(" ");
		
		assertEquals("No job title was provided", message);
	}
	
	@Test
	public void normalizeNonMatchingInput() {
		String nonMatcher = "Landscaper";
		
		String message = normalizer.normalize(nonMatcher);
		
		assertEquals("No normalized title was found", message);
	}
	
	@Test
	public void normalizeMatchingInput() {
		String matcher = "Surveyor";
		
		String message = normalizer.normalize(matcher);
		
		assertEquals("Quantity Surveyor", message);
	}
}
