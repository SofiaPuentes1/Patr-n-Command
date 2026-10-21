package command;

import receiver.BankAccount;

public class DepositCommand implements Command {

    private BankAccount account;
    private double amount;
    private boolean executed;

    public DepositCommand(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
        this.executed = false;
    }

    public void execute() {
        executed = account.deposit(amount);
        if (executed) {
            System.out.println("Deposited " + amount + " into account " + account.getAccountNumber());
        } else {
            System.out.println("Deposit failed for account " + account.getAccountNumber());
        }
    }

    public void undo() {
        if (executed) {
            account.withdraw(amount);
            executed = false;
            System.out.println("Undo deposit: withdrew " + amount + " from account " + account.getAccountNumber());
        } else {
            System.out.println("Nothing to undo for this deposit");
        }
    }
}