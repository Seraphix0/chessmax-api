package com.mellykusjes.chessmaxapi.controllers;

import com.mellykusjes.chessmaxapi.interfaces.GameService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // TODO: Endpoints

}
