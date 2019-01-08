package com.mellykusjes.chessmaxapi.interfaces;

import com.mellykusjes.chessmaxapi.models.*;

import java.util.HashMap;

public interface GameService {

    Game createGame(User playerWhite, User playerBlack);
    Session createSession(User playerWhite, User playerBlack);
    Board createBoard();
    HashMap<Position, Piece> createInitialBoardstate();
    Game executeMove(Game game, Move move);
}
