package com.mellykusjes.chessmaxapi.controllers;

import com.mellykusjes.chessmaxapi.interfaces.GameService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping(path = "/game/new", consumes = "application/json")
    public ApiResponse create()
}
