package receiver;

public class BankAccount {

    private String accountNumber;
    private String owner;
    private double balance;

    public BankAccount(String accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance = balance + amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        if (amount > balance) {
            return false;
        }
        balance = balance - amount;
        return true;
    }

    public boolean transfer(BankAccount destination, double amount) {
        boolean withdrawn = withdraw(amount);
        if (withdrawn) {
            destination.deposit(amount);
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return balance;
    }
}