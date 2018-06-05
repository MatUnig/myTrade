package com.trading.transaction.model;

import com.trading.transaction.functions.Function;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private int id;
    private String type;
    private double price;
    private String product;
    private double quantity;
    @Transient
    private double currentPrice;
    @Transient
    private double profit;
    private String fromCurrency;
    private String toCurrency;
    private LocalDateTime date;
    private int user_id;

//    private LocalDateTime updated;
//    @PreUpdate  - wlacza sie przed zrobieniem updatu
//    protect void onUpdate(){
//        updated= LocalDateTime.now();
//    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public double getProfit() {
        return profit;
    }


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

    public LocalDateTime getDate() {
        LocalDateTime.now();
        return date;
    }

    public void setDate(LocalDateTime date) {

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
