package com.mellykusjes.chessmaxapi.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PieceCastle extends Piece {

    private boolean notMoved = true;

    @Override
    public void setType() {
        System.out.println("Adding Piece of type 'Castle' with id: " + getId());
    }

    @Override
    public List<Position> computeAllowedTargetPositions(Map<Position, Piece> boardState, Position initialPosition) {
        return computeCrossMove(boardState, initialPosition);
    }

    // TODO: Castle move logic
    public boolean isNotMoved() {
        return notMoved;
    }
}
