/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ws;

import domain.BettingUser;
import domain.Ticket;
import domain.TicketMatch;
import java.util.List;

/**
 *
 * @author Ivan
 */
public class WSController {
    
    public static WSController instance; 
    private final WSAdministrator wsAdministrator; 
    private final WSBettingUser wsBettingUser; 
    private final WSGame wsGame; 
    private final WSTicket wsTicket; 
    private final WSStatus wsStatus; 
    private final WSTicketMatch wsTicketMatch; 

    
    private WSController() {
        wsAdministrator = new WSAdministrator(); 
        wsBettingUser = new WSBettingUser();
        wsGame = new WSGame();
        wsTicket = new WSTicket();
        wsStatus = new WSStatus();
        wsTicketMatch = new WSTicketMatch();
    }
    
    public static WSController getInstance() {
        if(instance == null){
            instance = new WSController(); 
        }
        return instance; 
    }

    public WSAdministrator getWsAdministrator() {
        return wsAdministrator;
    }

    public WSBettingUser getWsBettingUser() {
        return wsBettingUser;
    }

    public WSGame getWsGame() {
        return wsGame;
    }

    public WSTicket getWsTicket() {
        return wsTicket;
    }

    public WSStatus getWsStatus() {
        return wsStatus;
    }

    public WSTicketMatch getWsTicketMatch() {
        return wsTicketMatch;
    }
    
    
    
    public void saveTicket (Ticket t) throws Exception{
        
        List<TicketMatch> ticketMatchList = t.getTicketMatchList();
        t.setTicketMatchList(null);
        
        if (t.getStake() < 30.0) {
            throw new Exception("Exception_TicketStakeIsLessThanMin");
        }

        if (ticketMatchList.isEmpty()) {
            throw new Exception("Exception_NoGameOnTheTicket");
        }
        
        for (TicketMatch ticketMatch : ticketMatchList) {
            if (ticketMatch.getGame().getGameTime().compareTo(t.getPaymentTime()) < 0) {
                throw new Exception("Exception_SomeOfTheGamesAlreadyStarted");
            }
        }
        
        wsTicket.saveTicket(t);
        
        for (TicketMatch ticketMatch : ticketMatchList) {
            wsTicketMatch.saveTicket(ticketMatch);
        }
    }
}
