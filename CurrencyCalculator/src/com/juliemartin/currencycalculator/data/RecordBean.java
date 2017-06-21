/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juliemartin.currencycalculator.data;

/**
 *
 * @author Julie Martin
 */
public class RecordBean {
    
    private String currencyCode;
    private double sellPerCAD;
    private double buyPerCAD;
    
    public RecordBean() {
        currencyCode = new String("");
        sellPerCAD = new double;
        buyPerCAD = new double;
           
    }

        public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public double sellPerCAD() {
        return sellPerCAD;
    }

    public void setSellPerCAD(double sellPerCAD) {
        this.sellPerCAD = sellPerCAD;
    }

    public double buyPerCAD() {
        return buyPerCAD;
    }

    public void buySellPerCAD(double buyPerCAD) {
        this.buyPerCAD = buyPerCAD;
    }

}
