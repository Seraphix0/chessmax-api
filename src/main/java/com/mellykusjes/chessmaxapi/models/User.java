package com.mellykusjes.chessmaxapi.models;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "games_played")
    private int gamesPlayed;

    @Column(name = "games_won")
    private int gamesWon;

    @Column(name = "games_white")
    private int gamesWhite;

    @Column(name = "games_black")
    private int gamesblack;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
