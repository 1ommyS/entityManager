package com.my.manager;

import java.util.Objects;

/**
 * @author 1ommy
 * @version 30.09.2021
 */
public class Phone {
    private int id;
    private String value;
    private String operator;
    private int balance;

    public Phone(int id, String value, String operator, int balance) {
        this.id = id;
        this.value = value;
        this.operator = operator;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", operator='" + operator + '\'' +
                ", balance=" + balance +
                '}';
    }
}
