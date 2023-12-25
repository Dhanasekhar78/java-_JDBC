package com.jdbc;

import java.sql.SQLException;

public class Bank {

    public void addCustomer(String fname, String lname, String email, String city,long contact, String accountType,int balance) {
        Customer customer = new Customer(fname, lname, email, city, contact, accountType, balance);
        try {
            CustomerDAL.createCustomer(customer);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void showListOfCustomers() {
        try {
            for (Customer customer : CustomerDAL.getAllCustomers()) {
                System.out.println(customer.toString());
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void displayCustomer(int accNum) {
        try {
            Customer customer = CustomerDAL.getCustomer(accNum);
            System.out.println(customer.toString());
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (RuntimeException re) {
            System.out.println("Error: " + re.getMessage());
        }
    }

    public void deleteCustomer(int accNum) {
        try {
            CustomerDAL.deleteCustomer(accNum);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }



}
