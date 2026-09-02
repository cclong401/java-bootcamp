package com.academy.bank;

public abstract class Account {

    private String accountNumber;
    private double balance;
    private Customer customer;

    protected Account(String accountNumber, double balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void deposit(double amount) {
        // reject amount <= 0; otherwise add amount to balance
        if (amount <= 0) System.out.println("Amount must be greater than 0.");
        else {
            balance += amount;
            System.out.println("Deposited " + amount);
        }
    }

    public boolean withdraw(double amount) {
        // reject amount <= 0
        // totalDeduction = amount + calculateCharges(); fail if > balance
        // subtract totalDeduction from balance; return true/false
        if (amount <= 0) {
            System.out.println("Amount must be greater than 0.");
            return false;
        }
        else {
            double totalDeduction = amount + calculateCharges();
            if (totalDeduction > balance) {
                System.out.println("Insufficient funds.");
                return false;
            }
            else {
                balance -= totalDeduction;
                System.out.println("Withdrew " + totalDeduction);
            }
        }
        return true;
    }

    public abstract void displayAccount();

    public double calculateCharges() {
        return 0.0;
    }

    public double calculateInterest() {
        return 0.0;
    }

    public String getAccountType() {
        return "Account";
    }
}
