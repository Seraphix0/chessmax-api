package com.mellykusjes.chessmaxapi.factories;

import com.mellykusjes.chessmaxapi.interfaces.GameService;
import com.mellykusjes.chessmaxapi.interfaces.ServiceFactory;
import com.mellykusjes.chessmaxapi.interfaces.UserRepository;
import com.mellykusjes.chessmaxapi.interfaces.UserService;
import com.mellykusjes.chessmaxapi.repositories.UserRepositoryImpl;
import com.mellykusjes.chessmaxapi.services.GameServiceImpl;
import com.mellykusjes.chessmaxapi.services.UserServiceImpl;

public class ServiceFactoryImpl implements ServiceFactory {

    private static ServiceFactoryImpl instance = new ServiceFactoryImpl();

    private ServiceFactoryImpl() {}

    public static ServiceFactory getInstance() { return instance; }

    @Override
    public GameService getGameService() {
        return new GameServiceImpl();
    }

    @Override
    public UserService getUserService() {
        return new UserServiceImpl(new UserRepositoryImpl());
    }
}
