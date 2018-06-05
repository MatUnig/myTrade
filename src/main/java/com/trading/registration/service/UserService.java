package com.trading.registration.service;

import com.trading.registration.model.Login;
import com.trading.registration.model.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    void register(User user);

    User validateUser(Login login);

    User applyChanges(User user);
}