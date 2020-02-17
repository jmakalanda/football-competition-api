package com.football.model;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Competition {

	    @Id @Column(insertable = false, updatable = false)
		private String id; 
		private String name; 
		private String competitionId; 
		private String competition ; 
		private String countryId; 
		private String country;   
		private String timestamp; 
		private String date ; 
		private String time ; 
		private String statusType;
		private Integer round; 
		private String homeTeamName; 
		private String awayTeamName ; 
		private Integer homeScoreCurrent ; 
		private Integer awayScoreCurrent; 
		private String liveStatus ;
		
		public Competition(String id, String name, String competitionId, String competition, String countryId,
				String country, String timestamp, String date, String time, String statusType, Integer round,
				String homeTeamName, String awayTeamName, Integer homeScoreCurrent, Integer awayScoreCurrent,
				String liveStatus) {
			super();
			this.id = id;
			this.name = name;
			this.competitionId = competitionId;
			this.competition = competition;
			this.countryId = countryId;
			this.country = country;
			this.timestamp = timestamp;
			this.date = date;
			this.time = time;
			this.statusType = statusType;
			this.round = round;
			this.homeTeamName = homeTeamName;
			this.awayTeamName = awayTeamName;
			this.homeScoreCurrent = homeScoreCurrent;
			this.awayScoreCurrent = awayScoreCurrent;
			this.liveStatus = liveStatus;
		}

		public Competition() {
			super();
		}
		
	    @JsonProperty("status")
	    private void unpackNestedStatus(Map<String,Object> status) {
	        this.statusType = (String)status.get("type");
	    }

	    @JsonProperty("round")
	    private void unpackNestedRound(Map<String,Object> round) {
	        this.setRound((Integer)round.get("round"));
	    }
	    
	    @JsonProperty("homeTeam")
	    private void unpackNestedHomeTeam(Map<String,Object> homeTeam) {
	        this.homeTeamName = (String)homeTeam.get("name");
	    }
	    @JsonProperty("awayTeam")
	    private void unpackNestedAwayTeam(Map<String,Object> awayTeam) {
	        this.awayTeamName = (String)awayTeam.get("name");
	    }
	    @JsonProperty("homeScore")
	    private void unpackNestedHomeScore(Map<String,Object> homeScore) {
	        this.homeScoreCurrent = (Integer)homeScore.get("current");
	    }
	    @JsonProperty("awayScore")
	    private void unpackNestedAwayScore(Map<String,Object> awayScore) {
	        this.awayScoreCurrent = (Integer)awayScore.get("current");
	    }
		
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCompetitionId() {
			return competitionId;
		}

		public void setCompetitionId(String competitionId) {
			this.competitionId = competitionId;
		}

		public String getCompetition() {
			return competition;
		}

		public void setCompetition(String competition) {
			this.competition = competition;
		}

		public String getCountryId() {
			return countryId;
		}

		public void setCountryId(String countryId) {
			this.countryId = countryId;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public String getStatusType() {
			return statusType;
		}

		public void setStatusType(String statusType) {
			this.statusType = statusType;
		}


		public String getHomeTeamName() {
			return homeTeamName;
		}

		public void setHomeTeamName(String homeTeamName) {
			this.homeTeamName = homeTeamName;
		}

		public String getAwayTeamName() {
			return awayTeamName;
		}

		public void setAwayTeamName(String awayTeamName) {
			this.awayTeamName = awayTeamName;
		}

		public Integer getHomeScoreCurrent() {
			return homeScoreCurrent;
		}

		public void setHomeScoreCurrent(Integer homeScoreCurrent) {
			this.homeScoreCurrent = homeScoreCurrent;
		}

		public Integer getAwayScoreCurrent() {
			return awayScoreCurrent;
		}

		public void setAwayScoreCurrent(Integer awayScoreCurrent) {
			this.awayScoreCurrent = awayScoreCurrent;
		}

		public String getLiveStatus() {
			return liveStatus;
		}

		public void setLiveStatus(String liveStatus) {
			this.liveStatus = liveStatus;
		}
		public Integer getRound() {
			return round;
		}

		public void setRound(Integer round) {
			this.round = round;
		}

	
}
