package com.mellykusjes.chessmaxapi.factories;

import com.mellykusjes.chessmaxapi.interfaces.PieceFactory;
import com.mellykusjes.chessmaxapi.models.*;
import org.springframework.stereotype.Component;

@Component
public class PieceFactoryImpl implements PieceFactory {

    @Override
    public Piece createPiece(Color color, String type) {
        Piece piece;
        switch (type.toLowerCase()) {
            case "castle":
                piece = new PieceCastle();
                break;
            case "king":
                piece = new PieceKing();
                break;
            case "knight":
                piece = new PieceKnight();
                break;
            case "pawn":
                piece = new PiecePawn();
                break;
            case "queen":
                piece = new PieceQueen();
                break;
            case "rook":
                piece = new PieceRook();
                break;
            default:
                throw new IllegalArgumentException("No such piece.");
        }

        piece.setColor(color);
        piece.setType();
        return piece;
    }
}
