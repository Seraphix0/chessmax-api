package com.mellykusjes.chessmaxapi.models;

public class Game {

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
