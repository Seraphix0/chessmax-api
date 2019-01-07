package com.mellykusjes.chessmaxapi.models;

public class PieceKnight extends Piece {

    @Override
    public void setType() {
        System.out.println("Adding Piece of type 'Knight' with id: " + getId());
    }
}
