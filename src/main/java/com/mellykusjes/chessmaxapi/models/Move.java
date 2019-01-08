package com.mellykusjes.chessmaxapi.models;

import javax.persistence.*;

@Entity
@Table(name = "move")
public class Move {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    private Position initialPosition;

    @OneToOne(fetch = FetchType.EAGER)
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
