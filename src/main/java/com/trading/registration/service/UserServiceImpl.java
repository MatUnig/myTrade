package com.trading.registration.service;

import com.trading.registration.dao.UserDao;
import com.trading.registration.model.Login;
import com.trading.registration.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;

    public void register(User user) {
        userDao.register(user);
    }

    public User validateUser(Login login) {
        return userDao.validateUser(login);
    }

}