package com.jdbc;

public class Customer {

    private int accNum;
    private String fname;

    private String lname;

    private String email;

    private String city;

    private long contact;

    private String accountType;

    private int balance;

    public Customer() {

    }

    public Customer(int accNum, String fname, String lname, String email, String city, long contact, String accountType, int balance) {
        this.accNum = accNum;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.city = city;
        this.contact = contact;
        this.accountType = accountType;
        this.balance = balance;
    }

    public Customer(String fname, String lname, String email, String city, long contact, String accountType, int balance) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.city = city;
        this.contact = contact;
        this.accountType = accountType;
        this.balance = balance;
    }

    public int getAccNum() {
        return accNum;
    }

    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "accNum=" + accNum +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", contact=" + contact +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                '}';
    }
}
