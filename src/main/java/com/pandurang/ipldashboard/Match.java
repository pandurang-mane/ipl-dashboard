package com.pandurang.ipldashboard;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "match")
public class Match {

    @Id
    private Long id;
    private String city;
    private Date date;
    private String season;
    private String matchNumber;
    private String team1;
    private String team2;
    private String venue;
    private String tossWinner;
    private String tossDecision;
    private String superOver;
    private String winningTeam;
    private String wonBy;
    private String margin;
    private String method;
    private String playerOfMatch;
    private String team1Players;
    private String team2Players;
    private String umpire1;
    private String umpire2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(String matchNumber) {
        this.matchNumber = matchNumber;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getTossWinner() {
        return tossWinner;
    }

    public void setTossWinner(String tossWinner) {
        this.tossWinner = tossWinner;
    }

    public String getTossDecision() {
        return tossDecision;
    }

    public void setTossDecision(String tossDecision) {
        this.tossDecision = tossDecision;
    }

    public String getSuperOver() {
        return superOver;
    }

    public void setSuperOver(String superOver) {
        this.superOver = superOver;
    }

    public String getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam(String winningTeam) {
        this.winningTeam = winningTeam;
    }

    public String getWonBy() {
        return wonBy;
    }

    public void setWonBy(String wonBy) {
        this.wonBy = wonBy;
    }

    public String getMargin() {
        return margin;
    }

    public void setMargin(String margin) {
        this.margin = margin;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPlayerOfMatch() {
        return playerOfMatch;
    }

    public void setPlayerOfMatch(String playerOfMatch) {
        this.playerOfMatch = playerOfMatch;
    }

    public String getTeam1Players() {
        return team1Players;
    }

    public void setTeam1Players(String team1Players) {
        this.team1Players = team1Players;
    }

    public String getTeam2Players() {
        return team2Players;
    }

    public void setTeam2Players(String team2Players) {
        this.team2Players = team2Players;
    }

    public String getUmpire1() {
        return umpire1;
    }

    public void setUmpire1(String umpire1) {
        this.umpire1 = umpire1;
    }

    public String getUmpire2() {
        return umpire2;
    }

    public void setUmpire2(String umpire2) {
        this.umpire2 = umpire2;
    }

    public Match(Long id, String city, Date date, String season, String matchNumber, String team1, String team2, String venue, String tossWinner, String tossDecision, String superOver, String winningTeam, String wonBy, String margin, String method, String playerOfMatch, String team1Players, String team2Players, String umpire1, String umpire2) {
        this.id = id;
        this.city = city;
        this.date = date;
        this.season = season;
        this.matchNumber = matchNumber;
        this.team1 = team1;
        this.team2 = team2;
        this.venue = venue;
        this.tossWinner = tossWinner;
        this.tossDecision = tossDecision;
        this.superOver = superOver;
        this.winningTeam = winningTeam;
        this.wonBy = wonBy;
        this.margin = margin;
        this.method = method;
        this.playerOfMatch = playerOfMatch;
        this.team1Players = team1Players;
        this.team2Players = team2Players;
        this.umpire1 = umpire1;
        this.umpire2 = umpire2;
    }

    public Match() {
    }

    @Override
    public String toString() {
        return "Match{" +
                "id='" + id + '\'' +
                ", city='" + city + '\'' +
                ", date='" + date + '\'' +
                ", season='" + season + '\'' +
                ", matchNumber='" + matchNumber + '\'' +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", venue='" + venue + '\'' +
                ", tossWinner='" + tossWinner + '\'' +
                ", tossDecision='" + tossDecision + '\'' +
                ", superOver='" + superOver + '\'' +
                ", winningTeam='" + winningTeam + '\'' +
                ", wonBy='" + wonBy + '\'' +
                ", margin='" + margin + '\'' +
                ", method='" + method + '\'' +
                ", playerOfMatch='" + playerOfMatch + '\'' +
                ", team1Players='" + team1Players + '\'' +
                ", team2Players='" + team2Players + '\'' +
                ", umpire1='" + umpire1 + '\'' +
                ", umpire2='" + umpire2 + '\'' +
                '}';
    }
}
