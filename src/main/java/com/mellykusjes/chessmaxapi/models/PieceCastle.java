package com.mellykusjes.chessmaxapi.models;

public class PieceCastle extends Piece {

    private boolean notMoved = true;

    @Override
    public void setType() {
        System.out.println("Adding Piece of type 'Castle' with id: " + getId());
    }
}
