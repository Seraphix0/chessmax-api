package com.mellykusjes.chessmaxapi.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    private User playerWhite;

    @OneToOne(fetch = FetchType.EAGER)
    private User playerBlack;

    @OneToOne(fetch = FetchType.EAGER)
    private User winner;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<User> spectators = new HashSet<>();

    public Session(User playerWhite, User playerBlack) {
        this.playerWhite = playerWhite;
        this.playerBlack = playerBlack;
    }

    public User getPlayerWhite() {
        return playerWhite;
    }

    public User getPlayerBlack() {
        return playerBlack;
    }

    public User getWinner() {
        return winner;
    }

    public void setWinner(User winner) {
        this.winner = winner;
    }

    public Set<User> getSpectators() {
        return spectators;
    }

    public void setSpectators(Set<User> spectators) {
        this.spectators = spectators;
    }
}
