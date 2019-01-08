package com.mellykusjes.chessmaxapi.controllers;

import com.mellykusjes.chessmaxapi.interfaces.GameService;
import com.mellykusjes.chessmaxapi.models.Game;
import com.mellykusjes.chessmaxapi.models.Move;
import com.mellykusjes.chessmaxapi.models.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(path = "/game/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(User playerWhite, User playerBlack) {
        return gameService.createGame(playerWhite, playerBlack);
    }

    @PostMapping(path = "game/{id}/move")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Game executeMove(@PathVariable int id, Move move) {
        return gameService.executeMove(gameService.read(id), move);
    }
}
