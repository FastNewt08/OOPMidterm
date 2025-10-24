class BankAccount$ {
    private String ownerName;
    private String accountNumber;
    private double balance;
    private static int totalAccounts = 0;

    BankAccount$ (String ownerName, String accountNumber, double initialBalance) {
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
        if (amount < 0){
            System.out.println("Invalid amount.");
            return;
        }
        balance += amount;
        System.out.println(getOwnerName() + "'s balance after the deposit: " + getBalance());
    }
    public boolean withdraw(double amount){
        if (amount <= balance && amount > 0){
            balance -= amount;
            System.out.println(getOwnerName() + "'s balance after the withdraw: " + getBalance());
            return true;
        } else {
            System.out.println(getOwnerName() + "'s balance after the withdraw: " + getBalance());
            return false;
        }
    }
}
public class BankAccountManager$ {
    public static void main(String[] args) {
        BankAccount$ b1  = new BankAccount$("Arel", "0909", 10000);
        BankAccount$ b2  = new BankAccount$("Nirro", "0910", 10000);
        BankAccount$ b3  = new BankAccount$("Clay", "0911", 10000);

        b1.deposit(9999);
        b2.withdraw(5000);
        b3.withdraw(900000);

        System.out.println("Total Bank Accounts: " + BankAccount$.getTotalAccounts());
    }
}
