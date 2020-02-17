package com.football.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.model.Competition;
import com.football.service.CompetitionService;

@RestController
@RequestMapping("/events")
public class CompetitionController {
	@Autowired
    private CompetitionService competionService;

	public CompetitionController(CompetitionService competionService) {
		this.competionService = competionService;
	}
	
	@GetMapping("/list")
	public Iterable<Competition> list(){
		return competionService.list();
	}
	
	@GetMapping("/status={status}")
	public Iterable<Competition> getCompatition(@PathVariable String status){
		return competionService.findByStatusType(status);
	}
	@GetMapping("/status={status}/liveStatus={liveStatus}")
	public Iterable<Competition> getCompatition(@PathVariable String status, @PathVariable String liveStatus){
		return competionService.findByStatusTypeAndLiveStatus(status,liveStatus);
	}
	 
}
