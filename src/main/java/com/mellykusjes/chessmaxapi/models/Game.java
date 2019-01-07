package com.mellykusjes.chessmaxapi.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @Column(name = "player_white", nullable = false)
    private User playerWhite;

    @OneToOne(fetch = FetchType.EAGER)
    @Column(name = "player_black", nullable = false)
    private User playerBlack;

    @OneToOne(fetch = FetchType.EAGER)
    private User winner;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<User> spectators = new HashSet<>();

    private Board board;

    public Game(User playerWhite, User playerBlack, Board board) {
        this.playerWhite = playerWhite;
        this.playerBlack = playerBlack;
        this.board = board;
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

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
