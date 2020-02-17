package com.football;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.football.model.Competition;
import com.football.service.CompetitionService;

@SpringBootApplication
public class FootballCompetitionApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballCompetitionApiApplication.class, args);
		

	}

	@Bean
	CommandLineRunner runner(CompetitionService competitionService)
	{
		return args -> {
		try {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Competition>> typeRef = new TypeReference<List<Competition>>() {};
			InputStream inputstream = TypeReference.class.getResourceAsStream("/competition.json");
					//new FileInputStream(new File("/competition.json"));
			List<Competition> competitions;
			competitions = mapper.readValue(inputstream, typeRef);
			competitionService.saveAll(competitions);
			for (Competition c : competitions) {
				System.out.println(c.getId() +" "+ c.getCompetition() + " " + c.getCountry());
			}
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
	}
	
}
