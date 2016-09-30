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
public class BettingUser implements Serializable {

    private static final long serialVersionUID = 1L;
    private String email;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String password;
    private double balance;
    private List<Ticket> ticketList;

    public BettingUser() {
    }

    public BettingUser(String email) {
        this.email = email;
    }

    public BettingUser(String email, String firstName, String lastName, Date dateOfBirth, String password, double balance) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BettingUser)) {
            return false;
        }
        BettingUser other = (BettingUser) object;
        return other.getEmail().equals(this.getEmail());
    }

    @Override
    public String toString() {
        return "User --> " + firstName +  " " + lastName + "; Email: " + email + ". ";
    }
}
