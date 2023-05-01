package com.learntocode;

import java.io.*;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String choice = "Z";

        while (!choice.equalsIgnoreCase("x")) {
            System.out.println("HOME SCREEN  \n--------------");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextLine();

            switch (choice) {
                case "D":
                    AddDeposit();
                    break;

                case "P":
                    MakePayment();
                    break;

                case "L":
                    Ledger();
                    break;

                case "X":
                    System.out.println("Exiting the application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }


        }


    }


    //Add Deposit - prompt user for the deposit information and save it to the csv file
    private static void AddDeposit() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your deposit information");
        System.out.println("Enter date: ");
        String date = scanner.nextLine();

        System.out.println("Enter time: ");
        String time = scanner.nextLine();

        System.out.println("Enter description: ");
        String description = scanner.nextLine();

        System.out.println("Enter vendor: ");
        String vendor = scanner.nextLine();

        System.out.println("Enter amount: ");
        double amount = scanner.nextDouble();





        //date|time|description|vendor|amount
        FileWriter writer = new FileWriter("transactions.csv");
        writer.write(date+"|"+time+"|"+description+"|"+vendor+"|$"+amount);
        //System.out.println(deposit);

        writer.close();

    }

    // P) Make Payment (Debit) - prompt user for the debit information and save it to the csv file

    private static void MakePayment() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your debit information");
        System.out.println("Enter date: ");
        String date = scanner.nextLine();

        System.out.println("Enter time: ");
        String time = scanner.nextLine();

        System.out.println("Enter description: ");
        String description = scanner.nextLine();

        System.out.println("Enter vendor: ");
        String vendor = scanner.nextLine();

        System.out.println("Enter amount: ");
        double amount = scanner.nextDouble();



        FileWriter writer = new FileWriter("transactions.csv");
        writer.write(date+"|"+time+"|"+description+"|"+vendor+"|"+"$-"+amount);


        writer.close();

    }
    private static void display() throws IOException {

        FileReader fileReader = new FileReader("transactions.csv");
        BufferedReader bufReader = new BufferedReader(fileReader);
        String input;

        while((input = bufReader.readLine()) != null) {
            System.out.println(input);

            bufReader.close();
        }
    }

    private static void Ledger() throws IOException {
        // display the ledger screen
        Scanner scanner = new Scanner(System.in);
        String choice = "z";

        while(!choice.equalsIgnoreCase("H")) {
        System.out.println("A) All");
        System.out.println("D) Deposits");
        System.out.println("P) Payments");
        System.out.println("R) Reports");
        System.out.println("H) Home");
        System.out.println("Enter your option: ");
        choice = scanner.nextLine();


        switch (choice) {
            case "A":
                display();
                break;

            case "D":

            case "P":

            case "R":

            case "H":
                System.out.println("Welcome back");

        }


    }

    }
}




























/* private static void getTransaction() {
        File transactionsFile = new File("transactions.csv");
        try {
            Scanner scanner = new Scanner(transactionsFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                String date = parts[0];
                String time = parts[1];
                String description = parts[2];
                String vendor = parts[3];
                double amount = Double.parseDouble(parts[4]);
                //inventory.add(new Product(id, name, price));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Transactions file not found.");
        }
    }

*/