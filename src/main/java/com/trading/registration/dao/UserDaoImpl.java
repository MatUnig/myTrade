package com.trading.registration.dao;

import com.trading.registration.model.Login;
import com.trading.registration.model.User;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

@Component
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void register(User user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setBalance(10000.00);
        entityManager.persist(newUser);
    }

    @Override
    public User validateUser(Login login) {
        String username = login.getUsername();
        String password = login.getPassword();
        TypedQuery<User> query = entityManager.createQuery("select e from User e where e.username = ?1 and e.password = ?2", User.class);
        query.setParameter(1, username);
        query.setParameter(2, password);
        if (query.getResultList().size() > 0) {
            return query.getResultList().get(0);
        } else return null;
    }

    @Override
    public User applyChanges(User user) {
        return entityManager.merge(user);
    }
}
