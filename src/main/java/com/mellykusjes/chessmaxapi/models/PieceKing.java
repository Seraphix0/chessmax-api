package com.mellykusjes.chessmaxapi.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PieceKing extends Piece {

    private boolean notMoved = true;

    @Override
    public void setType() {
        System.out.println("Adding Piece of type 'King' with id: " + getId());
    }

    @Override
    public List<Position> computeAllowedTargetPositions(Map<Position, Piece> boardState, Position initialPosition) {
        List<Position> allowedTargetPositions = new ArrayList<>();

        // TODO: King single step range logic
        allowedTargetPositions.addAll(computeCrossMove(boardState, initialPosition));
        allowedTargetPositions.addAll(computeDiagonalMove(boardState, initialPosition));

        return allowedTargetPositions;
    }

    // TODO: Castle move logic
    public boolean isNotMoved() {
        return notMoved;
    }
}
