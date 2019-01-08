package com.mellykusjes.chessmaxapi.models;

import javax.persistence.*;
import java.util.ArrayList;
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

    public abstract void setType();

    public List<Position> computeAllowedTargetPositions(Map<Position, Piece> boardState, Position position) {
        throw new IllegalArgumentException("Cannot compute allowed target positions for base class 'Piece'.");
    }

    public List<Position> computeCrossMove(Map<Position, Piece> boardState, Position initialPosition) {
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
        for (int x = initialPosition.getX() - 1; x > -1; x--) {
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
        for (int y = initialPosition.getY() - 1; y > -1; y--) {
            Position targetPosition = new Position(initialPosition.getX(), y);

            // Check if targetPosition contains a piece
            if (verifyPositionOccupation(boardState, targetPosition, piece)) {
                allowedTargetPositions.add(targetPosition);
                break;
            } else {
                allowedTargetPositions.add(targetPosition);
            }
        }

        return allowedTargetPositions;
    }

    public List<Position> computeDiagonalMove(Map<Position, Piece> boardState, Position initialPosition) {
        List<Position> allowedTargetPositions = new ArrayList<>();
        Piece piece = boardState.get(initialPosition);

        // Check top-right of initialPosition
        // Maintain count for diagonal steps
        int count = 0;
        for (int x = initialPosition.getX() + 1; x < 7; x++) {

            // Check if Y-axis does not exceed board range
            if (initialPosition.getY() + count < 7) {
                Position targetPosition = new Position(x, initialPosition.getY() + count);

                // Check if targetPosition contains a piece
                if (verifyPositionOccupation(boardState, targetPosition, piece)) {
                    allowedTargetPositions.add(targetPosition);
                    break;
                } else {
                    allowedTargetPositions.add(targetPosition);
                }
            } else {
                break;
            }
        }

        // Check top-left of initialPosition
        // Maintain count for diagonal steps
        count = 0;
        for (int x = initialPosition.getX() - 1; x > -1; x--) {

            // Check if Y-axis does not exceed board range
            if (initialPosition.getY() + count < 7) {
                Position targetPosition = new Position(x, initialPosition.getY() + count);

                // Check if targetPosition contains a piece
                if (verifyPositionOccupation(boardState, targetPosition, piece)) {
                    allowedTargetPositions.add(targetPosition);
                    break;
                } else {
                    allowedTargetPositions.add(targetPosition);
                }
            } else {
                break;
            }
        }

        // Check bottom-right of initialPosition
        // Maintain count for diagonal steps
        count = 0;
        for (int x = initialPosition.getX() + 1; x < 7; x++) {

            // Check if Y-axis does not exceed board range
            if (initialPosition.getY() - count > -1) {
                Position targetPosition = new Position(x, initialPosition.getY() - count);

                // Check if targetPosition contains a piece
                if (verifyPositionOccupation(boardState, targetPosition, piece)) {
                    allowedTargetPositions.add(targetPosition);
                    break;
                } else {
                    allowedTargetPositions.add(targetPosition);
                }
            } else {
                break;
            }
        }

        // Check bottom-left of initialPosition
        // Maintain count for diagonal steps
        count = 0;
        for (int x = initialPosition.getX() - 1; x > -1; x--) {

            // Check if Y-axis does not exceed board range
            if (initialPosition.getY() - count > -1) {
                Position targetPosition = new Position(x, initialPosition.getY() - count);

                // Check if targetPosition contains a piece
                if (verifyPositionOccupation(boardState, targetPosition, piece)) {
                    allowedTargetPositions.add(targetPosition);
                    break;
                } else {
                    allowedTargetPositions.add(targetPosition);
                }
            } else {
                break;
            }
        }

        return allowedTargetPositions;
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
