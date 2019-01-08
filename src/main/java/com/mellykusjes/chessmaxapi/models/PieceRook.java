package com.mellykusjes.chessmaxapi.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PieceRook extends Piece {

    @Override
    public void setType() {
        System.out.println("Adding Piece of type 'Rook' with id: " + getId());
    }

    @Override
    public List<Position> computeAllowedTargetPositions(Map<Position, Piece> boardState, Position initialPosition) {
        return computeDiagonalMove(boardState, initialPosition);
    }
}
