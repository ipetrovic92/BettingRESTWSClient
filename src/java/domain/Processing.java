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
public class Processing implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String processingOutcome;
    private List<Game> gameList;

    public Processing() {
    }

    public Processing(Integer id) {
        this.id = id;
    }

    public Processing(Integer id, String processingOutcome) {
        this.id = id;
        this.processingOutcome = processingOutcome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProcessingOutcome() {
        return processingOutcome;
    }

    public void setProcessingOutcome(String processingOutcome) {
        this.processingOutcome = processingOutcome;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Processing)) {
            return false;
        }
        Processing other = (Processing) object;
        return other.getId().equals(this.getId());
    }

    @Override
    public String toString() {
        return "Processing --> " + processingOutcome + ". ";
    }
}
