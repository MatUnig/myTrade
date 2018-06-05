package com.trading.transaction.dao;


import com.trading.registration.model.User;
import com.trading.transaction.functions.Function;
import com.trading.transaction.model.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class TransDaoImpl implements TransDao {
    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("myDatabaseConfig");
    EntityManager buyManager = entityManagerFactory.createEntityManager();
    EntityManager sellManager = entityManagerFactory.createEntityManager();
    EntityManager transManager = entityManagerFactory.createEntityManager();

    @Override
    public void buy(Transaction transaction, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        User currentUser = (User) sess.getAttribute("user");
        Transaction trans = new Transaction();
        trans.setDate(trans.getDate());
        trans.setFromCurrency(request.getParameter("fromCurrency"));
        trans.setToCurrency(request.getParameter("toCurrency"));
        trans.setProduct(request.getParameter("product"));
        trans.setType("Buy");
        trans.setQuantity(Double.parseDouble(request.getParameter("quantity")));
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


    public List<Transaction> getTrans(HttpServletRequest request){
        Query q = transManager.createQuery("SELECT x from Transaction x where x.user_id=:id");
        HttpSession sess = request.getSession();
        User currentUser = (User) sess.getAttribute("user");
        q.setParameter("id", currentUser.getId());
        return q.getResultList();
    }

    @Override
    public void applyChanges(Transaction transaction, HttpServletRequest request) {
        transManager.getTransaction().begin();
        transManager.persist(transaction);
        transManager.getTransaction().commit();
        }

}
