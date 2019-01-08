package com.mellykusjes.chessmaxapi.interfaces;

import com.mellykusjes.chessmaxapi.models.Game;

import java.util.List;

public interface GameRepository {
    void create(Game game);
    Game read(int id);
    List<Game> readAll();
    void update(Game game);
    void delete(int id);
}
