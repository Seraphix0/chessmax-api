package com.mellykusjes.chessmaxapi.services;

import com.mellykusjes.chessmaxapi.interfaces.UserRepository;
import com.mellykusjes.chessmaxapi.interfaces.UserService;
import com.mellykusjes.chessmaxapi.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        userRepository.create(user);
    }

    @Override
    public User read(int id) {
        return userRepository.read(id);
    }

    @Override
    public List<User> readAll() {
        return userRepository.readAll();
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }
}
