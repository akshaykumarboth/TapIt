package com.akshayboth.tapit.transaction;

import java.io.Serializable;

/**
 * Created by akshayboth on 22/03/18.
 */

public class TransactionItem implements Serializable {
    private String date;
    private String type; //debit or credit
    private int amount;
    private String descritpion;
    private String imageURL;
    private int resId;

    public TransactionItem(String date, String type, int amount, String descritpion, String imageURL) {
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.descritpion = descritpion;
        this.imageURL = imageURL;
    }

    public TransactionItem(String date, String type, int amount, String descritpion, int resId) {
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.descritpion = descritpion;
        this.resId = resId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

