package com.mellykusjes.chessmaxapi.models;

public abstract class Piece {
    private int id;
    private Color color;

    public int getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void setType();
}
