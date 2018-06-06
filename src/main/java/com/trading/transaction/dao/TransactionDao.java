package com.trading.transaction.dao;


import com.trading.transaction.model.Transaction;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class TransactionDao {


    @PersistenceContext
    EntityManager entityManager;


    public void updateTrans(Transaction entity){
        entityManager.merge(entity);
    }
}
