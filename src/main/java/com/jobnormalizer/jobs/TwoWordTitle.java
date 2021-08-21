package com.jobnormalizer.jobs;

public class TwoWordTitle implements JobTitle {
	
	private float qScore;
	
	private String firstTitle;
	
	private String secondTitle;
	

	public TwoWordTitle(String firstTitle, String secondTitle) {
		super();
		this.qScore = 0f;
		this.firstTitle = firstTitle;
		this.secondTitle = secondTitle;
	}

	public float getqScore() {
		return qScore;
	}

	public void setqScore(float qScore) {
		this.qScore = qScore;
	}

	public String getFirstTitle() {
		return firstTitle;
	}

	public void setFirstTitle(String firstTitle) {
		this.firstTitle = firstTitle;
	}

	public String getSecondTitle() {
		return secondTitle;
	}

	public void setSecondTitle(String secondTitle) {
		this.secondTitle = secondTitle;
	}

	
	@Override
	public float calculateScore(String inputTitle) {
		if(inputTitle == null || inputTitle.trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid job title");
		}
		
		String[] inputArray = inputTitle.split(" ");
		
		float score = 0f;
		for(String input : inputArray) {
			if (input.equalsIgnoreCase(this.getFirstTitle())) {
				score += 0.5f;
			} else if (input.equalsIgnoreCase(this.getSecondTitle())) {
				score += 0.5f;
			}
		}
		
		this.setqScore(score);
		
		return this.getqScore();
	}
	
	@Override
	public String toString() {
		return this.getFirstTitle() + " " + this.getSecondTitle();
	}
}
