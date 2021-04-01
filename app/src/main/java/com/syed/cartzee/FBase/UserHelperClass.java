package com.syed.cartzee.FBase;

public class UserHelperClass {
    String FName,LName,Gend,Dateob,Address,Mobile,Email,Password;

    public UserHelperClass() {
    }

    public UserHelperClass(String FName, String LName, String gend, String dateob, String address, String mobile, String email, String password) {
        this.FName = FName;
        this.LName = LName;
        Gend = gend;
        Dateob = dateob;
        Address = address;
        Mobile = mobile;
        Email = email;
        Password = password;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getGend() {
        return Gend;
    }

    public void setGend(String gend) {
        Gend = gend;
    }

    public String getDateob() {
        return Dateob;
    }

    public void setDateob(String dateob) {
        Dateob = dateob;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
