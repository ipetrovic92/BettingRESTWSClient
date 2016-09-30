/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import domain.Administrator;
import java.text.MessageFormat;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ivan
 */
public class WSAdministrator {

    private final WebTarget webTarget;
    private final Client client;
    private static final String BASE_URI = "http://localhost:8080/betting/webresources";
    private static final String RESOURCE_URI = "/administrator/";

    public WSAdministrator() {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path(RESOURCE_URI);
    }

    public Administrator logIn(Administrator a) throws ClientErrorException {
        WebTarget wt = webTarget.path(MessageFormat.format("login", (Object) null));
        return wt.request(MediaType.APPLICATION_JSON).post(Entity.entity(a, MediaType.APPLICATION_JSON), Administrator.class);
    }
}
