package com.jobnormalizer.jobs;

public class OneWordTitle implements JobTitle {
	
	private float qScore;
	
	private String title;
	

	public OneWordTitle(String title) {
		super();
		this.qScore = 0f;
		this.title = title;
	}

	public float getqScore() {
		return qScore;
	}

	public void setqScore(float qScore) {
		this.qScore = qScore;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

	@Override
	public float calculateScore(String inputTitle) {
		if(inputTitle == null || inputTitle.trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid job title");
		}
		
		String[] inputArray = inputTitle.split(" ");
		
		for(String input : inputArray) {
			float score = 0f;
			
			if (input.equalsIgnoreCase(this.getTitle())) {
				score += 1f;
			} 
			
			this.setqScore(score);
		}
		
		return this.getqScore();
	}
	
	@Override
	public String toString() {
		return this.getTitle();
	}
}
