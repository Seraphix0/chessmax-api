package com.mellykusjes.chessmaxapi.repositories;

import com.mellykusjes.chessmaxapi.interfaces.GameRepository;
import com.mellykusjes.chessmaxapi.models.Game;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GameRepositoryImpl implements GameRepository {

    private SessionFactory sessionFactory;

    public GameRepositoryImpl() {
        this("hibernate.cfg.xml");
    }

    public GameRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public GameRepositoryImpl(String filePath) {
        try {
            this.sessionFactory = new Configuration().configure(filePath).buildSessionFactory();
        } catch(Exception ex) {
            throw new ExceptionInInitializerError(ex.getMessage());
        }
    }

    @Override
    public void create(Game game) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.save(game);
        session.getTransaction().commit();
    }

    @Override
    public Game read(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Game game = session.get(Game.class, id);
        session.getTransaction().commit();
        return game;
    }

    @Override
    public List<Game> readAll() {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<Game> query = session.createQuery("FROM Game");
        List<Game> games = query.getResultList();
        session.getTransaction().commit();
        return games;
    }

    @Override
    public void update(Game game) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.update(game);

        session.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();

        Game game = session.load(Game.class, id);

        if(game != null) {
            session.delete(game);
        }

        session.getTransaction().commit();
    }
}
