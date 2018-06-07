package com.trading.transaction.service;

import com.trading.registration.dao.UserDao;
import com.trading.transaction.dao.TransDao;
import com.trading.transaction.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;

public class TransServiceImpl implements TransService {
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

    @Override
    public List<Transaction> getTrans(HttpServletRequest request) {
        return transDao.getTrans(request);
    }

    @Override
    public Transaction applyChanges(Transaction transaction){ return transDao.applyChanges(transaction);}

    @Override
    public Transaction findById(int id){ return transDao.findById(id);  }

}
