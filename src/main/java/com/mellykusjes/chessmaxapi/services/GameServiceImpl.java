package com.mellykusjes.chessmaxapi.services;

import com.mellykusjes.chessmaxapi.factories.PieceFactoryImpl;
import com.mellykusjes.chessmaxapi.interfaces.GameService;
import com.mellykusjes.chessmaxapi.interfaces.PieceFactory;
import com.mellykusjes.chessmaxapi.models.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {
    private PieceFactory pieceFactory = new PieceFactoryImpl();

    @Override
    public Game createGame(User playerWhite, User playerBlack) {
        return new Game(playerWhite, playerBlack, createInitialBoardstate());
    }

    @Override
    public Map<Position, Piece> createInitialBoardstate() {
        Map<Position, Piece> boardState = new HashMap<>();

        boardState.put(new Position(0,0), pieceFactory.createPiece(Color.white, "Castle"));
        boardState.put(new Position(1,0), pieceFactory.createPiece(Color.white, "Knight"));
        boardState.put(new Position(2,0), pieceFactory.createPiece(Color.white, "Rook"));
        boardState.put(new Position(3,0), pieceFactory.createPiece(Color.white, "Queen"));
        boardState.put(new Position(4,0), pieceFactory.createPiece(Color.white, "King"));
        boardState.put(new Position(5,0), pieceFactory.createPiece(Color.white, "Rook"));
        boardState.put(new Position(6,0), pieceFactory.createPiece(Color.white, "Knight"));
        boardState.put(new Position(7,0), pieceFactory.createPiece(Color.white, "Castle"));

        for (int i = 0; i < 8; i++) {
            boardState.put(new Position(i, 1), pieceFactory.createPiece(Color.white, "Pawn"));
        }

        boardState.put(new Position(0,7), pieceFactory.createPiece(Color.black, "Castle"));
        boardState.put(new Position(1,7), pieceFactory.createPiece(Color.black, "Knight"));
        boardState.put(new Position(2,7), pieceFactory.createPiece(Color.black, "Rook"));
        boardState.put(new Position(3,7), pieceFactory.createPiece(Color.black, "Queen"));
        boardState.put(new Position(4,7), pieceFactory.createPiece(Color.black, "King"));
        boardState.put(new Position(5,7), pieceFactory.createPiece(Color.black, "Rook"));
        boardState.put(new Position(6,7), pieceFactory.createPiece(Color.black, "Knight"));
        boardState.put(new Position(7,7), pieceFactory.createPiece(Color.black, "Castle"));

        for (int i = 0; i < 8; i++) {
            boardState.put(new Position(i, 6), pieceFactory.createPiece(Color.black, "Pawn"));
        }

        return boardState;
    }

    @Override
    public Game executeMove(Game game, Move move) {
        // Create temporary working instances
        Game tempGame = game;
        Map<Position, Piece> boardState = tempGame.getBoardstate();
        Set<Piece> removedPieces = tempGame.getRemovedPieces();

        Piece initialPosition = boardState.get(move.getInitialPosition());

        boardState.remove(move.getInitialPosition());

        // Check if a piece occupies the target position
        // TODO: Implement move logic
        if (boardState.containsKey(move.getTargetPosition())) {
            removedPieces.add(boardState.get(move.getTargetPosition()));
            boardState.replace(move.getTargetPosition(), initialPosition);
        } else {
            boardState.put(move.getTargetPosition(), initialPosition);
        }

        // Return modified instance of 'game'
        tempGame.setBoardstate(boardState);
        tempGame.setRemovedPieces(removedPieces);

        tempGame.history.add(move);

        return tempGame;
    }
}
