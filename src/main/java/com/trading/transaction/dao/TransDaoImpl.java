package com.trading.transaction.dao;


import com.trading.registration.model.User;
import com.trading.transaction.functions.Function;
import com.trading.transaction.model.Transaction;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.awt.print.Book;
import java.io.IOException;
import java.util.List;

@Component
@Transactional
public class TransDaoImpl implements TransDao {

    @PersistenceContext
    EntityManager entityManager;

//    EntityManagerFactory entityManagerFactory =
//            Persistence.createEntityManagerFactory("myDatabaseConfig");
//    EntityManager transManager = entityManagerFactory.createEntityManager();
//    EntityManager findManager = entityManagerFactory.createEntityManager();
//    EntityManager changesManager = entityManagerFactory.createEntityManager();
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
        entityManager.persist(trans);
    }

    @Override
    public void sell(Transaction transaction, HttpServletRequest request) {

    }

    @Override
    public Transaction findById(int id) {
        return entityManager.find(Transaction.class, id);

    }

    public List<Transaction> getTrans(HttpServletRequest request){
        Query q = entityManager.createQuery("SELECT x from Transaction x where x.user_id=:id");
        HttpSession sess = request.getSession();
        User currentUser = (User) sess.getAttribute("user");
        q.setParameter("id", currentUser.getId());
        return q.getResultList();
    }

    @Override
    public void applyChanges(Transaction transaction){
        entityManager.merge(transaction);
    }

}
