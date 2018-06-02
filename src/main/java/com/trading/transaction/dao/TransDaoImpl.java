package com.trading.transaction.dao;


import com.trading.transaction.model.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

public class TransDaoImpl implements TransDao {
    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("myDatabaseConfig");
    EntityManager buyManager = entityManagerFactory.createEntityManager();
    EntityManager sellManager = entityManagerFactory.createEntityManager();

    @Override
    public void buy(Transaction transaction, HttpServletRequest request) {
        Transaction trans = new Transaction();
//        trans.setPrice(Double.parseDouble(request.getParameter("price")));
        trans.setDate(trans.getDate());
        trans.setProduct(request.getParameter("product"));
        trans.setType("Buy");
        trans.setPrice(Double.parseDouble(request.getParameter("price")));
        buyManager.getTransaction().begin();
        buyManager.persist(trans);
        buyManager.getTransaction().commit();

    }

    @Override
    public void sell(Transaction transaction, HttpServletRequest request) {

    }
}
