package com.football.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.football.model.Competition;
import com.football.repository.CompetitionRepository;

@Service
public class CompetitionService {
	
	@Autowired
	private CompetitionRepository cometitionRepository;

	public CompetitionService(CompetitionRepository cometitionRepository) {
		this.cometitionRepository = cometitionRepository;
	}

	public Iterable<Competition> list() {
		return this.cometitionRepository.findAll();
	}

	public Iterable<Competition> saveAll(List<Competition> competitions) {
		return this.cometitionRepository.saveAll(competitions);
	}
	public Competition save(Competition competition) {
		return this.cometitionRepository.save(competition);
	}

	public Iterable<Competition> findByStatusType(String statusType) {
		return this.cometitionRepository.findByStatusType(statusType);
	}

	public Iterable<Competition> findByStatusTypeAndLiveStatus(String status, String liveStatus) {
		return this.cometitionRepository.findByStatusTypeAndLiveStatus(status,liveStatus);
	}
}
