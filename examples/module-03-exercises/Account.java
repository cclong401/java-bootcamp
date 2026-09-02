public class Account {
    // hide balance from outside code (private field already shown — focus on methods)
    private double balance;

    public Account(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                    "Initial balance cannot be negative");
        }
        balance = initialBalance;
    }

    public void deposit(double amount) {
        // reject non-positive amounts (print message, return early)
        if (amount < 0) {
            System.out.println("Amount cannot be negative");
        }
        else {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        // reject if amount <= 0 OR amount > balance
        if (amount < 0 || amount > balance) {
            System.out.println("Invalid withdrawal amount");
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }

    // read-only accessor — return balance
    public double getBalance() {
        return balance;
    }

    // Exercise 3 will override this method
    public String getAccountType() {
        return "Account";
    }
}
