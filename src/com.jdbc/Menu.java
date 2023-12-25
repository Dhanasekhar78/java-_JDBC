package com.jdbc;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class Menu {

    private final Bank bank;

    public Menu() {
        this.bank = new Bank();
    }

    public void drive() {



        while (true) {
            showMenu();

            Scanner scanner = new Scanner(System.in);
            try {

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        this.addNewAccount();
                        break;
                    case 2:
                        this.showListOfCustomers();
                        break;
                    case 3:
                        this.searchCustomer();
                        break;
                    case 4:
                        this.deleteCustomer();
                        break;
                    case 5:
                        System.out.println("Exiting the application. Bye.");
                        return;

                    default:
                        System.out.println("Invalid option selected. Try again");
                        break;
                }
            } catch (RuntimeException ex) {
                System.out.println("Invalid input. Only numbers: 1 to 5");
            }
        }




    }

    public void showMenu(){

        System.out.println("Please enter your choice: ");
        System.out.println("1. Add a new Account");
        System.out.println("2. Show customer list");
        System.out.println("3. Search for a customer");
        System.out.println("4. Delete a customer");
        System.out.println("5. Exit");


    }


    public void addNewAccount(){

        try{

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter first name:");
            String fname = scanner.nextLine();
            System.out.println("Enter last name:");
            String lname = scanner.nextLine();
            System.out.println("Enter email:");
            String email = scanner.nextLine();
            System.out.println("Enter city:");
            String city = scanner.nextLine();
            System.out.println("Enter contact number:");
            long contact = Long.parseLong(scanner.nextLine());
            System.out.println("Enter Account Type: ");
            String accountType = scanner.nextLine();
            System.out.println("Enter balance: ");
            int balance = scanner.nextInt();
            bank.addCustomer(fname, lname, email, city, contact, accountType,balance);

        }
        catch (RuntimeException re) {
            System.out.println("Invalid input. Only numbers.");
        }


    }



    public void showListOfCustomers() {
        System.out.println("All Customers:");
        bank.showListOfCustomers();
    }


    public void searchCustomer() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the Customer accountNumber (Search):");
            int accNum = Integer.parseInt(scanner.nextLine());
            bank.displayCustomer(accNum);
        } catch (RuntimeException re) {
            System.out.println("Invalid input. Only numbers.");
        }
    }

    public void deleteCustomer() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the Customer ID (Delete):");
            int accNum = Integer.parseInt(scanner.nextLine());
            bank.deleteCustomer(accNum);
        } catch (RuntimeException re) {
            System.out.println("Invalid input. Only numbers.");
        }
    }


}

