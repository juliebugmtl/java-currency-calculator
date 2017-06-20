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
public class CurrencyData {

    private int id;
    private String currencyCode;
    private String buyPerCAD;
    private String sellPerCAD;


    public CurrencyData(int id, String currencyCode, String buyPerCAD, String sellPerCAD) {
        super();
        this.id = id;
        this.currencyCode = currencyCode;
        this.buyPerCAD = buyPerCAD;
        this.sellPerCAD = sellPerCAD;
    }

    public CurrencyData() {
        super();
        this.id = -1;
        this.currencyCode = "";
        this.buyPerCAD = "";
        this.sellPerCAD = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getBuyPerCAD() {
        return buyPerCAD;
    }

    public void setBuyPerCAD(String buyPerCAD) {
        this.buyPerCAD = buyPerCAD;
    }

    public String getSellPerCAD() {
        return sellPerCAD;
    }

    public void setSellPerCAD(String sellPerCAD) {
        this.sellPerCAD = sellPerCAD;
    }

    @Override
    public String toString() {
        String s =
        "            ID = " + id + "\n" +
        "   currencyCode = " + currencyCode + "\n" +
        "         buyPerCAD = " + buyPerCAD + "\n" +
        "            sellPerCAD = " + sellPerCAD + "\n";
        
        return s;
    }
}