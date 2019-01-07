package com.mellykusjes.chessmaxapi.models;

public class PiecePawn extends Piece {

    private boolean notMoved = true;

    @Override
    public void setType() {
        System.out.println("Adding Piece of type 'Pawn' with id: " + getId());
    }
}
