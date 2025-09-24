class BankAccount{
    private String ownerName;
    private String accountNumber;
    private double balance;
    private static int totalAccounts = 0;

    public BankAccount(String ownerName, String accountNumber, double initialBalance) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        if (initialBalance < 0){
            this.balance = 0.0;
        } else {
            this.balance = initialBalance;
        }
        totalAccounts++;
    }

    public String getOwnerName() {
        return ownerName;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public void deposit(double amount){
        if (amount <= 0){
            System.out.println("Not enough amount.");
            return;
        } else {
            balance += amount;
            System.out.println(getOwnerName() + " 's balance after depositing: " + getBalance());
        }
    }
    public boolean withdraw(double amount){
        if (amount > balance){
            System.out.println("Not enough amount.");
            return false;
        } else {
            balance -= amount;
            System.out.println(getOwnerName() + " 's balance after withdrawing: " + getBalance());
            return true;
        }
    }
}
public class BankAccountManager {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Arel", "0112121", 100.00);
        BankAccount acc2 = new BankAccount("Kim", "01013213", 10000.00);
        BankAccount acc3 = new BankAccount("Kish", "01301231", 9000.0);

        acc1.deposit(1313242.0);
        acc2.withdraw(2133);
        acc3.withdraw(10000);

        System.out.println("Total bank accounts: " + BankAccount.getTotalAccounts());
    }
}
