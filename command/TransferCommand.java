package command;

import receiver.BankAccount;

public class TransferCommand implements Command {

    private BankAccount source;
    private BankAccount destination;
    private double amount;
    private boolean executed;

    public TransferCommand(BankAccount source, BankAccount destination, double amount) {
        this.source = source;
        this.destination = destination;
        this.amount = amount;
        this.executed = false;
    }

    public void execute() {
        executed = source.transfer(destination, amount);
        if (executed) {
            System.out.println("Transferred " + amount + " from account " + source.getAccountNumber()
                    + " to account " + destination.getAccountNumber());
        } else {
            System.out.println("Transfer failed from account " + source.getAccountNumber());
        }
    }

    public void undo() {
        if (executed) {
            destination.transfer(source, amount);
            executed = false;
            System.out.println("Undo transfer: returned " + amount + " from account "
                    + destination.getAccountNumber() + " to account " + source.getAccountNumber());
        } else {
            System.out.println("Nothing to undo for this transfer");
        }
    }
}