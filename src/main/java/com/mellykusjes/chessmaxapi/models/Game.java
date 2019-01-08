package com.mellykusjes.chessmaxapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue
    private int id;


    private Session session;

    private Board board;

    public Game(Session session, Board board) {
        this.session = session;
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
