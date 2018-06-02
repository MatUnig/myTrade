package com.trading.transaction.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private int id;        // auto
    private String type;   // from button
    private double price;  // from json
    private String product; // from jsp
    private Timestamp date;
    private int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", product='" + product + '\'' +
                ", date=" + date +
                '}';
    }

    public Timestamp getDate() {
        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        date = new Timestamp(now.getTime());
        return date;
    }

    public void setDate(Timestamp date) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
