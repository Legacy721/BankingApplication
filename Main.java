package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount object1 = new BankAccount("Enoch Innocent", "123");
        object1.showMenu();

    }
}

class BankAccount{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname, String cid){
        customerName = cname;
        customerId = cid;
    }


    void deposit(int amount){
        if (amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw (int amount){
        if (amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if (previousTransaction > 0){
            System.out.println("Deposited:" + previousTransaction);
        }
        else if (previousTransaction < 0){
            System.out.println("Withdrawn:" + Math.abs(previousTransaction));
        }
        else {
            System.out.println("No transaction occurred ");

        }

    }

    void showMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome "+customerName);
        System.out.println("Your Id is "+customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do{
            System.out.println("====================================================");
            System.out.println("Choose an option: ");
            System.out.println("====================================================");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch(option){
                case 'A':
                    System.out.println("-------------------------------------");
                    System.out.println("Balance "+balance);
                    System.out.println("-------------------------------------");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("-------------------------------------");
                    System.out.println("Enter amount to be deposited: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("-------------------------------------");
                    System.out.println("Enter amount to be withdrawn: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("--------------------------------------");
                    getPreviousTransaction();
                    System.out.println("--------------------------------------");
                    System.out.println("\n");
                    break;

                default:
                    System.out.println("Invalid option!!! Please try another option again.");
                    break;

            }
        } while (option != 'E');
        System.out.println("Thank you for choosing our serviced");

    }
}