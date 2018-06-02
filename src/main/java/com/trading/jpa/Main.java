//package com.trading.jpa;
//
//import com.trading.registration.model.User;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory =
//                Persistence.createEntityManagerFactory("myDatabaseConfig");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        // Tworzenie obiektu, aby dodać go do bazy danych przez Hibernate
//        User Admin = new User();
//
//        // Relacja jeden do wielu ! user -> tranzakcje !
//        Transaction first = new Transaction();
//        first.setPrice(50.00);
//        Transaction second = new Transaction();
//        second.setPrice(500.00);
//        second.setProduct("Sugar");
//        Admin.setName("Mateusz");
//        Admin.setSurname("Uniatowski");
//        Admin.setBalance(5000);
//        List<Transaction> tranzakcje = new ArrayList<Transaction>();
//        tranzakcje.add(first);
//        tranzakcje.add(second);
//        Admin.setTrans(tranzakcje);
//
//        //Dodawanie obiektu do bazy danych
//        entityManager.getTransaction().begin();
//        entityManager.persist(first);
//        entityManager.persist(second);
//        entityManager.persist(Admin);
//        entityManager.getTransaction().commit();
//
//        entityManager.close();
//        entityManagerFactory.close();
//    }
//}
