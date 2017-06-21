/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juliemartin.currencycalculator.data;

/**
 *
 * @author Julie
 */
public class MoneyBean {

    private double value; 
    private double amount;
    private String currency;
    
    public MoneyBean() {
        amount = 0.0;
        value = 0.0;
        currency = new String("");
        
    }

        public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrencyCode(String currency) {
        this.currency = currency;
    }
    
}
