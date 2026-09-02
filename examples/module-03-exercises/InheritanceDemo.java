public class InheritanceDemo {
    static void main(String[] args) {
        // base-type array holding SavingsAccount(100) and CurrentAccount(100)
        Account[] accounts = {
                new SavingsAccount(100.00),
                new CurrentAccount(100.00),
                new FrozenAccount(100.00),
        };

         for (Account account : accounts) {
             boolean ok = account.withdraw(20.00);
             System.out.printf("%s withdraw=%s balance: %.2f%n",
                     account.getAccountType(),
                     ok,
                     account.getBalance());
         }
    }
}
