package com.example.java;

import java.util.Scanner;

public class Account {

    Scanner sc = new Scanner(System.in);

    // instance variables
    private String name;
    private double balance;

//    private double updatedBalance;

    // Constructor
    public Account() {
        balance = 0d;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Methods
    public double showBalance() {
        return getBalance();
    }

    public double makeDeposit(String amount) {
        double numAmount = Double.parseDouble(amount);
        double total = this.balance + numAmount;
        return total;
    }

    public double makeWithdrawal(String amount) {
        // Check for negative balance
        double numAmount = Double.parseDouble(amount);
        if (this.balance <= numAmount) {
            System.out.println("Hold up! Looks like you're going to go broke if we let you do this to yourself.");
            System.out.println("This is for your own good... and ours X-D!");
            System.out.println("Goodbye!");
            return 0;
        } else {
            double total = this.balance - numAmount;
            return total;
        }
    }
}