package com.syed.cartzee.FBase;

public class HelperClass {
    String proname,prodesc,proamnt;

    public HelperClass() {

    }
    public HelperClass(String prname,String pdesc,String pamnt)
    {
        this.proname=prname;
        this.prodesc=pdesc;
        this.proamnt=pamnt;
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
