package com.mellykusjes.chessmaxapi.models;

public class PieceRook extends Piece {

    @Override
    public void setType() {
        System.out.println("Adding Piece of type 'Rook' with id: " + getId());
    }
}
