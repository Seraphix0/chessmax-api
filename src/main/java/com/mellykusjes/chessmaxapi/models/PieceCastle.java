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
        List<Position> allowedTargetPositions = new ArrayList<>();
        Piece piece = boardState.get(initialPosition);

        // Check right of initialPosition
        for (int x = initialPosition.getX() + 1; x < 7; x++) {
            Position targetPosition = new Position(x, initialPosition.getY());

            // Check if targetPosition contains a piece
            if (verifyPositionOccupation(boardState, targetPosition, piece)) {
                allowedTargetPositions.add(targetPosition);
                break;
            } else {
                allowedTargetPositions.add(targetPosition);
            }
        }

        // Check left of initialPosition
        for (int x = initialPosition.getX() - 1; x > 0; x--) {
            Position targetPosition = new Position(x, initialPosition.getY());

            // Check if targetPosition contains a piece
            if (verifyPositionOccupation(boardState, targetPosition, piece)) {
                allowedTargetPositions.add(targetPosition);
                break;
            } else {
                allowedTargetPositions.add(targetPosition);
            }
        }

        // Check above initialPosition
        for (int y = initialPosition.getY() + 1; y < 7; y++) {
            Position targetPosition = new Position(initialPosition.getX(), y);

            // Check if targetPosition contains a piece
            if (verifyPositionOccupation(boardState, targetPosition, piece)) {
                allowedTargetPositions.add(targetPosition);
                break;
            } else {
                allowedTargetPositions.add(targetPosition);
            }
        }

        // Check under initialPosition
        for (int y = initialPosition.getY() - 1; y > 0; y--) {
            Position targetPosition = new Position(initialPosition.getX(), y);

            // Check if targetPosition contains a piece
            if (verifyPositionOccupation(boardState, targetPosition, piece)) {
                allowedTargetPositions.add(targetPosition);
                break;
            } else {
                allowedTargetPositions.add(targetPosition);
            }
        }

        if(allowedTargetPositions.isEmpty()) {
            return null;
        } else {
            return allowedTargetPositions;
        }
    }

    // TODO: Castle move logic
    public boolean isNotMoved() {
        return notMoved;
    }
}
