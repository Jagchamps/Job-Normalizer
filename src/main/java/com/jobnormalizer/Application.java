package com.jobnormalizer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jobnormalizer.normalizer.Normalizer;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String jt = "Java engineer";
		Normalizer n = new Normalizer();
		String normalizedTitle = n.normalize(jt);
		//output normalizedTitle
		System.out.println(normalizedTitle);
		
		jt = "C# engineer";
		normalizedTitle = n.normalize(jt);
		//output normalizedTitle
		System.out.println(normalizedTitle);
		
		jt = "Chief Accountant";
		normalizedTitle = n.normalize(jt);
		// output normalizedTitle
		System.out.println(normalizedTitle);
	}

}
