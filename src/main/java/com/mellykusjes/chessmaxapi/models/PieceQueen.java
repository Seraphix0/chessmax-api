package com.mellykusjes.chessmaxapi.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PieceQueen extends Piece {

    @Override
    public void setType() {
        System.out.println("Adding Piece of type 'Queen' with id: " + getId());
    }

    @Override
    public List<Position> computeAllowedTargetPositions(Map<Position, Piece> boardState, Position initialPosition) {
        List<Position> allowedTargetPositions = new ArrayList<>();

        allowedTargetPositions.addAll(computeCrossMove(boardState, initialPosition));
        allowedTargetPositions.addAll(computeDiagonalMove(boardState, initialPosition));

        return allowedTargetPositions;
    }
}
