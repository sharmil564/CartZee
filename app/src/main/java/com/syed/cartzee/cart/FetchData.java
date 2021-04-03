package com.syed.cartzee.cart;

public class FetchData {
    String proname, prodesc, proamnt;

    public FetchData() {
    }

    public FetchData(String name, String desc, String price) {
        this.proname = name;
        this.prodesc = desc;
        this.proamnt = price;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getProdesc() {
        return prodesc;
    }

    public void setProdesc(String prodesc) {
        this.prodesc = prodesc;
    }

    public String getProamnt() {
        return proamnt;
    }

    public void setProamnt(String proamnt) {
        this.proamnt = proamnt;
    }
}