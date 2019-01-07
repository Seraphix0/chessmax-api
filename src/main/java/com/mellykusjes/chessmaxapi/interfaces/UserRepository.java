package com.mellykusjes.chessmaxapi.interfaces;

import com.mellykusjes.chessmaxapi.models.User;

import java.util.List;

public interface UserRepository {
    void create(User user);
    User read(int id);
    List<User> readAll();
    void update(User user);
    void delete(int id);
}
