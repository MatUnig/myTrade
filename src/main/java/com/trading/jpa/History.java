package com.trading.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
// @Entity(name="Tabela historii oraz nazwa entity - do odnoszenia sie w encjach)
@Entity
public class History {
    @Id
    @GeneratedValue
    private int id;
    private String type;
    private String product;
    private double price;
    private double profit;
    private double openPrice;
    private double closePrice;
    private Timestamp closeDate;

}