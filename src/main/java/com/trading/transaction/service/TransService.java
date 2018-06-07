package com.trading.transaction.service;

import com.trading.transaction.model.Transaction;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TransService {

    void buy (Transaction transaction, HttpServletRequest request);

    void sell (Transaction transaction, HttpServletRequest request);

    List<Transaction> getTrans(HttpServletRequest request);

    Transaction applyChanges(Transaction transaction);

    Transaction findById(int id);
}
