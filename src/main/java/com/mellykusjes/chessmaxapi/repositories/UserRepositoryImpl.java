package com.mellykusjes.chessmaxapi.repositories;

import com.mellykusjes.chessmaxapi.interfaces.UserRepository;
import com.mellykusjes.chessmaxapi.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private SessionFactory sessionFactory;

    public UserRepositoryImpl() {
        this("hibernate.cfg.xml");
    }

    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public UserRepositoryImpl(String filePath) {
        try {
            this.sessionFactory = new Configuration().configure(filePath).buildSessionFactory();
        } catch(Exception ex) {
            throw new ExceptionInInitializerError(ex.getMessage());
        }
    }

    @Override
    public void create(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public User read(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.getTransaction().commit();
        return user;
    }

    @Override
    public List<User> readAll() {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<User> query = session.createQuery("FROM User");
        List<User> users = query.getResultList();
        session.getTransaction().commit();
        return users;
    }

    @Override
    public void update(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.update(user);

        session.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();

        User user = session.load(User.class, id);

        if(user != null) {
            session.delete(user);
        }

        session.getTransaction().commit();
    }
}
