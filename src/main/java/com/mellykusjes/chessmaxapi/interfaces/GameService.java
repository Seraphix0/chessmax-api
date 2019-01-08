package com.mellykusjes.chessmaxapi.interfaces;

import com.mellykusjes.chessmaxapi.models.*;

import java.util.Map;

public interface GameService {

    Game createGame(User playerWhite, User playerBlack);
    Map<Position, Piece> createInitialBoardstate();
    Game executeMove(Game game, Move move);
}
