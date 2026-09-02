package com.academy.bank;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BankService {

    private static final int MAX_CUSTOMERS = 50;
    private static final int MAX_ACCOUNTS = 100;
    private static final int MAX_TRANSACTIONS = 500;

    private final Customer[] customers = new Customer[MAX_CUSTOMERS];
    private final Account[] accounts = new Account[MAX_ACCOUNTS];
    private final Transaction[] transactions = new Transaction[MAX_TRANSACTIONS];

    private int customerCount = 0;
    private int accountCount = 0;
    private int transactionCount = 0;
    private int nextAccountNumber = 10001;
    private int nextTransactionNumber = 1;

    private final Scanner scanner;

    public BankService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void createCustomer() {
        // read customerId / name / email / phone; reject duplicate IDs
        // store new Customer; print "Customer Created Successfully."
        String id, name, email, phone;

        System.out.print("Customer ID: ");
        String idInput = scanner.nextLine();
        for (int i = 0; i < customerCount; i++) {
            if (idInput.equals(customers[i].getCustomerId())) {
                System.out.println("Customer already exists");
                return;
            }
        }
        id = idInput;

        System.out.print("Name: ");
        name = scanner.nextLine();

        System.out.print("email: ");
        email = scanner.nextLine();

        System.out.print("Phone: ");
        phone = scanner.nextLine();

        customers[customerCount++] = new Customer(id, name, email, phone);
        System.out.println("Customer created successfully");
    }

    public void createSavingsAccount() {
        // read existing customer, initial balance, interest rate
        // create SavingsAccount with nextAccountNumber++; store in accounts[]
        Customer customer = readExistingCustomer();
        if (customer == null) return;

        SavingsAccount account = new SavingsAccount(
                String.valueOf(nextAccountNumber++),
                10000,
                customer,
                5
        );
        accounts[accountCount++] = account;
        System.out.println("Savings account created successfully");
        account.printDetails();
    }

    public void createCurrentAccount() {
        // read existing customer, initial balance, transaction fee
        // create CurrentAccount with nextAccountNumber++; store in accounts[]
        Customer customer = readExistingCustomer();
        if (customer == null) return;

        CurrentAccount account = new CurrentAccount(
                String.valueOf(nextAccountNumber++),
                10_000,
                customer,
                5
        );
        accounts[accountCount++] = account;
        System.out.println("Account created successfully");
        account.printDetails();
    }

    public void deposit() {
        // read existing account + amount; account.deposit; recordTransaction DEPOSIT
        // print updated balance
        Account account = readExistingAccount();
        if (account == null) return;

        System.out.println("Current balance: " +  account.getBalance());

        System.out.print("Deposit amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        account.deposit(amount);

        recordTransaction(account.getAccountNumber(), amount, "DEPOSIT");
        System.out.println("New balance: " +   account.getBalance());
    }

    public void withdraw() {
        // read existing account + amount; account.withdraw; record on success
        // for CurrentAccount, print fee + total deducted; print updated balance
        Account account = readExistingAccount();
        if (account == null) return;

        System.out.println("Current balance: " +  account.getBalance());

        System.out.print("Withdraw amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        if (account.withdraw(amount)){
            recordTransaction(account.getAccountNumber(), amount, "WITHDRAW");
            if(account.getAccountType().equals("Current")) {
                System.out.println("Total = " + amount + " + fee of " + account.calculateCharges());
            }
            System.out.println("New balance: " +  account.getBalance());
        }
    }

    public void displayAccounts() {
        // TODO: if empty print message; else loop displayAccount() for each
        if (accountCount == 0) {
            System.out.println("No accounts exist");
            return;
        }

        System.out.println("----------------------------------");
        for (int i = 0; i < accountCount; i++) {
            accounts[i].displayAccount();
            System.out.println("----------------------------------");
        }
    }

    public void displayCustomers() {
        if (customerCount == 0) {
            System.out.println("No customers available.");
            return;
        }

        System.out.println("----------------------------------");
        for (int i = 0; i < customerCount; i++) {
            customers[i].printDetails();
            System.out.println("----------------------------------");
        }
    }

    public void transferMoney() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    public void displayTransactionHistory() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    public void displayAccountsSortedByBalance() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    public void displayHighestBalanceCustomer() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    public void generateAccountSummaryReport() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    private Customer readExistingCustomer() {
        if (customerCount == 0) {
            System.out.println("Create a customer first.");
            return null;
        }

        System.out.print("Customer ID : ");
        String customerId = scanner.nextLine().trim();
        Customer customer = findCustomer(customerId);

        if (customer == null) {
            System.out.println("Customer not found.");
        }

        return customer;
    }

    private Account readExistingAccount() {
        if (accountCount == 0) {
            System.out.println("No accounts available.");
            return null;
        }

        System.out.print("Account Number : ");
        String accountNumber = scanner.nextLine().trim();
        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
        }

        return account;
    }

    private Customer findCustomer(String customerId) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getCustomerId().equalsIgnoreCase(customerId)) {
                return customers[i];
            }
        }
        return null;
    }

    private Account findAccount(String accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null;
    }

    private void recordTransaction(String accountNumber, double amount, String type) {
        if (transactionCount >= MAX_TRANSACTIONS) {
            return;
        }

        String transactionId = "T" + nextTransactionNumber++;
        String date = LocalDate.now().toString();
        transactions[transactionCount++] = new Transaction(transactionId, amount, type, date, accountNumber);
    }

    private double readPositiveAmount(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value < 0) {
                    System.out.println("Amount must not be negative.");
                    continue;
                }
                return value;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid amount. Please try again.");
            }
        }
    }
}
