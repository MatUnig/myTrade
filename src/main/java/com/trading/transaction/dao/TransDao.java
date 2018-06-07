package com.trading.transaction.dao;

import com.trading.transaction.model.Transaction;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TransDao {
    void buy(Transaction transaction, HttpServletRequest request);
    void sell(Transaction transaction, HttpServletRequest request);
    List getTrans(HttpServletRequest request);
    Transaction applyChanges(Transaction transaction);
    Transaction findById(int id);
    }

