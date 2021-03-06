/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import domain.Administrator;
import domain.BettingUser;
import domain.Game;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.lang3.StringUtils;
import util.JsfUtil;
import ws.WSController;

/**
 *
 * @author Ivan
 */
@ManagedBean
@SessionScoped
public class MbAdministrator implements Serializable {

    private Administrator administrator;
    private List<Game> gameList;
    private List<Game> filteredGamesList;
    private Game selectedGame;
    private String homeGoals;
    private String awayGoals;
    private List<BettingUser> usersList;
    private List<BettingUser> filteredUsersList;
    private BettingUser selectedUser;
    private String balanceIncrement;

    public MbAdministrator() {
    }

    @PostConstruct
    public void init() {
        administrator = new Administrator();
        gameList = WSController.getInstance().getWsGame().findAll();
        usersList = WSController.getInstance().getWsBettingUser().findAll();
        filteredGamesList = gameList;
        balanceIncrement = "0";
    }

    public String logIn() {
        Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        Administrator a;
        try {
            a = WSController.getInstance().getWsAdministrator().logIn(administrator);
        } catch (Exception e) {
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("localization.messages", locale).getString("LogInAdministratorMessage_failure"));
            return "index";
        }

        if (a == null) {
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("localization.messages", locale).getString("LogInAdministratorMessage_failure"));
            return "index";
        }
        administrator = a;
        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("localization.messages", locale).getString("LogInAdministratorMessage_success"));
        return "admin?faces-redirect=true";
    }

    public String logOut() {
        Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        administrator = new Administrator();
        filteredGamesList = gameList;
        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("localization.messages", locale).getString("AdministratorMessage_successLogOut"));
        return "index?faces-redirect=true";
    }

    public String getBalanceIncrement() {
        return balanceIncrement;
    }

    public void setBalanceIncrement(String balanceIncrement) {
        this.balanceIncrement = balanceIncrement;
    }

    public void increaseUserBalance() {
        Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

        if (selectedUser == null || balanceIncrement == null || !StringUtils.isNumeric(balanceIncrement)) {
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("localization.messages", locale).getString("AdministratorUserBalance_failure"));
            return;
        }
        double newBalance = selectedUser.getBalance() + Double.parseDouble(balanceIncrement);

        selectedUser.setBalance(newBalance);

        try {
            WSController.getInstance().getWsBettingUser().edit(selectedUser);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("localization.messages", locale).getString("AdministratorUserBalance_success"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("localization.messages", locale).getString("AdministratorUserBalance_failure"));
        }
        setDefaultUserBalanceTableValue();
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }

    public Game getSelectedGame() {
        return selectedGame;
    }

    public void setSelectedGame(Game selectedGame) {
        if (selectedGame == null) {
            return;
        }
        this.selectedGame = selectedGame;
        String result = selectedGame.getScore();
        if (result.isEmpty()) {
            homeGoals = "";
            awayGoals = "";
        } else {
            String[] resultArray = result.split(":");
            homeGoals = resultArray[0];
            awayGoals = resultArray[1];
        }
    }

    public void setDefaultUserBalanceTableValue() {
        filteredUsersList = usersList;
        balanceIncrement = "0";
    }

    public void saveGameScore() {
        Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        if (!StringUtils.isNumeric(homeGoals) || !StringUtils.isNumeric(awayGoals)) {
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("localization.messages", locale).getString("AdministratorGameEdit_failureMessage"));
            return;
        }
        selectedGame.setScore(homeGoals.trim() + ":" + awayGoals.trim());
        try {
            WSController.getInstance().getWsGame().edit(selectedGame);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("localization.messages", locale).getString("AdministratorGameEdit_successMessage"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("localization.messages", locale).getString("AdministratorGameEdit_failureMessage"));
        }
    }

    public List<Game> getFilteredGamesList() {
        return filteredGamesList;
    }

    public void setFilteredGamesList(List<Game> filteredGamesList) {
        this.filteredGamesList = filteredGamesList;
    }

    public String getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(String homeGoals) {
        this.homeGoals = homeGoals;
    }

    public String getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(String awayGoals) {
        this.awayGoals = awayGoals;
    }

    public List<BettingUser> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<BettingUser> usersList) {
        this.usersList = usersList;
    }

    public BettingUser getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(BettingUser selectedUser) {
        this.selectedUser = selectedUser;
    }

    public List<BettingUser> getFilteredUsersList() {
        return filteredUsersList;
    }

    public void setFilteredUsersList(List<BettingUser> filteredUsersList) {
        this.filteredUsersList = filteredUsersList;
    }

}
