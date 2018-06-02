package com.trading.transaction.dao;

import com.trading.transaction.model.Transaction;

import javax.servlet.http.HttpServletRequest;

public interface TransDao {
    void buy(Transaction transaction, HttpServletRequest request);
    void sell(Transaction transaction, HttpServletRequest request);
}
