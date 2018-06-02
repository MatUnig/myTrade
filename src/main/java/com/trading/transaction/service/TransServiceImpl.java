package com.trading.transaction.service;

import com.trading.registration.dao.UserDao;
import com.trading.transaction.dao.TransDao;
import com.trading.transaction.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class TransServiceImpl implements TransService{
    @Autowired
    public TransDao transDao;


    @Override
    public void buy(Transaction transaction, HttpServletRequest request) {
        transDao.buy(transaction, request);
    }

    @Override
    public void sell(Transaction transaction, HttpServletRequest request) {
        transDao.sell(transaction, request);
    }

}
