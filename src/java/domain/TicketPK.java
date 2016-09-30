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
public class TicketPK implements Serializable {

    private String emailUser;
    private String id;

    public TicketPK() {
    }

    public TicketPK(String emailUser, String id) {
        this.emailUser = emailUser;
        this.id = id;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailUser != null ? emailUser.hashCode() : 0);
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TicketPK)) {
            return false;
        }
        TicketPK other = (TicketPK) object;
        return other.getEmailUser().equals(this.getEmailUser()) && other.getId().equals(this.getId());
    }

    @Override
    public String toString() {
        return "TicketPK --> Email user: " + emailUser + "; ID: " + id + ". ";
    }
}
