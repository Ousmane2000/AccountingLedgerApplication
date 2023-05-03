package com.learntocode;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private static final String FILE_NAME = "transactions.csv";
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIME_FORMAT = "HH:mm:ss";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);


    public static void main(String[] args) throws IOException {
        loadTransactions(FILE_NAME);
        Scanner scanner = new Scanner(System.in);
        String choice = "";

        while (!choice.equalsIgnoreCase("x")) {
            System.out.println("HOME SCREEN  \n--------------");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextLine().trim();

            switch (choice.toUpperCase()) {
                case "D":
                    addDeposit(scanner);
                    break;

                case "P":
                    MakePayment(scanner);
                    break;

                case "L":
                    displayLedger();
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
    private static void addDeposit(Scanner scanner){
        try {

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
            FileWriter writer = new FileWriter(FILE_NAME ,true);
            writer.write(date+"|"+time+"|"+description+"|"+vendor+"|$"+amount+ "\n");


            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    // P) Make Payment (Debit) - prompt user for the debit information and save it to the csv file

    private static void MakePayment(Scanner scanner) {

            try {
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

                //date|time|description|vendor|amount
                FileWriter writer = new FileWriter(FILE_NAME ,true);
                writer.write(date+"|"+time+"|"+description+"|"+vendor+"|$-"+amount+ "\n");


                writer.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    private static void displayLedger() throws IOException {
        // display the ledger screen
        Scanner scanner = new Scanner(System.in);
        String choice = " ";

        while(!choice.equalsIgnoreCase("H")) {
            System.out.println("WELCOME TO THE LEDGER SCREEN  \n----------------");
        System.out.println("A) All");
        System.out.println("D) Deposits");
        System.out.println("P) Payments");
        System.out.println("R) Reports");
        System.out.println("H) Home");
        System.out.println("Enter your option: ");
        choice = scanner.nextLine().trim();


        switch (choice.toUpperCase()) {
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
    private static void display() throws IOException {

        FileReader fileReader = new FileReader(FILE_NAME);
        BufferedReader bufReader = new BufferedReader(fileReader);
        String input;

        while((input = bufReader.readLine()) != null) {
            System.out.println(input);

            //bufReader.close();
        }
    }
    private static void displayDeposits() {
        


        // This method should display a table of all deposits in the `transactions` ArrayList.
        // The table should have columns for date, time, vendor, and amount.
        // The total amount of all deposits should be displayed at the bottom of the table.
    }

    private static void displayPayments() {
        // This method should display a table of all payments in the `transactions` ArrayList.
        // The table should have columns for date, time, vendor, and amount.
        // The total amount of all payments should be displayed at the bottom of the table.
    }

    private static void reportsMenu(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Reports");
            System.out.println("Choose an option:");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    // Generate a report for all transactions within the current month,
                    // including the date, vendor, and amount for each transaction.
                    // The report should include a total of all transaction amounts for the month.
                case "2":
                    // Generate a report for all transactions within the previous month,
                    // including the date, vendor, and amount for each transaction.
                    // The report should include a total of all transaction amounts for the month.
                case "3":
                    // Generate a report for all transactions within the current year,
                    // including the date, vendor, and amount for each transaction.
                    // The report should include a total of all transaction amounts for the year.

                case "4":
                    // Generate a report for all transactions within the previous year,
                    // including the date, vendor, and amount for each transaction.
                    // The report should include a total of all transaction amounts for the year.
                case "5":
                    // Prompt the user to enter a vendor name, then generate a report for all transactions
                    // with that vendor, including the date, vendor, and amount for each transaction.
                    // The report should include a total of all transaction amounts for the vendor.
                case "0":
                    running = false;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }


    private static void filterTransactionsByDate(LocalDate startDate, LocalDate endDate) {
        // This method filters the transactions by date and prints a report to the console.
        // It takes two parameters: startDate and endDate, which represent the range of dates to filter by.
        // The method loops through the transactions list and checks each transaction's date against the date range.
        // Transactions that fall within the date range are printed to the console.
        // If no transactions fall within the date range, the method prints a message indicating that there are no results.
    }

    private static void filterTransactionsByVendor(String vendor) {
        // This method filters the transactions by vendor and prints a report to the console.
        // It takes one parameter: vendor, which represents the name of the vendor to filter by.
        // The method loops through the transactions list and checks each transaction's vendor name against the specified vendor name.
        // Transactions with a matching vendor name are printed to the console.
        // If no transactions match the specified vendor name, the method prints a message indicating that there are no results.
    }

    /*private static void getTransaction() {
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
    public static void loadTransactions(String FILE_NAME) {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Failed to create transactions file");
                return;
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("|");
                if (parts.length != 5) {
                    System.err.println("Invalid transaction format: " + line);
                    continue;
                }
                LocalDate date = LocalDate.parse(parts[0], DATE_FORMATTER);
                LocalTime time = LocalTime.parse(parts[1], TIME_FORMATTER);
                String description = parts[2];
                String vendor = parts[3].toUpperCase();
                double amount = Double.parseDouble(parts[4]);

                transactions.add(new Transaction(date, time, description, vendor, amount));
            }
        } catch (IOException e) {
            System.err.println("Failed to read transactions file");
        }
    }
        // This method should load transactions from a file with the given file name.
        // If the file does not exist, it should be created.
        // The transactions should be stored in the `transactions` ArrayList.
        // Each line of the file represents a single transaction in the following format:
        // <date>,<time>,<vendor>,<type>,<amount>
        // For example: 2023-04-29,13:45:00,Amazon,PAYMENT,29.99
        // After reading all the transactions, the file should be closed.
        // If any errors occur, an appropriate error message should be displayed.



}