public class BankPractice {
    private String ownerName;
    private String accountNumber;
    private double balance;
    private static int totalAccounts = 0;

    public BankPractice(String ownerName, String accountNumber, double initialBalance) {
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
    public double getBalance() {
        return balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public void depositMoney(double amount){
        if (amount <= 0){
            System.out.println("Invalid amount.");
            return;
        } else {
            balance += amount;
            System.out.println(getOwnerName() + " 's balance after deposit: " + getBalance());
        }
    }
    public boolean withdraw(double amount){
        if (amount > balance){
            System.out.println("Not enough balance.");
            return false;
        } else {
            balance -= amount;
            System.out.println(getOwnerName() + " 's balance after withdraw" + getBalance());
            return true;
        }
    }
    public void displayInfo(){
        System.out.println("Account holder: " + getOwnerName());
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Account balance: " + getBalance());
        System.out.println("=====================================");
    }

    public static void main(String[] args) {
        BankPractice acc0 = new BankPractice("Shin", "0213134", 45000);
        BankPractice acc1 = new BankPractice("Ikki", "0123121", 900);
        BankPractice acc2 = new BankPractice("Shin", "4324111", 32000);

        acc1.depositMoney(0);
        acc1.depositMoney(1000);
        acc0.withdraw(37000);
        acc2.withdraw(32000.1);

        acc0.displayInfo();
        acc1.displayInfo();
        acc2.displayInfo();
    }
}
