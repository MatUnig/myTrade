package com.trading.registration.service;

import com.trading.registration.model.Login;
import com.trading.registration.model.User;

public interface UserService {

    void register(User user);

    User validateUser(Login login);
}