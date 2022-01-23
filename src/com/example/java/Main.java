package com.example.java;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Scanner class for inputs
        Scanner sc = new Scanner(System.in);

        // Currency class for number formatting.
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        // Display Greetings
        System.out.println("\n");
        System.out.println("****************************************************************************");
        System.out.println("* Welcome to the Bank of Java. We are glad to have you here with us today! *");
        System.out.println("****************************************************************************");
        System.out.println(" ");
        System.out.println("Please create a new account by providing some info: ");
        System.out.println(" ");

        // Instantiate an Account object
        Account customerAccount = new Account();

        System.out.print("Please enter your name: ");

        String name = sc.nextLine();
        customerAccount.setName(name);

        String customerName = customerAccount.getName();

        // Run the app using a boolean value
        boolean keepRunning = true;

        System.out.println("Congrats! " + customerName + ", your account has been successfully created!");
        System.out.println("What would you like to do next?");
        System.out.println(" ");

        while (keepRunning) {

            // Present a list of tasks to perform
            System.out.println("\t-(a) Check Account Balance");
            System.out.println("\t-(b) Make a deposit");
            System.out.println("\t-(c) Make a withdrawal");
            System.out.println("\t-(q) Quit");
            System.out.print(">");

            // Get user option using switch statements
            String userOption = sc.nextLine();

            switch (userOption) {
                case "a":
                    double currentBalance = customerAccount.showBalance();
                    System.out.println("Your current balance is " + currency.format(currentBalance));

                    if (currentBalance < 1) {
                        System.out.println("Please make a deposit soon, before we kick you out of this institution for the elite! :-D");
                        System.out.println(" ");
                        System.out.println("What's your next move? ");
                        System.out.println(" ");
                    }
                    break;

                case "b":
                    System.out.println("Wise choice!");
                    System.out.println(" ");
                    System.out.print("Enter the amount you want to deposit: ");

                    // Call the makeDeposit method in the account class.
                    double depositAmount = customerAccount.makeDeposit(sc.nextLine());

                    // Update the current balance in the account
                    customerAccount.setBalance(depositAmount);

                    // Display task status to the user;
                    System.out.println(" ");
                    System.out.println("Your money has successfully been deposited into our pockets... I mean your Account.");
                    System.out.println("Your current balance is now: " + currency.format(customerAccount.getBalance()));
                    System.out.println(" ");
                    break;

                case "c":
                    System.out.println("Not so wise after all, are you?");
                    System.out.println(" ");
                    System.out.print("Enter the amount you want to withdraw: ");

                    // Call the makeDeposit method in the account class.
                    double withdrawalAmount = customerAccount.makeWithdrawal(sc.nextLine());

                    // Continue based on withdrawal amount
                    if (withdrawalAmount > 0) {
                        // Update the current balance in the account
                        customerAccount.setBalance(withdrawalAmount);

                        // Display task status to the user;
                        System.out.println(" ");
                        System.out.println("Your withdrawal was successful!");
                        System.out.println("Your current balance is now: " + currency.format(customerAccount.getBalance()));
                        System.out.println(" ");
                    } else {
                        keepRunning = false;
                    }
                    break;

                case "q":
                    System.out.print("Are you sure you want to leave? (y / n) ");
                    String leav = sc.nextLine();
                    String leave = leav.toLowerCase();

                    switch (leave) {
                        case "y":
                            System.out.println("Goodbye, " + customerName + ".");
                            keepRunning = false;
                            break;

                        case "n":
                            System.out.println(" ");
                            System.out.println("Sweet! What's your next move? ");
                            System.out.println(" ");
                            break;
                        default:
                            System.out.println("Enter 'y' or 'n' to quit or continue ");
                            break;
                    }

                default:
                    System.out.println("Not a recognized option. Choose an option from the menu");
                    System.out.println(" ");
                    break;
            }
        }
    }
}

