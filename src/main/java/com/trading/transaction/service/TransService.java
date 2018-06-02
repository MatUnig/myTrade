package com.trading.transaction.service;

import com.trading.transaction.model.Transaction;

import javax.servlet.http.HttpServletRequest;

public interface TransService {

    void buy (Transaction transaction, HttpServletRequest request);

    void sell (Transaction transaction, HttpServletRequest request);
}
