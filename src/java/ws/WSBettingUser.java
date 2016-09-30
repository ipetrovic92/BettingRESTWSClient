/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import domain.BettingUser;
import java.text.MessageFormat;
import java.util.List;
import javax.ws.rs.ClientErrorException;
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
public class WSBettingUser {

    private final WebTarget webTarget;
    private final Client client;
    private static final String BASE_URI = "http://localhost:8080/betting/webresources";
    private static final String RESOURCE_URI = "/user/";

    public WSBettingUser() {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path(RESOURCE_URI);
    }

    public BettingUser logIn(BettingUser u) throws ClientErrorException {
        WebTarget wt = webTarget.path(MessageFormat.format("login", (Object) null));
        return wt.request(MediaType.APPLICATION_JSON).post(Entity.entity(u, MediaType.APPLICATION_JSON), BettingUser.class);
    }

    public void edit(BettingUser u) throws ClientErrorException {
        WebTarget wt = webTarget.path(MessageFormat.format("{0}", new Object[]{u.getEmail()}));
        wt.request(MediaType.APPLICATION_JSON).put(Entity.entity(u, MediaType.APPLICATION_JSON));
    }

    public List<BettingUser> findAll() {
        GenericType<List<BettingUser>> gtUserList = new GenericType<List<BettingUser>>() {
        };
        WebTarget wt = webTarget.path(MessageFormat.format("", (Object) null));
        return wt.request(MediaType.APPLICATION_JSON).get(gtUserList);
    }

    public void registerNewUser(BettingUser u) {
        WebTarget wt = webTarget.path(MessageFormat.format("register", (Object) null));
        wt.request(MediaType.APPLICATION_JSON).post(Entity.entity(u, MediaType.APPLICATION_JSON));

    }

    public BettingUser find(String id) {
        WebTarget wt = webTarget.path(MessageFormat.format("{0}", new Object[]{id}));
        return wt.request(MediaType.APPLICATION_JSON).get(BettingUser.class);
    }
}
