package com.mellykusjes.chessmaxapi.models;

public class PieceQueen extends Piece {

    @Override
    public void setType() {
        System.out.println("Adding Piece of type 'Queen' with id: " + getId());
    }
}
