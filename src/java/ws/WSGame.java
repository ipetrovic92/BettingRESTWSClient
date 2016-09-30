/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import domain.Game;
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
public class WSGame {

    private final WebTarget webTarget;
    private final Client client;
    private static final String BASE_URI = "http://localhost:8080/betting/webresources";
    private static final String RESOURCE_URI = "/game/";

    public WSGame() {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path(RESOURCE_URI);
    }

    public void edit(Game g) throws ClientErrorException {
        WebTarget wt = webTarget.path(MessageFormat.format("{0}", new Object[] {g.getId()}));
        wt.request(MediaType.APPLICATION_JSON).put(Entity.entity(g, MediaType.APPLICATION_JSON));
    }

    public List<Game> findAll() {
        GenericType<List<Game>> gtGameList = new GenericType<List<Game>>() {
        };
        WebTarget wt = webTarget.path(MessageFormat.format("", (Object) null));
        return wt.request(MediaType.APPLICATION_JSON).get(gtGameList);
    }
    
     public List<Game> getGameStartingAfter(String date) {
         GenericType<List<Game>> gtGameList = new GenericType<List<Game>>() {
        };
        WebTarget wt = webTarget.path(MessageFormat.format("gameafter/{0}", new Object[] {date}));
        return wt.request(MediaType.APPLICATION_JSON).get(gtGameList);
    }

}
