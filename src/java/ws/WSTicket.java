/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import domain.BettingUser;
import domain.Ticket;
import java.text.MessageFormat;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ivan
 */
public class WSTicket {

    private final WebTarget webTarget;
    private final Client client;
    private static final String BASE_URI = "http://localhost:8080/betting/webresources";
    private static final String RESOURCE_URI = "/ticket/";

    public WSTicket() {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path(RESOURCE_URI);
    }

    public String getNewTicketId() {
        WebTarget wt = webTarget.path(MessageFormat.format("newid", (Object) null));
        return wt.request(MediaType.APPLICATION_JSON).get(String.class);
    }
    
    public void saveTicket(Ticket t) {
        WebTarget wt = webTarget.path(MessageFormat.format("saveticket", (Object) null));
        wt.request(MediaType.APPLICATION_JSON).post(Entity.entity(t, MediaType.APPLICATION_JSON));
    }
    
    public List<Ticket> getUserTickets(BettingUser u) {
        GenericType<List<Ticket>> gtTicketList = new GenericType<List<Ticket>>() {
        };
        WebTarget wt = webTarget.path(MessageFormat.format("usertickets", (Object) null));
        return wt.request(MediaType.APPLICATION_JSON).post(Entity.entity(u, MediaType.APPLICATION_JSON), gtTicketList);
    }
}
