package com.mellykusjes.chessmaxapi.models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "game")
public class Game {

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

    @OneToMany
    @MapKey
    private Map<Position, Piece> boardstate;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Piece> removedPieces;

    @OneToMany(fetch = FetchType.EAGER)
    public Set<Move> history;

    public Game(User playerWhite, User playerBlack, Map<Position, Piece> boardstate) {
        this.playerWhite = playerWhite;
        this.playerBlack = playerBlack;
        this.boardstate = boardstate;
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

    public Map<Position, Piece> getBoardstate() {
        return boardstate;
    }

    public void setBoardstate(Map<Position, Piece> boardstate) {
        this.boardstate = boardstate;
    }

    public Set<Piece> getRemovedPieces() {
        return removedPieces;
    }

    public void setRemovedPieces(Set<Piece> removedPieces) {
        this.removedPieces = removedPieces;
    }

    public Set<Move> getHistory() {
        return history;
    }

    public void setHistory(Set<Move> history) {
        this.history = history;
    }
}
