package com.syed.cartzee.cart;

public class cart {
    private String pname,price;

    public cart() {
    }

    public cart(String pname, String price) {
        this.pname = pname;
        this.price = price;

    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
