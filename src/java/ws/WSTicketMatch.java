/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import domain.TicketMatch;
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
public class WSTicketMatch {

    private final WebTarget webTarget;
    private final Client client;
    private static final String BASE_URI = "http://localhost:8080/betting/webresources";
    private static final String RESOURCE_URI = "/ticketmatch/";

    public WSTicketMatch() {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path(RESOURCE_URI);
    }

    public void saveTicket(TicketMatch tm) {
        WebTarget wt = webTarget.path(MessageFormat.format("", (Object) null));
        wt.request(MediaType.APPLICATION_JSON).post(Entity.entity(tm, MediaType.APPLICATION_JSON));
    }

    public List<TicketMatch> getTicketMatchList(String ticketId) {
        GenericType<List<TicketMatch>> gtTicketMatchList = new GenericType<List<TicketMatch>>() {
        };
        WebTarget wt = webTarget.path(MessageFormat.format("{0}", new Object[]{ticketId}));
        return wt.request(MediaType.APPLICATION_JSON).get(gtTicketMatchList);
    }

}
