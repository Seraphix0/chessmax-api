package com.mellykusjes.chessmaxapi.models;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

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

    public List<Position> computeAllowedTargetPositions(Map<Position, Piece> boardState, Position position) {
        throw new IllegalArgumentException("Cannot compute allowed target positions for base class 'Piece'.");
    }

    public boolean verifyPositionOccupation(Map<Position, Piece> boardState, Position targetPosition, Piece piece) {
        // Check if targetPosition contains a piece
        if (boardState.containsKey(targetPosition)) {

            // Check if piece at targetPosition is of opposite color
            return boardState.get(targetPosition).getColor() != piece.getColor();
        } else {
            return true;
        }
    }
}
