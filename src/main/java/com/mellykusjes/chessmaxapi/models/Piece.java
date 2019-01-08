package com.mellykusjes.chessmaxapi.models;

import javax.persistence.*;

@Entity
@Table(name = "piece")
public abstract class Piece {

    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.ORDINAL)
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
