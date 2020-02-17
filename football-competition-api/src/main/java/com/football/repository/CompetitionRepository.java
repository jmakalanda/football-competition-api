package com.football.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import com.football.model.Competition;

public interface CompetitionRepository extends JpaRepository<Competition, String> {
	Iterable<Competition> findByStatusType(String statusType);

	Iterable<Competition> findByStatusTypeAndLiveStatus(String status, String liveStatus);

}
