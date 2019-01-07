package com.mellykusjes.chessmaxapi.models;

public class Position {
    private int x;
    private int y;

    public Position (int x, int y) {
        if (x > -1 && x < 8 && y > -1 && y < 8) {
            this.x = x;
            this.y = y;
        }
        else {
            throw new IllegalArgumentException("Position out of range.");
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
