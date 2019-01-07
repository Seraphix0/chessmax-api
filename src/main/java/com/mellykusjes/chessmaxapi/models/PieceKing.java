package com.mellykusjes.chessmaxapi.models;

public class PieceKing extends Piece {


    private boolean notMoved = true;

    @Override
    public void setType() {
        System.out.println("Adding Piece of type 'King' with id: " + getId());
    }
}
