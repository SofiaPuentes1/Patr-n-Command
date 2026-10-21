package command;

import receiver.BankAccount;

public class WithdrawCommand implements Command {

    private BankAccount account;
    private double amount;
    private boolean executed;

    public WithdrawCommand(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
        this.executed = false;
    }

    public void execute() {
        executed = account.withdraw(amount);
        if (executed) {
            System.out.println("Withdrew " + amount + " from account " + account.getAccountNumber());
        } else {
            System.out.println("Withdrawal failed for account " + account.getAccountNumber());
        }
    }

    public void undo() {
        if (executed) {
            account.deposit(amount);
            executed = false;
            System.out.println("Undo withdrawal: deposited " + amount + " into account " + account.getAccountNumber());
        } else {
            System.out.println("Nothing to undo for this withdrawal");
        }
    }
}