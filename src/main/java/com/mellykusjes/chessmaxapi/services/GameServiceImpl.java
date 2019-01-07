package com.mellykusjes.chessmaxapi.services;

import com.mellykusjes.chessmaxapi.factories.PieceFactoryImpl;
import com.mellykusjes.chessmaxapi.interfaces.GameService;
import com.mellykusjes.chessmaxapi.interfaces.PieceFactory;
import com.mellykusjes.chessmaxapi.models.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    private PieceFactory pieceFactory = new PieceFactoryImpl();

    @Override
    public Game createGame(User playerWhite, User playerBlack) {
        return new Game(playerWhite, playerBlack, createBoard());
    }

    @Override
    public Board createBoard() {
        return new Board(createInitialBoardstate());
    }

    @Override
    public HashMap<Position, Piece> createInitialBoardstate() {
        HashMap<Position, Piece> boardState = new HashMap<>();

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
    public Board ExecuteMove(Board board, Move move) {
        Board tempBoard = board;
        HashMap<Position, Piece> boardState = tempBoard.getBoardstate();
        List<Piece> removedPieces = tempBoard.getRemovedPieces();

        Piece initialPosition = boardState.get(move.getInitialPosition());

        boardState.remove(move.getInitialPosition());

        if (boardState.containsKey(move.getTargetPosition())) {
            removedPieces.add(boardState.get(move.getTargetPosition()));
            boardState.replace(move.getTargetPosition(), initialPosition);
        } else {
            boardState.put(move.getTargetPosition(), initialPosition);
        }

        tempBoard.setBoardstate(boardState);
        tempBoard.setRemovedPieces(removedPieces);

        tempBoard.history.add(move);

        return tempBoard;
    }
}
