/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ivan
 */
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private List<Game> gameList;
    private List<Game> gameList1;
    private Country countryId;

    public Team() {
    }

    public Team(Integer id) {
        this.id = id;
    }

    public Team(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }

    public List<Game> getGameList1() {
        return gameList1;
    }

    public void setGameList1(List<Game> gameList1) {
        this.gameList1 = gameList1;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Team)) {
            return false;
        }
        Team other = (Team) object;
        return other.getId().equals(this.getId());
    }

    @Override
    public String toString() {
        return "Team --> " + name + ". ";
    }
}
