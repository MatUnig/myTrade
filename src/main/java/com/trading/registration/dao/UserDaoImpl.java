package com.trading.registration.dao;

import com.trading.registration.model.Login;
import com.trading.registration.model.User;
import javax.persistence.*;


public class UserDaoImpl implements UserDao {

    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("myDatabaseConfig");
    EntityManager registerManager = entityManagerFactory.createEntityManager();
    EntityManager loginManager = entityManagerFactory.createEntityManager();


    public void register(User user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        registerManager.getTransaction().begin();
        registerManager.persist(newUser);
        registerManager.getTransaction().commit();
    }

    @Override
    public User validateUser(Login login) {
        String username = login.getUsername();
        String password = login.getPassword();
        TypedQuery<User> query = loginManager.createQuery("select e from User e where e.username = ?1 and e.password = ?2", User.class);
        query.setParameter(1, username);
        query.setParameter(2, password);
        if (query.getResultList().size() > 0) {
            return query.getResultList().get(0);
        } else return null;
    }
}
