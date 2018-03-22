package com.akshayboth.tapit.pojo;

import java.io.Serializable;

/**
 * Created by akshayboth on 21/03/18.
 */

public class BudgetItem implements Serializable {

    private String budgetName;
    private String budgetType; // few pre defined types // need to think about it
    private int budgetAmount;
    private int spentAmount;
    private String imageURL;
    private int resId;

    public BudgetItem(String budgetName, String budgetType, int budgetAmount, int spentAmount, String imageURL) {
        this.budgetName = budgetName;
        this.budgetType = budgetType;
        this.budgetAmount = budgetAmount;
        this.spentAmount = spentAmount;
        this.imageURL = imageURL;
    }

    public BudgetItem(String budgetName, String budgetType, int budgetAmount, int spentAmount, int resId) {
        this.budgetName = budgetName;
        this.budgetType = budgetType;
        this.budgetAmount = budgetAmount;
        this.spentAmount = spentAmount;
        this.resId = resId;
    }

    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    public String getBudgetType() {
        return budgetType;
    }

    public void setBudgetType(String budgetType) {
        this.budgetType = budgetType;
    }

    public int getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(int budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public int getSpentAmount() {
        return spentAmount;
    }

    public void setSpentAmount(int spentAmount) {
        this.spentAmount = spentAmount;
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
}
