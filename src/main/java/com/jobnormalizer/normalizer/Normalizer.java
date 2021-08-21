package com.jobnormalizer.normalizer;

import java.util.ArrayList;

import com.jobnormalizer.jobs.JobTitle;
import com.jobnormalizer.jobs.JobTitleFactory;

public class Normalizer {
	
	private final String[] storedNormalizedTitles = new String[]{"Architect", "Software engineer", "Quantity Surveyor", "Accountant"};
	
	private JobTitleFactory jobTitleFactory;
	

	public Normalizer() {
		this.jobTitleFactory = new JobTitleFactory();
	}
	
	public String[] getNormalizedStoredTitles() {
		return storedNormalizedTitles;
	}
	
	public JobTitleFactory getJobTitleFactory() {
		return jobTitleFactory;
	}

	public void setJobTitleFactory(JobTitleFactory jobTitleFactory) {
		this.jobTitleFactory = jobTitleFactory;
	}

	public String normalize(String inputTitle) {
		if(inputTitle == null || inputTitle.trim().isEmpty()) {
			return "No job title was provided";
		}
		
		String bestMatch = "No normalized title was found";
		
		ArrayList<JobTitle> normalizedJobs = setupNormalizedJobs(this.getNormalizedStoredTitles());
		
		float largest = 0f;
		for(JobTitle j : normalizedJobs) {
			float score = j.calculateScore(inputTitle);
			
			if (Float.compare(largest, score) < 0) {
				largest = score;
				bestMatch = j.toString();
			}
		}
		
		return bestMatch.toString();
	}
	
	private ArrayList<JobTitle> setupNormalizedJobs(String[] storedTitles) {
		if(storedTitles == null || storedTitles.length == 0) {
			throw new IllegalArgumentException("No stored normalised title data");
		}
		
		JobTitleFactory factory = this.getJobTitleFactory();
		
		ArrayList<JobTitle> normalizedJobs = new ArrayList<JobTitle>();
		
		for(String storedTitle : storedTitles) {
			try {
				normalizedJobs.add(factory.getJobTitle(storedTitle));
			} catch(IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		
		return normalizedJobs;
	}

}
