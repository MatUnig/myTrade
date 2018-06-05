package com.trading.currency.dao;

import com.trading.currency.model.Currency;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@Component
public class CurrencyDao {
    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("myDatabaseConfig");
    EntityManager currencyManager = entityManagerFactory.createEntityManager();
    public List<Currency> getAll(){
        Query q = currencyManager.createQuery("SELECT shortName from Currency x");
        return q.getResultList();
    }
}
