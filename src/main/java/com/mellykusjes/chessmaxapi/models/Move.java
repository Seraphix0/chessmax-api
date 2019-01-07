package com.mellykusjes.chessmaxapi.models;

public class Move {

    private Position initialPosition;
    private Position targetPosition;

    public Move(Position initialPosition, Position targetPosition) {
        this.initialPosition = initialPosition;
        this.targetPosition = targetPosition;
    }

    public Position getInitialPosition() {
        return initialPosition;
    }

    public Position getTargetPosition() {
        return targetPosition;
    }
}
