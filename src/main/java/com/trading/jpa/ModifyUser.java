//package com.trading.jpa;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.TypedQuery;
//import java.util.List;
//
//// Zmiany na użytkowniku
//
//public class ModifyUser {
//    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory =
//                Persistence.createEntityManagerFactory("myDatabaseConfig");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        User user = entityManager.find(User.class, 1L);  // pobranie użytkownika przez ID
//        user.setBalance(5000.00);   // ustawienia na użytkowniku
//        entityManager.remove(user);  // usunięcie użytkownika - do uzycia przy tranzakcjach
//
//        // wybieranie daneego Usera , ktory spelnia jakis warunek
//        TypedQuery<User> query = entityManager.createQuery("select e from User e where e.id > 1", User.class);
//        query.getFirstResult(); // np wybranie pierwszego rekordu
//
//        List<User>  queriedUserList = query.getResultList();
//        for (User u : queriedUserList){
//            u.getBalance();
//        }
//
//
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        entityManagerFactory.close();
//
//    }
//}
