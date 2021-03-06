//package com.trading.jpa;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.util.List;
//
//@Entity
//
//public class User {
//    @Id
//    @GeneratedValue
//    private long id;
//    @Column(name = "Name", length = 20)
//    private String name;
//    @Column(name = "Surname", length = 30)
//    private String surname;
//    @Column(name = "Email")
//    private String email;
//    @Column(name = "Username", length = 30)
//    private String username;
//    @Column(name = "Password", length = 40                                                                                                                                                                          )
//    private String password;
//    @Column(precision = 12, scale = 2)
//    private double balance = 10000.00;
//    @OneToMany
//    @JoinColumn(name = "user_id")
//    private List<Transaction> trans;
//
//
//    public List<Transaction> getTrans() {
//        return trans;
//    }
//
//    public void setTrans(List<Transaction> trans) {
//        this.trans = trans;
//    }
//
//    public double getBalance() {
//        return balance;
//    }
//
//    public void setBalance(double balance) {
//        this.balance = balance;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//}
