package com.rao.domain;

public class DisplayLiability {
    private int category;
    private String lineItem;
    private String monthlyPayment;
    private String amount;

    public DisplayLiability(int category, String lineItem, String monthlyPayment, String amount) {
        this.category = category;
        this.lineItem = lineItem;
        this.setMonthlyPayment(monthlyPayment);
        this.setAmount(amount);
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(String monthlyPayment) {
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
