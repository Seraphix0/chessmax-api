package com.mellykusjes.chessmaxapi.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PiecePawn extends Piece {

    private boolean notMoved = true;

    @Override
    public void setType() {
        System.out.println("Adding Piece of type 'Pawn' with id: " + getId());
    }

    @Override
    public List<Position> computeAllowedTargetPositions(Map<Position, Piece> boardState, Position initialPosition) {
        return computePawnMove(boardState, initialPosition);
    }

    private List<Position> computePawnMove(Map<Position, Piece> boardState, Position initialPosition) {
        List<Position> allowedTargetPositions = new ArrayList<>();

        
    }
}
