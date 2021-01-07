package com.rao.domain;

public class Liability {
    private int category;
    private String lineItem;
    private float monthlyPayment;
    private float amount;

    public Liability(int category, String lineItem, float monthlyPayment, float amount) {
        this.setCategory(category);
        this.setLineItem(lineItem);
        this.setMonthlyPayment(monthlyPayment);
        this.setAmount(amount);
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(float monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
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
