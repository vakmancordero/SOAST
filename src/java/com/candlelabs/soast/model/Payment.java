package com.candlelabs.soast.model;

import java.util.Date;

/**
 *
 * @author VakSF
 */
public class Payment {
    
    private double amount;
    private String bank;
    private String clabe;
    
    public Payment() {
        
    }
    
    public Payment(double amount, String bank, String clabe) {
        this.amount = amount;
        this.bank = bank;
        this.clabe = clabe;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    @Override
    public String toString() {
        return "Payment{" + "amount=" + amount + ", bank=" + bank + ", clabe=" + clabe + '}';
    }
    
}
