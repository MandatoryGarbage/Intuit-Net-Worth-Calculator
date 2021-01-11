package com.rao.domain;

public class Liability {
    private int category;
    private String lineItem;
    private double monthlyPayment;
    private double amount;

    public Liability(int category, String lineItem, double monthlyPayment, double amount) {
        this.setCategory(category);
        this.setLineItem(lineItem);
        this.setMonthlyPayment(monthlyPayment);
        this.setAmount(amount);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
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
