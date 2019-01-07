package com.mellykusjes.chessmaxapi.interfaces;

//TODO: Remove ServiceFactory after affirming that autowiring of services works.
public interface ServiceFactory {

    GameService getGameService();
    UserService getUserService();
}
