package com.jobnormalizer.jobs;

public class JobTitleFactory {
	
	public JobTitleFactory() {
	}
	
	public JobTitle getJobTitle(String input) {
		if(input == null || input.trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid stored title data");
		}
		
		String[] wordList = input.split(" ");
		
		switch(wordList.length) {
		case 1:
			return new OneWordTitle(wordList[0]);
		case 2:
			return new TwoWordTitle(wordList[0], wordList[1]);
		default:
			throw new IllegalArgumentException("Invalid title length");
		}
	}

}
