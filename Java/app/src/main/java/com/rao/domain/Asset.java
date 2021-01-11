package com.rao.domain;

public class Asset {
    private int category;
    private String lineItem;
    private double amount;

    public Asset(int category, String lineItem, double amount) {
        this.setCategory(category);
        this.setLineItem(lineItem);
        this.setAmount(amount);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getLineItem() {
        return lineItem;
    }

    public void setLineItem(String lineItem) {
        this.lineItem = lineItem;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
