package com.rao.domain;

public class DisplayAsset {
    private int category;
    private String lineItem;
    private String amount;

    public DisplayAsset(int category, String lineItem, String amount) {
        this.category = category;
        this.lineItem = lineItem;
        this.setAmount(amount);
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
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
