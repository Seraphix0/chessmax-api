package com.mellykusjes.chessmaxapi.models;

import java.util.HashMap;
import java.util.List;

public class Board {

    private HashMap<Position, Piece> boardstate;
    private List<Piece> removedPieces;

    public List<Move> history;

    public Board(HashMap<Position, Piece> boardstate) {
        this.boardstate = boardstate;
    }

    public HashMap<Position, Piece> getBoardstate() {
        return boardstate;
    }

    public void setBoardstate(HashMap<Position, Piece> boardstate) {
        this.boardstate = boardstate;
    }

    public List<Piece> getRemovedPieces() {
        return removedPieces;
    }

    public void setRemovedPieces(List<Piece> removedPieces) {
        this.removedPieces = removedPieces;
    }
}
