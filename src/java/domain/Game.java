/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ivan
 */
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private Date gameTime;
    private double homeOdds;
    private double awayOdds;
    private double drawOdds;
    private String score;
    private Team awayTeam;
    private Administrator emailAdministrator;
    private Team homeTeam;
    private Processing processingStatus;
    private List<TicketMatch> ticketMatchList;

    public Game() {
    }

    public Game(String id) {
        this.id = id;
    }

    public Game(String id, Date gameTime, double homeOdds, double awayOdds, double drawOdds, String score) {
        this.id = id;
        this.gameTime = gameTime;
        this.homeOdds = homeOdds;
        this.awayOdds = awayOdds;
        this.drawOdds = drawOdds;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getGameTime() {
        return gameTime;
    }

    public void setGameTime(Date gameTime) {
        this.gameTime = gameTime;
    }

    public double getHomeOdds() {
        return homeOdds;
    }

    public void setHomeOdds(double homeOdds) {
        this.homeOdds = homeOdds;
    }

    public double getAwayOdds() {
        return awayOdds;
    }

    public void setAwayOdds(double awayOdds) {
        this.awayOdds = awayOdds;
    }

    public double getDrawOdds() {
        return drawOdds;
    }

    public void setDrawOdds(double drawOdds) {
        this.drawOdds = drawOdds;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Administrator getEmailAdministrator() {
        return emailAdministrator;
    }

    public void setEmailAdministrator(Administrator emailAdministrator) {
        this.emailAdministrator = emailAdministrator;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Processing getProcessingStatus() {
        return processingStatus;
    }

    public void setProcessingStatus(Processing processingStatus) {
        this.processingStatus = processingStatus;
    }

    public List<TicketMatch> getTicketMatchList() {
        return ticketMatchList;
    }

    public void setTicketMatchList(List<TicketMatch> ticketMatchList) {
        this.ticketMatchList = ticketMatchList;
    }

     @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Game)) {
            return false;
        }
        Game other = (Game) object;
        return other.getId().equals(this.getId());
    }

    @Override
    public String toString() {
        return "Game --> Home: " + homeTeam.getName() + " vs Away: " + awayTeam.getName() + ". ";
    }
}
