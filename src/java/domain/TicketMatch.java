/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author Ivan
 */
public class TicketMatch implements Serializable {

    private static final long serialVersionUID = 1L;
    protected TicketMatchPK ticketMatchPK;
    private int resultPrediction;
    private double odd;
    private Game game;
    private Status status;
    private Ticket ticket;

    public TicketMatch() {
    }

    public TicketMatch(TicketMatchPK ticketMatchPK) {
        this.ticketMatchPK = ticketMatchPK;
    }

    public TicketMatch(TicketMatchPK ticketMatchPK, int resultPrediction, double odd) {
        this.ticketMatchPK = ticketMatchPK;
        this.resultPrediction = resultPrediction;
        this.odd = odd;
    }

    public TicketMatch(String emailUser, String ticketId, String matchId) {
        this.ticketMatchPK = new TicketMatchPK(emailUser, ticketId, matchId);
    }

    public TicketMatchPK getTicketMatchPK() {
        return ticketMatchPK;
    }

    public void setTicketMatchPK(TicketMatchPK ticketMatchPK) {
        this.ticketMatchPK = ticketMatchPK;
    }

    public int getResultPrediction() {
        return resultPrediction;
    }

    public void setResultPrediction(int resultPrediction) {
        this.resultPrediction = resultPrediction;
    }

    public double getOdd() {
        return odd;
    }

    public void setOdd(double odd) {
        this.odd = odd;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketMatchPK != null ? ticketMatchPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TicketMatch)) {
            return false;
        }
        TicketMatch other = (TicketMatch) object;
        return other.getTicketMatchPK().equals(this.getTicketMatchPK());
    }

    @Override
    public String toString() {
        return "TicketMatch --> " + ticketMatchPK + ". ";
    }
}
