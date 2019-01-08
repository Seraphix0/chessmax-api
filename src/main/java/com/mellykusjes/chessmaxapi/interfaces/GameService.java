package com.mellykusjes.chessmaxapi.interfaces;

import com.mellykusjes.chessmaxapi.models.Game;
import com.mellykusjes.chessmaxapi.models.User;
import com.mellykusjes.chessmaxapi.models.Position;
import com.mellykusjes.chessmaxapi.models.Piece;
import com.mellykusjes.chessmaxapi.models.Move;

import java.util.List;
import java.util.Map;

public interface GameService {

    Game createGame(User playerWhite, User playerBlack);
    Map<Position, Piece> createInitialBoardstate();
    Game executeMove(Game game, Move move);

    // CRUD operations
    void create(Game game);
    Game read(int id);
    List<Game> readAll();
    void update(Game game);
    void delete(int id);
}
