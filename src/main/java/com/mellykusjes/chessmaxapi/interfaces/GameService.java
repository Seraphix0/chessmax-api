package com.mellykusjes.chessmaxapi.interfaces;

import com.mellykusjes.chessmaxapi.models.*;

import java.util.HashMap;

public interface GameService {

    Game createGame(User playerWhite, User playerBlack);
    Board createBoard();
    HashMap<Position, Piece> createInitialBoardstate();
    Board ExecuteMove(Board board, Move move);
}
