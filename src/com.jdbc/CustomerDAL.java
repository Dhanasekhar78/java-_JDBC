package com.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAL {
    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = null;

        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo1", "root", "Admin@123");
        if (conn != null) {
            return conn;
        } else {
            throw new RuntimeException("Connection error");
        }
    }


    public static List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {
        List<Customer> customers = new ArrayList<>();

        String query = "SELECT * FROM customers";

        Statement stmt = getConnection().createStatement();
        ResultSet results = stmt.executeQuery(query);

        while (results.next()) {
            Customer customer = new Customer();

            customer.setAccNum(results.getInt("accNum"));
            customer.setFname(results.getString("fname"));
            customer.setLname(results.getString("lname"));
            customer.setEmail(results.getString("email"));
            customer.setContact(results.getLong("contact"));
            customer.setCity(results.getString("city"));
            customer.setAccountType(results.getString("account_type"));
            customer.setBalance(results.getInt("balance"));


            customers.add(customer);
        }

        return customers;
    }
    public static Customer getCustomer(int accNum) throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM customers WHERE accNum = ?";

        PreparedStatement pstmt = getConnection().prepareStatement(query);
        pstmt.setInt(1, accNum);
        ResultSet results = pstmt.executeQuery();

        while (results.next()) {
            Customer customer = new Customer();

            customer.setAccNum(results.getInt("accNum"));
            customer.setFname(results.getString("fname"));
            customer.setLname(results.getString("lname"));
            customer.setEmail(results.getString("email"));
            customer.setCity(results.getString("city"));
            customer.setContact(results.getLong("contact"));
            customer.setAccountType(results.getString("account_type"));
            customer.setBalance(results.getInt("balance"));

            return customer;
        }
        throw new RuntimeException("Customer doesn't exist"); // customer doesn't exist

    }

    public static void createCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO customers(fname, lname, email,city, contact, account_type, balance) VALUES (?, ?, ?, ?,?,?,?)";

        PreparedStatement pstmt = getConnection().prepareStatement(sql);

        // replace these ?
        pstmt.setString(1, customer.getFname());
        pstmt.setString(2, customer.getLname());
        pstmt.setString(3, customer.getEmail());
        pstmt.setString(4, customer.getCity());
        pstmt.setLong(5, customer.getContact());
        pstmt.setString(6, customer.getAccountType());
        pstmt.setInt(7,customer.getBalance());

        pstmt.execute();
    }



    public static void deleteCustomer(int accNum) throws ClassNotFoundException, SQLException {
        String query = "DELETE FROM customers WHERE accNum = ?";

        PreparedStatement pstmt = getConnection().prepareStatement(query);
        pstmt.setInt(1, accNum);
        pstmt.execute();
    }





}
