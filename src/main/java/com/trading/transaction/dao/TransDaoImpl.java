package com.trading.transaction.dao;


import com.trading.registration.model.User;
import com.trading.transaction.model.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class TransDaoImpl implements TransDao {
    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("myDatabaseConfig");
    EntityManager buyManager = entityManagerFactory.createEntityManager();
    EntityManager sellManager = entityManagerFactory.createEntityManager();

    @Override
    public void buy(Transaction transaction, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        User currentUser = (User) sess.getAttribute("user");
        Transaction trans = new Transaction();
        trans.setDate(trans.getDate());
        trans.setProduct(request.getParameter("product"));
        trans.setType("Buy");
        trans.setPrice(Double.parseDouble(request.getParameter("price")));
        trans.setUser_id(currentUser.getId());
        System.out.println(currentUser.getName());
        System.out.println(currentUser.getBalance());
        System.out.println(currentUser.getId());
        buyManager.getTransaction().begin();
        buyManager.persist(trans);
        buyManager.getTransaction().commit();

    }

    @Override
    public void sell(Transaction transaction, HttpServletRequest request) {

    }
}
