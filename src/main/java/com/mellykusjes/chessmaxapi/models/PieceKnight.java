package com.mellykusjes.chessmaxapi.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PieceKnight extends Piece {

    @Override
    public void setType() {
        System.out.println("Adding Piece of type 'Knight' with id: " + getId());
    }

    public List<Position> computeAllowedTargetPositions(Map<Position, Piece> boardState, Position position) {
        return computeKnightMove(boardState, position);
    }

    private List<Position> computeKnightMove(Map<Position, Piece> boardState, Position initialPosition) {
        List<Position> allowedTargetPositions = new ArrayList<>();
        Piece piece = boardState.get(initialPosition);

        // Check initialPosition + Position(2, 1)
        if (initialPosition.getX() + 2 < 8 && initialPosition.getY() + 1 < 8) {
            Position targetPosition = new Position(initialPosition.getX() + 2, initialPosition.getY() + 1);

            // Check if targetPosition contains a piece
            if (boardState.containsKey(targetPosition)) {

                // Check if piece at targetPosition is of opposite color
                if (boardState.get(targetPosition).getColor() != piece.getColor()) {
                    allowedTargetPositions.add(targetPosition);
                }
            } else {
                allowedTargetPositions.add(targetPosition);
            }
        }

        // Check initialPosition + Position(1, 2)
        if (initialPosition.getX() + 1 < 8 && initialPosition.getY() + 2 < 8) {
            Position targetPosition = new Position(initialPosition.getX() + 1, initialPosition.getY() + 2);

            // Check if targetPosition contains a piece
            if (boardState.containsKey(targetPosition)) {

                // Check if piece at targetPosition is of opposite color
                if (boardState.get(targetPosition).getColor() != piece.getColor()) {
                    allowedTargetPositions.add(targetPosition);
                }
            } else {
                allowedTargetPositions.add(targetPosition);
            }
        }

        // Check initialPosition + Position(-2, -1)
        if (initialPosition.getX() - 2 > -1 && initialPosition.getY() - 1 > -1) {
            Position targetPosition = new Position(initialPosition.getX() - 2, initialPosition.getY() - 1);

            // Check if targetPosition contains a piece
            if (boardState.containsKey(targetPosition)) {

                // Check if piece at targetPosition is of opposite color
                if (boardState.get(targetPosition).getColor() != piece.getColor()) {
                    allowedTargetPositions.add(targetPosition);
                }
            } else {
                allowedTargetPositions.add(targetPosition);
            }
        }

        // Check initialPosition + Position(-1, -2)
        if (initialPosition.getX() - 1 > -1 && initialPosition.getY() - 2 > -1) {
            Position targetPosition = new Position(initialPosition.getX() - 1, initialPosition.getY() - 2);

            // Check if targetPosition contains a piece
            if (boardState.containsKey(targetPosition)) {

                // Check if piece at targetPosition is of opposite color
                if (boardState.get(targetPosition).getColor() != piece.getColor()) {
                    allowedTargetPositions.add(targetPosition);
                }
            } else {
                allowedTargetPositions.add(targetPosition);
            }
        }

        // Check initialPosition + Position(-2, 1)
        if (initialPosition.getX() - 2 > -1 && initialPosition.getY() + 1 < 8) {
            Position targetPosition = new Position(initialPosition.getX() - 2, initialPosition.getY() + 1);

            // Check if targetPosition contains a piece
            if (boardState.containsKey(targetPosition)) {

                // Check if piece at targetPosition is of opposite color
                if (boardState.get(targetPosition).getColor() != piece.getColor()) {
                    allowedTargetPositions.add(targetPosition);
                }
            } else {
                allowedTargetPositions.add(targetPosition);
            }
        }

        // Check initialPosition + Position(-1, 2)
        if (initialPosition.getX() - 1 > -1 && initialPosition.getY() + 2 < 8) {
            Position targetPosition = new Position(initialPosition.getX() - 1, initialPosition.getY() + 2);

            // Check if targetPosition contains a piece
            if (boardState.containsKey(targetPosition)) {

                // Check if piece at targetPosition is of opposite color
                if (boardState.get(targetPosition).getColor() != piece.getColor()) {
                    allowedTargetPositions.add(targetPosition);
                }
            } else {
                allowedTargetPositions.add(targetPosition);
            }
        }

        // Check initialPosition + Position(1, -2)
        if (initialPosition.getX() + 1 < 8 && initialPosition.getY() - 2 > -1) {
            Position targetPosition = new Position(initialPosition.getX() + 1, initialPosition.getY() - 2);

            // Check if targetPosition contains a piece
            if (boardState.containsKey(targetPosition)) {

                // Check if piece at targetPosition is of opposite color
                if (boardState.get(targetPosition).getColor() != piece.getColor()) {
                    allowedTargetPositions.add(targetPosition);
                }
            } else {
                allowedTargetPositions.add(targetPosition);
            }
        }

        // Check initialPosition + Position(2, -1)
        if (initialPosition.getX() + 2 < 8 && initialPosition.getY() - 2 > -1) {
            Position targetPosition = new Position(initialPosition.getX() + 2, initialPosition.getY() - 1);

            // Check if targetPosition contains a piece
            if (boardState.containsKey(targetPosition)) {

                // Check if piece at targetPosition is of opposite color
                if (boardState.get(targetPosition).getColor() != piece.getColor()) {
                    allowedTargetPositions.add(targetPosition);
                }
            } else {
                allowedTargetPositions.add(targetPosition);
            }
        }

        return allowedTargetPositions;
    }
}
