/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ivan
 */
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    protected TicketPK ticketPK;
    private Date paymentTime;
    private double stake;
    private double totalOdds;
    private double potentialWinnings;
    private List<TicketMatch> ticketMatchList;
    private BettingUser bettingUser;
    private Status status;

    public Ticket() {
    }

    public Ticket(TicketPK ticketPK) {
        this.ticketPK = ticketPK;
    }

    public Ticket(TicketPK ticketPK, Date paymentTime, double stake, double totalOdds, double potentialWinnings) {
        this.ticketPK = ticketPK;
        this.paymentTime = paymentTime;
        this.stake = stake;
        this.totalOdds = totalOdds;
        this.potentialWinnings = potentialWinnings;
    }

    public Ticket(String emailUser, String id) {
        this.ticketPK = new TicketPK(emailUser, id);
    }

    public TicketPK getTicketPK() {
        return ticketPK;
    }

    public void setTicketPK(TicketPK ticketPK) {
        this.ticketPK = ticketPK;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public double getStake() {
        return stake;
    }

    public void setStake(double stake) {
        this.stake = stake;
    }

    public double getTotalOdds() {
        return totalOdds;
    }

    public void setTotalOdds(double totalOdds) {
        this.totalOdds = totalOdds;
    }

    public double getPotentialWinnings() {
        return potentialWinnings;
    }

    public void setPotentialWinnings(double potentialWinnings) {
        this.potentialWinnings = potentialWinnings;
    }

    public List<TicketMatch> getTicketMatchList() {
        return ticketMatchList;
    }

    public void setTicketMatchList(List<TicketMatch> ticketMatchList) {
        this.ticketMatchList = ticketMatchList;
    }

    public BettingUser getBettingUser() {
        return bettingUser;
    }

    public void setBettingUser(BettingUser bettingUser) {
        this.bettingUser = bettingUser;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketPK != null ? ticketPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        return other.getTicketPK().equals(this.getTicketPK());
    }

    @Override
    public String toString() {
        String result = ""; 
        
        StringBuilder sb = new StringBuilder(); 
        sb.append("****************************************\n");
        sb.append("User: ").append(bettingUser.getFirstName()).append(" ").append(bettingUser.getLastName()).append(". \n"); 
        sb.append("ID: ").append(getTicketPK().getId()).append(". Time: ").append(new SimpleDateFormat("dd.MM.yyyy").format(paymentTime)).append(". \n"); 
        sb.append("Stake: ").append(stake).append(". Total Odds: ").append(totalOdds).append(". Potential winning amount: ").append(potentialWinnings).append(". \n"); 
        
        for (TicketMatch ticketMatch : ticketMatchList) {
            sb.append(ticketMatch.getGame().toString()).append(". Prediction: ").append(ticketMatch.getResultPrediction()).append(". Status: ").append(ticketMatch.getStatus()).append(". \n"); 
        }
        sb.append("****************************************");
        
        return result;
    }
}
